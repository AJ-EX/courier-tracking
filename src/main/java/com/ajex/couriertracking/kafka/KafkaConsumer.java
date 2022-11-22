package com.ajex.couriertracking.kafka;

import com.ajex.couriertracking.dao.Airwaybill;
import com.ajex.couriertracking.repository.AirwaybillRepo;
import com.ajex.couriertracking.util.CustomObjectMapper;
import com.ajex.couriertracking.util.JsonValidate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {
	
	@Autowired
	AirwaybillRepo airwaybillRepo;
	

	@Autowired
	CustomObjectMapper customObjectMapper;
	
	@KafkaListener(topics="orders.fact.creations.v1" , groupId="courierOrderGroup1")
	public void createAirwaybill(@RequestBody ConsumerRecord<?, ?>  consumerRecord) {
		try {
			log.info("Message received for waybill details: "+consumerRecord);
			
			ObjectMapper mapper=customObjectMapper.getObjectMapper();
			Airwaybill airwaybill = mapper.convertValue(consumerRecord.value(),Airwaybill.class);
			
			List<String> errors= JsonValidate.validate(airwaybill);
			if(errors.size()==0)
				airwaybillRepo.save(airwaybill);
			else {
				errors.forEach(
						(n) -> log.info(n)
				);
			}
			
		} 
		catch (Exception e) {
			log.error("Exception while consuming the kafka input : {}", consumerRecord);
			log.error("Exception : {}", e);
		}	
	}

}

