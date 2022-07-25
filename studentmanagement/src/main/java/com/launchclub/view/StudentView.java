package com.launchclub.view;

import com.launchclub.commoninputs.StudentInputs;
import com.launchclub.exception.CustomException;
import com.launchclub.model.Student;
import com.launchclub.validation.CommonValidation;

import java.sql.Date;
import java.util.Map.Entry;
import java.util.Scanner;

import static com.launchclub.view.Validation.*;

/**
 * Student, View! The StudentView program implements an application that simply
 * displays "User input".
 */
public class StudentView {


    private static final Scanner SCANNER = new Scanner(System.in);
    private static final CommonValidation VALIDATOR = new CommonValidation();
    private static final StudentController STUDENTCONTROLLER = new StudentController();


    /**
     * Get rollno from the user.
     */
    public static int getRollNo() {
        System.out.println("Enter the RollNo(Give 3 Digit No): \n Press @ To Exit to Main Menu");
        final String rollNo = SCANNER.next().trim();
        StudentView.backToMain(rollNo);

        if (validateRollNo(rollNo)) {
            return Integer.parseInt(rollNo);
        } else {
            System.out.println("InValid RollNo Please Enter a valid RollNo \n Press @ To Exit to Main Menu");
            return StudentView.getRollNo();
        }
    }

    /**
     * Get the name from the user.
     */
    public static String getName() {
        System.out.println("Enter the Name:");
        //final String name = SCANNER.next().trim();
        final String name =(StudentInputs.getString("Enter the Name:"));
        StudentView.backToMain(name);

        if (VALIDATOR.validateName(name)) {
            return name;
        } else {
            System.out.println(" InValid Name Please Enter a valid Name \n Press @ To Exit to Main Menu");
            return StudentView.getName();
        }
    }

    /**
     * Get standard from the user.
     */
    public static String getStandard() {
       // System.out.println("Enter the Standard [PREKG - UKG, 1-12]");
        final String standard = (StudentInputs.getString("Enter the Standard [PREKG - UKG, 1-12]"));
        StudentView.backToMain(standard);

        if (validateStandard(standard)) {
            return standard;
        } else {
            System.out.println(" InValid Standard Please Enter a valid Standard  \n Press @ To Exit to Main Menu");
            return StudentView.getStandard();
        }
    }

    /**
     * Get phone no from the user.
     */
    public static long getPhoneNo() {
        System.out.println("Enter the PhoneNumber:");
        final String phoneNo = SCANNER.next().trim();
        StudentView.backToMain(phoneNo);

        if (VALIDATOR.validatePhoneNo(phoneNo)) {
            return Long.parseLong(phoneNo);
        } else {
            System.out.println(" InValid PhoneNo Please Enter a valid PhoneNo \n Press @ To Exit to Main Menu");
            return StudentView.getPhoneNo();
        }
    }

    /**
     * Get emailid from the user.
     */
    public static String getEmailId() {
       // System.out.println("Enter the EmailId:");
        final String emailId =(StudentInputs.getString("Enter the EmailId:"));
        StudentView.backToMain(emailId);

        if (VALIDATOR.validateEmailId(emailId)) {
            return emailId;
        } else {
            System.out.println("InValid EmailId Please Enter a valid MailId  \n Press @ To Exit to Main Menu");
            return StudentView.getEmailId();
        }
    }

    /**
     * Get a date from the user.
     */
    public static Date getDate() {
        System.out.println("Enter Date of Joining(yyyy-mm-dd):");
        final String date = SCANNER.next().trim();
        StudentView.backToMain(date);
        boolean isValid = false;

        try {
            isValid = VALIDATOR.validateDate(date);
        } catch (CustomException e) {
            System.out.println(e);
        }

        if (isValid) {
            return Date.valueOf(date);
        } else {
            System.out.println("InValid Date Please Enter a valid Date \n Press @ To Exit to Main Menu");
            return StudentView.getDate();
        }
    }

