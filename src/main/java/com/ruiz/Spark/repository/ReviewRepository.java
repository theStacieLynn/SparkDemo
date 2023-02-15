package com.ruiz.Spark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruiz.Spark.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
