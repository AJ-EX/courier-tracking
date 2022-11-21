package com.ajex.couriertracking.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AddedService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDED_SERVICE")
    @SequenceGenerator(name="SEQ_ADDED_SERVICE",sequenceName="SEQ_ADDED_SERVICE", allocationSize=1)
    long id;
    
    private String serviceName;
    private String val1;
    private String val2;
    private String val3;

}