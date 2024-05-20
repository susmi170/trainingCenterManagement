package com.buyogo.tcm.mapper;

import com.buyogo.tcm.dto.TrainingCenterDto;
import com.buyogo.tcm.entity.TrainingCenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mapper interface for DTO to Entity and Vice versa conversion
 */
@Mapper
public interface TrainingCenterMapper {
    TrainingCenterMapper INSTANCE = Mappers.getMapper(TrainingCenterMapper.class);
    @Mapping( target = "courses", source = "courses")

    TrainingCenterDto trainingCenterEntityToDto(TrainingCenter source);
    @Mapping( target = "courses", source = "courses")

    TrainingCenter trainingCenterDtoToEntity(TrainingCenterDto source);

    default List<String> mapCourse(String course) {

        List<String> courses = Arrays.asList(course.split(",", -1));
        return courses;
    }
    default String mapCourse(List<String> course) {

        return course.stream().collect(Collectors.joining(","));

    }
}
