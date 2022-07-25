package com.launchclub.controller;

import com.launchclub.model.Student;
import com.launchclub.service.StudentServiceImpl;

import java.util.Map;

/**
 * Controller act as a mediator between view and model.
 *
 * @author EswariNivethaVU
 */
public class StudentController {

    private static final StudentServiceImpl STUDENT_SERVICE_VERSION2 = new StudentServiceImpl();

    /**
     * Adding Student Details.
     *
     * @param rollNo
     * @param student
     */
    public boolean addStudent(final int rollNo, final Student student) {
        return STUDENT_SERVICE_VERSION2.addStudent(student);
    }

    /**
     * Removing Student Detail
     *
     * @param rollNo
     */
    public boolean removeStudent(final int rollNo) {
        return STUDENT_SERVICE_VERSION2.removeStudent(rollNo);
    }

    /**
     * Updating Student Detail
     *
     * @param rollNo
     * @param student
     */
    public boolean updateStudentDetails(final int rollNo, final Student student) {
        return STUDENT_SERVICE_VERSION2.updateStudentDetails(student);
    }

    /**
     * Getting all the Student Details.
     */
    public Map<Integer, Student> getAllStudents() {
        return STUDENT_SERVICE_VERSION2.getAllStudents();
    }

    /**
     * Searching Student Detail by using rollno
     *
     * @param rollNo
     */
    public Student searchStudentDetail(final int rollNo) {
        return STUDENT_SERVICE_VERSION2.selectStudent(rollNo);
    }

    /**
     * Checks whether rollno already exist or not.
     *
     * @param rollNo
     */
    public boolean checkRollno(final int rollNo) {
        return STUDENT_SERVICE_VERSION2.checkRollNo(rollNo);
    }

    /**
     * Checks whether rollno is present or not.
     *
     * @param rollNo
     */
    public boolean checkRollnoForUpdate(final int rollNo) {
        return STUDENT_SERVICE_VERSION2.checkRollNoForUpdate(rollNo);
    }
}
