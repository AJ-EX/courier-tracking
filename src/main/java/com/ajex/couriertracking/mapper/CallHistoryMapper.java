package com.ajex.couriertracking.mapper;

import com.ajex.couriertracking.dao.CallHistory;
import com.ajex.couriertracking.dto.CallHistoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CallHistoryMapper implements EntityMapper<CallHistoryDto, CallHistory> {
    @Override
    public CallHistory toEntity(CallHistoryDto dto) {

        CallHistory callHistory = new CallHistory();
        callHistory.setCallDate(dto.getCallDate());
        callHistory.setCallDuration(dto.getCallDuration());
        callHistory.setCallType(dto.getCallType());
        callHistory.setCallStartTime(dto.getCallStartTime());
        callHistory.setCallEndTime(dto.getCallEndTime());
        callHistory.setCourierId(dto.getCourierId());
        callHistory.setCourierNumber(dto.getCourierNumber());
        callHistory.setToNumber(dto.getToNumber());
        callHistory.setWaybillno(dto.getWaybillno());
        callHistory.setVersion(dto.getVersion());
        callHistory.setLang(dto.getLang());
        callHistory.setLat(dto.getLat());

        return callHistory;
    }

    @Override
    public CallHistoryDto toDto(CallHistory entity) {
        CallHistoryDto callHistoryDto = new CallHistoryDto();
        callHistoryDto.setCallDate(entity.getCallDate());
        callHistoryDto.setCallDuration(entity.getCallDuration());
        callHistoryDto.setCallType(entity.getCallType());
        callHistoryDto.setCallStartTime(entity.getCallStartTime());
        callHistoryDto.setCallEndTime(entity.getCallEndTime());
        callHistoryDto.setCourierId(entity.getCourierId());
        callHistoryDto.setCourierNumber(entity.getCourierNumber());
        callHistoryDto.setToNumber(entity.getToNumber());
        callHistoryDto.setWaybillno(entity.getWaybillno());
        callHistoryDto.setId(entity.getId());
        callHistoryDto.setLang(entity.getLang());
        callHistoryDto.setLat(entity.getLat());
        callHistoryDto.setVersion(entity.getVersion());
        return callHistoryDto;
    }

    @Override
    public List<CallHistory> toEntity(List<CallHistoryDto> dtoList) {
       return dtoList.stream().map(dto -> this.toEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<CallHistoryDto> toDto(List<CallHistory> entityList) {
        return entityList.stream().map(entity -> this.toDto(entity)).collect(Collectors.toList());
     }

    @Override
    public Set<CallHistoryDto> toDto(Set<CallHistory> entityList) {
        return null;
    }
}