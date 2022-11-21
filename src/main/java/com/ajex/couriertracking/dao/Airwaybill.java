package com.ajex.couriertracking.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Airwaybill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AIRWAYBILL")
	@SequenceGenerator(name="SEQ_AIRWAYBILL",sequenceName="SEQ_AIRWAYBILL", allocationSize=1)
	Long id;

	@NotNull
	@JsonProperty("waybillNumber")
	private String airwaybillNumber;
	
	private String clientName;
	private String orderId;
	private ZonedDateTime orderTime;
	private Date systemTime;
	private String productCode;
	private String expressType;
	private Double totalDeclaredValue;	
	private String declaredCurrency;
	private Double parcelTotalWeight;
	private Double parcelTotalVolume;
	private String pickupMethod;
	private String paymentMethod;
	private String customerAccount;
	private String buyerName;
	private boolean isInternational;
	private String orderRef2;
	private String orderSource;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ContactInfo senderInfo;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ContactInfo receiverInfo;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	//@JsonProperty("cargoInfoDao")
	private List<CargoInfo> cargoInfo;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	//@JsonProperty("addedServiceDaos")
	private List<AddedService> addedServices = new ArrayList<>();

}
