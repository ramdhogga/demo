package com.techigai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techigai.model.Order;

@Repository
public interface OrderRepo extends   CrudRepository<Order, Long>{

}
