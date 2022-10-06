package com.demo.service;

import com.demo.entity.CSVEntity;
import com.demo.repository.CSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService implements ICSVService {

	@Autowired
	private CSVRepository csvRepo;

	public void save(MultipartFile uploadedFile) {
		try {
			BufferedReader br;
			List<CSVEntity> result = new ArrayList<CSVEntity>();
				String line;
				InputStream is = uploadedFile.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",");
					CSVEntity csv = new CSVEntity();
					csv.setId(Integer.valueOf(data[0]));
					csv.setLastName(data[1]);
					csv.setLocation(data[2]);
					csv.setOutletName(data[3]);
					csv.setOutletType(data[4]);
					csvRepo.save(csv);
					result.add(csv);
				}
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

}
