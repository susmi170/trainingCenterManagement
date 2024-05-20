package com.buyogo.tcm.dto;

import com.buyogo.tcm.constants.TrainingCenterValidationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * Dto class responsible for communicating with API and backend .
 * It has all the validation needs to be done via jakarta validation
 */
@Data
@AllArgsConstructor
public class TrainingCenterDto {
    private int id;
    @NotBlank(message = TrainingCenterValidationConstants.CENTER_NAME_MANDATORY)
    @Size(max = 40, message = TrainingCenterValidationConstants.CENTER_NAME_INVALID)
    private String centerName;
    @NotBlank(message = TrainingCenterValidationConstants.CENTER_CODE_MANDATORY)
    @Size(min = 12, max = 12, message = TrainingCenterValidationConstants.CENTER_CODE_INVALID)
    private String centerCode;
    private int studentCapacity;
    private Address address;
    private List<String> courses;
    @Email(message = TrainingCenterValidationConstants.CENTER_CONTACT_EMAIL_INVALID, regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")

    private String contactEmail;
    @NotBlank(message = TrainingCenterValidationConstants.CENTER_CONTACT_PHONE_MANDATORY)
    @Pattern(message = TrainingCenterValidationConstants.CENTER_CONTACT_PHONE_INVALID, regexp="^\\d{10}$")

    private String contactPhone;
    private Date createdOn;




    @Data
    @AllArgsConstructor
    public static class Address {
        private int id;

        private String fullAddress;
        private String city;
        private String state;
        private int pinCode;


    }
}


