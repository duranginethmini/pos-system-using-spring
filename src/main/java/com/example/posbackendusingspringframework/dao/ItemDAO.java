package com.example.posbackendusingspringframework.dao;

import com.example.posbackendusingspringframework.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository <ItemEntity,String> {
}
