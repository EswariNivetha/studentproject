package com.launchclub.validation;

import com.launchclub.exception.InValidDateException;

import java.time.LocalDate;

public class CommonValidation {

    /**
     * Validates the PhoneNumber.
     *
     * @param phoneNumber
     */
    public boolean validatePhoneNo(final String phoneNumber) {
        return phoneNumber.matches("[6-9]{1}[0-9]{9}") ? true : false;
    }

    /**
     * Validates the Name.
     *
     * @param name
     */
    public boolean validateName(final String name) {
        return name.matches("[a-zA-Z\\s]*$") ? true : false;
    }

    /**
     * Validates the RollNo.
     *
     * @param rollNo
     */
//    public boolean validateRollNo(final String rollNo) {
//        return rollNo.matches("[0-9]{3}") ? true : false;
//    }
//
//    /**
//     * Validates the Standard.
//     *
//     * @param standard
//     */
//    public boolean validateStandard(final String standard) {
//        return (standard.matches("([1-9]|1[012])|((?i)PREKG|LKG|UKG)")) ? true : false;
//    }

    /**
     * Validates the EmailId.
     * "
     *
     * @param emailId
     */
    public boolean validateEmailId(final String emailId) {
        return emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]{2,3}+$") ? true : false;
    }

    /**
     * Validates the Date.
     *
     * @param date
     */
    public boolean validateDate(final String date) {

        try {
            LocalDate localdate = LocalDate.parse(date);
            LocalDate currentLocalDate = LocalDate.now();

            return (currentLocalDate.plusDays(1).isAfter(localdate)) ? true : false;
        } catch (Exception e) {
            throw new InValidDateException("Invalid Date");
        }
    }

//    /**
//     * Validates the Choice.
//     *
//     * @param choice
//     */
//    public boolean validateChoice(final String choice) {
//        return choice.matches("[1-6]") ? true : false;
//    }
}
