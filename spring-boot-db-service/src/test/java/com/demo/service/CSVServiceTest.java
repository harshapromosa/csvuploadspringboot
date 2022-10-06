package com.demo.service;

import com.demo.entity.CSVEntity;
import com.demo.repository.CSVRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CSVService.class})
@ExtendWith(SpringExtension.class)
class CSVServiceTest {
    @MockBean
    private CSVRepository cSVRepository;

    @Autowired
    private CSVService cSVService;

    @Test
    void testSave2() {
        when(cSVRepository.save((CSVEntity) any())).thenThrow(new RuntimeException("An error occurred"));

        CSVEntity csvEntity = new CSVEntity();
        csvEntity.setId(1);
        csvEntity.setLastName("Doe");
        csvEntity.setLocation("Location");
        csvEntity.setOutletName("Outlet Name");
        csvEntity.setOutletType("Outlet Type");
        assertThrows(RuntimeException.class, () -> cSVService.save(new MockMultipartFile("Name", new ByteArrayInputStream(new byte[]{}))));
        verify(cSVRepository).save((CSVEntity) any());
    }


}
