package com.ajex.couriertracking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallHistoryDto  {

    private Long id;
    private LocalDateTime callDate;
    private double callDuration;
    private LocalDateTime callEndTime;
    private LocalDateTime callStartTime;
    @Size(max = 255)
    private String callType;
    @Size(max = 255)
    private String courierId;
    @Size(max = 255)
    private String courierNumber;
    @Size(max = 255)
    private String toNumber;
    private String waybillno;


}