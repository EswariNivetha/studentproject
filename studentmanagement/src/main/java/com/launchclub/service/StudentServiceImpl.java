package com.launchclub.service;

import com.launchclub.exception.IdAlreadyFoundException;
import com.launchclub.exception.RecordNotfoundException;
import com.launchclub.model.Student;
import com.launchclub.studentdao.StudentDaoImpl;

import java.util.Map;

/**
 * Student Service Version2.
 *
 * @author EswariNivethaVU
 */
public class StudentServiceImpl implements StudentService {

    private static final StudentDaoImpl STUDENTDAO = new StudentDaoImpl();

    /**
     * Adds the student details to database.
     *
     * @param student
     */
    public boolean addStudent(final Student student) {
        return STUDENTDAO.addStudent(student);
    }

    /**
     * Removes the student details from the database.
     *
     * @param rollNo
     */
    public boolean removeStudent(final int rollNo) {

        if (STUDENTDAO.removeStudent(rollNo)) {
            return true;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Get all students details from database.
     */
    public Map<Integer, Student> getAllStudents() {
        final Map<Integer, Student> students = STUDENTDAO.getAllStudents();

        if (!students.isEmpty()) {
            return students;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Update student details to the database.
     *
     * @param student
     */
    public boolean updateStudentDetails(final Student student) {

        if (STUDENTDAO.updateStudents(student)) {
            return true;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Get values from the database.
     *
     * @param rollNo
     */
    public Student selectStudent(final int rollNo) {

        if (STUDENTDAO.getAllStudents().containsKey(rollNo)) {
            return STUDENTDAO.selectStudent(rollNo);
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * Checks whether rollno already exist or not.
     *
     * @param rollNo
     */
    public boolean checkRollNo(final int rollNo) {

        if (!STUDENTDAO.getAllStudents().containsKey(rollNo)) {
            return true;
        }
        throw new IdAlreadyFoundException("The Given RollNo Already Exist in Table.\n Re-Enter RollNo ");
    }

    /**
     * Checks whether rollno is present or not.
     *
     * @param rollNo
     */
    public boolean checkRollNoForUpdate(final int rollNo) {

        if (STUDENTDAO.getAllStudents().containsKey(rollNo)) {
            return true;
        }
        throw new RecordNotfoundException("Record Not Found");
    }
}
