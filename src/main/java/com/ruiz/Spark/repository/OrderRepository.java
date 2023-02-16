package com.ruiz.Spark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruiz.Spark.model.OrderOriginal;
import com.ruiz.Spark.model.User;


@Repository
public interface OrderRepository extends JpaRepository<OrderOriginal, Long> {
	List<OrderOriginal> findByUser(User user);
}
