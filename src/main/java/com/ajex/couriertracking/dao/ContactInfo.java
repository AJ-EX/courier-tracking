package com.ajex.couriertracking.dao;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTACT_INFO")
    @SequenceGenerator(name="SEQ_CONTACT_INFO",sequenceName="SEQ_CONTACT_INFO", allocationSize=1)
	Long id;

	private String name;
	private String phone;
	private String email;
	private String contactType;
	private String addressType;
	private String country;
	private String countryCode;
	private String province;
	private String city;
	private String cityCode;
	private String district;
	private String detailedAddress;
	private String postalCode;
	private Double longitude;
	private Double latitude;
	private String nationalShortAddress;
	private String originalTextAddress;

}
