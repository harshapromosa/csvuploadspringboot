package com.demo.repository;


import com.demo.entity.CSVEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CSVRepository extends JpaRepository<CSVEntity, Integer> {

}
