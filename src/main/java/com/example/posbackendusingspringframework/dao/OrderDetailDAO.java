package com.example.posbackendusingspringframework.dao;

import com.example.posbackendusingspringframework.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetailEntity,String> {
}
