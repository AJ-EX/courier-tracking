package com.ajex.couriertracking.dto;

import java.time.LocalDateTime;

public class AbstractDto<E> {

    private LocalDateTime createAt;

    private LocalDateTime lastModifiedAt;

    private String createdBy;

    private String lastModifiedBy;


}