package com.launchclub.service;

import com.launchclub.model.Student;

import java.util.Map;


/**
 * Interface to provide StudentService.
 *
 * @author EswariNivethaVU
 */
public interface StudentService {

    boolean addStudent(final Student student);

    boolean removeStudent(final int rollNo);

    Map<Integer, Student> showAllStudents();

    Student selectStudent(final int rollNo);

    boolean updateStudentDetails(final Student student);

    boolean checkRollno(final int rollNo);

    boolean checkRollnoForUpdate(final int rollNo);
}

