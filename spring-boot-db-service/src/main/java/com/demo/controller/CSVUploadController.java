package com.demo.controller;

import com.demo.entity.CSVEntity;
import com.demo.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CSVUploadController {
		@Autowired
	private CSVService csvService;
	
@PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<Object> uploadFile(@Valid @RequestParam("file") MultipartFile uploadedFile){
	BufferedReader br;
	List<CSVEntity> result = new ArrayList<CSVEntity>();
	try {
	     String line;
	     InputStream is = uploadedFile.getInputStream();
	     br = new BufferedReader(new InputStreamReader(is));
	     while ((line = br.readLine()) != null) {
	        String[] data=  line.split(",");
	         CSVEntity csv=new CSVEntity();
	         csv.setId(Integer.valueOf(data[0]));
	         csv.setLastName(data[1]);
	         csv.setLocation(data[2]);
	         csv.setOutletName(data[3]);
	         csv.setOutletType(data[4]);
	 		 csvService.save(csv);
	 	     result.add(csv);
	     }
	  } catch (IOException e) {
	    System.err.println(e.getMessage());       
	  } 
	return  new ResponseEntity<Object>(result, HttpStatus.CREATED);
	
}

}
