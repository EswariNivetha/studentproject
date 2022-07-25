package com.launchclub.model;

import java.sql.Date;

/**
 * Model class to hold Student information
 *
 * @author EswariNivethaVU
 */
public class Student {
    private int rollNo;
    private String name;
    private String standard;
    private long phonenumber;
    private String emailId;
    private Date date;

    public Student() {
        super();
    }

    public Student(int rollNo, String name, String standard, long phonenumber, String emailId, Date date) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.phonenumber = phonenumber;
        this.emailId = emailId;
        this.date = date;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Convert to standard string format
     *
     * @return a <code> string </code> representing Student in standard format
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RollNo: ").append(rollNo).append("\n").append("Name: ").append(name).append("\n").append("Standard: ").append(standard).append("\n").append("PhoneNumber: ").append(phonenumber)
                .append("\n").append("EmailId: ").append(emailId).append("\n").append("Date: ").append(date).append("\n");
        return builder.toString();
    }
}
