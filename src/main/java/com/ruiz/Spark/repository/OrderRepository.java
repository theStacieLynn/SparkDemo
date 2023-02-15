package com.ruiz.Spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruiz.Spark.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
