package com.ajex.couriertracking.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CargoInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARGO_INFO")
    @SequenceGenerator(name="SEQ_CARGO_INFO",sequenceName="SEQ_CARGO_INFO", allocationSize=1)
	Long id;

	private String name;
	private Integer count;
	private Double totalValue;
	private String hsCode;
	private String countryOfOrigin;
	private String sku;
	private String cpc;
	private String originalDescription;

}
