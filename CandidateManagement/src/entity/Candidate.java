/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Calendar;

/**
 *
 * @author khangpq
 */
public class Candidate {

    int getBirthDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public enum CandidateType {
        Experience, Fresher, Intern;

        public int getIntValue() {
            switch (this) {
                case Experience:
                    return 0;
                case Fresher:
                    return 1;
                case Intern:
                    return 2;
            }
            throw new IndexOutOfBoundsException("Invalid value!");
        }

        public static CandidateType getTypeByInt(int type) {
            switch (type) {
                case 0:
                    return Experience;
                case 1:
                    return Fresher;
                case 2:
                    return Intern;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int id;
    private String firstName;
    private String lastName;
//    Birth Date, Address, Phone, Email and Candidate type
    private int yob;//Birth Date
    private String address;
    private String phone;
    private String email;
    private CandidateType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) throws Exception {
        if (yob < 1900 || yob > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new Exception("YOB Out Of Range");
        }
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getType() {
        return type;
    }

    public void setType(CandidateType type) {
        this.type = type;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
//        Aguirre Eva | 1990 | Sao paulo| 940394 | eva@asante.com | 0
        return String.format("%-5s|%-20s %-20s | %-4s | %-30s | %-20s | %-30s | %-1s", id, firstName, lastName, yob + "", address, phone, email, type.getIntValue() + "");
    }

}
