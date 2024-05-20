package com.buyogo.tcm.service;

import com.buyogo.tcm.dto.TrainingCenterDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * we have loaded project id with 2 in in-mem h2 DB using data.sql part of resources/data.sql of test folder
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class TrainingCenterServiceTest {

    @Autowired
    TrainingCenterService trainingCenterService;

    /**
     * Junit
     * Get all projects positive scenario
     */
    @Test
    void getTrainingCenters_test_positive() {
        List<TrainingCenterDto> trainingCenterDtoList =trainingCenterService.getTrainingCenters();
        assertEquals(trainingCenterDtoList.get(0).getCenterCode(), "test_1");


    }
    @Test
    void saveTrainingCenters_test_positive() {
        TrainingCenterDto trainingCenterDto = createTestData();
        TrainingCenterDto trainingCenterDtoResult =trainingCenterService.saveTrainingCenter(trainingCenterDto);
        assertEquals(trainingCenterDtoResult.getCenterCode(), "test_1");


    }

    TrainingCenterDto createTestData() {
        TrainingCenterDto.Address address = new TrainingCenterDto.Address(1,"test", "test1", "Tes12", 123);
        TrainingCenterDto dto = new TrainingCenterDto(1,"test_code", "test_1", 2, address, Arrays.asList("CSE,IT"), "p@t.com", "123456", null);
        return dto;
    }
}
