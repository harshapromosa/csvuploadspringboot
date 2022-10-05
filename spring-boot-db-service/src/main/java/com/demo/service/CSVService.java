package com.demo.service;

import com.demo.entity.CSVEntity;
import com.demo.repository.CSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSVService {

	@Autowired
	private CSVRepository csvRepo;
	
	
	public CSVEntity save(CSVEntity csv) {
		return csvRepo.save(csv);
	}
	
	public List<CSVEntity> getAllSave(){
		return csvRepo.findAll();
	}
}
