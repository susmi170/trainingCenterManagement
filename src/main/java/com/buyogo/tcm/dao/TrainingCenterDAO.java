package com.buyogo.tcm.dao;

import com.buyogo.tcm.entity.TrainingCenter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO layer to perform the Database operation
 */
@Repository
public interface TrainingCenterDAO extends CrudRepository<TrainingCenter, Integer> {

}
