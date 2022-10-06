package com.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface ICSVService {
    void save(MultipartFile uploadedFile);

}
