package com.ajex.couriertracking.repository;

import com.ajex.couriertracking.dao.AddedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedServiceRepo extends JpaRepository<AddedService, Long> {
    //List<AddedService> findAllByOrderID(Long orderId);

}