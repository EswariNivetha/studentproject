package com.launchclub.view;

public class Validation {

    /**
     * Validates the RollNo.
     *
     * @param rollNo
     */
    public static boolean validateRollNo(final String rollNo) {
        return rollNo.matches("[0-9]{3}") ? true : false;
    }

    /**
     * Validates the Standard.
     *
     * @param standard
     */
    public static boolean validateStandard(final String standard) {
        return (standard.matches("([1-9]|1[012])|((?i)PREKG|LKG|UKG)")) ? true : false;
    }

    /**
     * Validates the Choice.
     *
     * @param choice
     */
    public static boolean validateChoice(final String choice) {
        return choice.matches("[1-6]") ? true : false;
    }
}
