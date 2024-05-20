package com.buyogo.tcm.service;

import com.buyogo.tcm.dao.TrainingCenterDAO;
import com.buyogo.tcm.dto.TrainingCenterDto;
import com.buyogo.tcm.entity.TrainingCenter;
import com.buyogo.tcm.mapper.TrainingCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

/**
 * Service class dedicated for performing all the business logic
 */
@Service
public class TrainingCenterService {
    @Autowired
    TrainingCenterDAO trainingCenterDAO;
    TrainingCenterMapper TRAINING_CENTER_MAPPER = TrainingCenterMapper.INSTANCE;

    /**
     * Retrieves all the training centers from database as entity class
     * Uses mapstruct to convert Entity object to DTO and returns the same to the controller
     * @return
     */
    public List<TrainingCenterDto> getTrainingCenters() {
        Iterable<TrainingCenter> trainingCenters = trainingCenterDAO.findAll();
        List<TrainingCenterDto> trainingCenterDtos = new ArrayList<>();
        for (TrainingCenter trainingCenter : trainingCenters) {
            TrainingCenterDto trainingCenterDto = TRAINING_CENTER_MAPPER.trainingCenterEntityToDto(trainingCenter);
            trainingCenterDtos.add(trainingCenterDto);
        }
        return trainingCenterDtos;
    }

    /**
     * This method is to save the Training center in DB
     * Converts the received DTO to Entity object
     * Adds the createdOn date as current date and calls DAO layer to save the details
     * Returns the object to received from DAO layer after converting to DTO .
     * @param trainingCenterDto
     * @return
     */

    public TrainingCenterDto saveTrainingCenter(TrainingCenterDto trainingCenterDto) {
        trainingCenterDto.setCreatedOn(new Date(System.currentTimeMillis()));
        TrainingCenter trainingCenter = TRAINING_CENTER_MAPPER.trainingCenterDtoToEntity(trainingCenterDto);
        TrainingCenter savedTrainingCenter = trainingCenterDAO.save(trainingCenter);
        return TRAINING_CENTER_MAPPER.trainingCenterEntityToDto(savedTrainingCenter);

    }

}
