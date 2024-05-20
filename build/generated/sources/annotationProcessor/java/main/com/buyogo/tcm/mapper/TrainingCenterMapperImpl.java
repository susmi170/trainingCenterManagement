package com.buyogo.tcm.mapper;

import com.buyogo.tcm.dto.TrainingCenterDto;
import com.buyogo.tcm.dto.TrainingCenterDto.Address;
import com.buyogo.tcm.entity.TrainingCenter;
import java.sql.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-20T17:35:55+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.9 (Azul Systems, Inc.)"
)
public class TrainingCenterMapperImpl implements TrainingCenterMapper {

    @Override
    public TrainingCenterDto trainingCenterEntityToDto(TrainingCenter source) {
        if ( source == null ) {
            return null;
        }

        List<String> courses = null;
        int id = 0;
        String centerName = null;
        String centerCode = null;
        int studentCapacity = 0;
        Address address = null;
        String contactEmail = null;
        String contactPhone = null;
        Date createdOn = null;

        courses = mapCourse( source.getCourses() );
        id = source.getId();
        centerName = source.getCenterName();
        centerCode = source.getCenterCode();
        studentCapacity = source.getStudentCapacity();
        address = addressToAddress( source.getAddress() );
        contactEmail = source.getContactEmail();
        contactPhone = source.getContactPhone();
        createdOn = source.getCreatedOn();

        TrainingCenterDto trainingCenterDto = new TrainingCenterDto( id, centerName, centerCode, studentCapacity, address, courses, contactEmail, contactPhone, createdOn );

        return trainingCenterDto;
    }

    @Override
    public TrainingCenter trainingCenterDtoToEntity(TrainingCenterDto source) {
        if ( source == null ) {
            return null;
        }

        TrainingCenter trainingCenter = new TrainingCenter();

        trainingCenter.setCourses( mapCourse( source.getCourses() ) );
        trainingCenter.setId( source.getId() );
        trainingCenter.setCenterName( source.getCenterName() );
        trainingCenter.setCenterCode( source.getCenterCode() );
        trainingCenter.setStudentCapacity( source.getStudentCapacity() );
        trainingCenter.setAddress( addressToAddress1( source.getAddress() ) );
        trainingCenter.setContactEmail( source.getContactEmail() );
        trainingCenter.setContactPhone( source.getContactPhone() );
        trainingCenter.setCreatedOn( source.getCreatedOn() );

        return trainingCenter;
    }

    protected Address addressToAddress(com.buyogo.tcm.entity.Address address) {
        if ( address == null ) {
            return null;
        }

        int id = 0;
        String fullAddress = null;
        String city = null;
        String state = null;
        int pinCode = 0;

        id = address.getId();
        fullAddress = address.getFullAddress();
        city = address.getCity();
        state = address.getState();
        pinCode = address.getPinCode();

        Address address1 = new Address( id, fullAddress, city, state, pinCode );

        return address1;
    }

    protected com.buyogo.tcm.entity.Address addressToAddress1(Address address) {
        if ( address == null ) {
            return null;
        }

        com.buyogo.tcm.entity.Address address1 = new com.buyogo.tcm.entity.Address();

        address1.setId( address.getId() );
        address1.setFullAddress( address.getFullAddress() );
        address1.setCity( address.getCity() );
        address1.setState( address.getState() );
        address1.setPinCode( address.getPinCode() );

        return address1;
    }
}
