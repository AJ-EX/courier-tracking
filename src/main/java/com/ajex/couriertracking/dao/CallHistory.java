package com.ajex.couriertracking.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * The persistent class for the call_history database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="call_history")
public class CallHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="call_date")
	private LocalDateTime callDate;

	@Column(name="call_duration")
	private double callDuration;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="call_end_time")
	private LocalDateTime callEndTime;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="call_start_time")
	private LocalDateTime callStartTime;

	@Column(name="call_type")
	private String callType;

	@Column(name="courier_id")
	private String courierId;

	@Column(name="courier_number")
	private String courierNumber;

	@Column(name="to_number")
	private String toNumber;

	private String waybillno;

}