    /**
     * AddStudent by getting values from view and sending a request to the
     * controller.
     */
    public static void addStudent() {
        final int rollNo = StudentView.getRollNo();

        try {
            STUDENTCONTROLLER.checkRollno(rollNo);
        } catch (CustomException e) {
            System.out.println(e);
            StudentView.addStudent();
            StudentManagement.selectChoice();
        }
        final String name = StudentView.getName();
        final String standard = StudentView.getStandard();
        final long phoneNo = StudentView.getPhoneNo();
        final String emailId = StudentView.getEmailId();
        final Date Date = StudentView.getDate();

        final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

        try {

            if (STUDENTCONTROLLER.addStudent(rollNo, student)) {
                System.out.println("Inserted SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Display all Students and send a request to the controller.
     */
    public static void showAllStudents() {

        try {
            for (Entry<Integer, Student> entry : STUDENTCONTROLLER.getAllStudents().entrySet()) {
                System.out.println(entry.getValue());
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * RemoveStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void removeStudent() {

        try {

            if (STUDENTCONTROLLER.removeStudent(StudentView.getRollNo())) {
                System.out.println("Deleted SuccessFully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * GetStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void selectStudent() {

        try {
            System.out.println(STUDENTCONTROLLER.searchStudentDetail(StudentView.getRollNo()));
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudent() {
        final String name = "name";
        final String standard = "standard";
        final String phoneNo = "phoneNo";
        final String emailid = "emailId";
        final String date = "date";
        final Student student = new Student();
        final int rollNo = StudentView.getRollNo();

        try {
            STUDENTCONTROLLER.checkRollnoForUpdate(rollNo);
        } catch (CustomException e) {
            System.out.println(e);
            StudentView.updateStudent();
            StudentManagement.selectChoice();
        }
        student.setRollNo(rollNo);
        System.out.println("Do you want to change your name? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, name);
        System.out.println("Do you want to change your standard? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, standard);
        System.out.println("Do you want to change your phoneno? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, phoneNo);
        System.out.println("Do you want to change your email? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, emailid);
        System.out.println("Do you want to change your joiningdate? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, date);

        try {
            if (STUDENTCONTROLLER.updateStudentDetails(rollNo, student)) {
                System.out.println("Updated Successfully");
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Checking next field for update.
     *
     * @param student
     * @param studentdetail
     * @return
     */
    public static Student updateDetail(final Student student, final String studentdetail) {
        final String choiceYes = "yes";
        final String choiceNo = "no";

        while (true) {
            final String option = SCANNER.next().trim();
            StudentView.backToMain(option);

            if (choiceYes.equalsIgnoreCase(option)) {

                if ("name".equalsIgnoreCase(studentdetail)) {
                    student.setName(StudentView.getName());
                    break;
                } else if ("standard".equalsIgnoreCase(studentdetail)) {
                    student.setStandard(StudentView.getStandard());
                    break;
                } else if ("phoneno".equalsIgnoreCase(studentdetail)) {
                    student.setPhonenumber(StudentView.getPhoneNo());
                    break;
                } else if ("emailId".equalsIgnoreCase(studentdetail)) {
                    student.setEmailId(StudentView.getEmailId());
                    break;
                } else if ("date".equalsIgnoreCase(studentdetail)) {
                    student.setDate(StudentView.getDate());
                    break;
                }
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                System.out.println("Invalid Option");
                continue;
            }
        }
        return student;
    }

    /**
     * Getting choice from the user.
     */
    public static String getChoice() {
        final String choice = StudentManagement.SCANNER.next().trim();

        if (validateChoice(choice)) {
            return choice;
        } else {
            System.out.println("Please Enter Valid Choice use only [1-6]");
            return StudentView.getChoice();
        }
    }

    /**
     * Back to main menu.
     */
    public static void backToMain(String option) {

        if ("@".equals(option)) {
            StudentManagement.selectChoice();
        }
    }
}