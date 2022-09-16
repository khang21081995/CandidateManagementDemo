/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.time.LocalDateTime;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author khangpq
 */
public class CandidateInputer {

    private Candidate c;

    public Candidate getCandidate() {
        return c;
    }

    public CandidateInputer(Candidate.CandidateType type) {

        switch (type) {
            case Experience:
                c = new Experience();
                break;
            case Fresher:
                c = new Fresher();
                break;
            case Intern:
                c = new Intern();
                break;
            default:
                throw new AssertionError();
        }
        c.setType(type);
    }

    private void inputCommonInfomation() {
        c.setFirstName(ValidationAndNormalizingTextUtil.getStringByRegex("Enter First Name: ", "Please enter character only!", "[A-Za-z ]+"));
        c.setLastName(ValidationAndNormalizingTextUtil.getStringByRegex("Enter Last Name: ", "Please enter character only!", "[A-Za-z ]+"));
        try {
            c.setYob(ValidationAndNormalizingTextUtil.getInt("Enter Birth Date: ", "Input number only!", "It must be >= 1900 and <= " + LocalDateTime.now().getYear(), 1900, LocalDateTime.now().getYear()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        c.setAddress(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter Address: "));
        c.setPhone(ValidationAndNormalizingTextUtil.getPhone(10, "Enter phone: "));
        c.setEmail(ValidationAndNormalizingTextUtil.getEmail("Enter email: "));
    }

    private void inputFresherInformation() {
        inputCommonInfomation();
        ((Fresher) c).setGraduationDate(ValidationAndNormalizingTextUtil.getInt("Enter Graduation Time: ", "Number only!!!", "Out of range!!!", 1900, Integer.MAX_VALUE));
        ((Fresher) c).setEducation(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter University name: "));
        int rank = ValidationAndNormalizingTextUtil.getInt("Enter rank (1- Excellence, 2- Good,3- Fair, 4- Poor): ", "Input Number only!!!", "Must be inrange 1 to 4", 1, 4);
        ((Fresher) c).setGraduationRank(Fresher.GraduationRank.getTypeByInt(rank));
    }

    private void inputExperienceInformation() {
        inputCommonInfomation();
        while (true) {
            try {
                ((Experience) c).setExpInYear(ValidationAndNormalizingTextUtil.getInt("Enter year of experience: ", "Number only!", "Out of Range", Integer.MIN_VALUE, Integer.MAX_VALUE));
                break;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        ((Experience) c).setProSkill(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter Pro skill: "));
    }

    private void inputInterInformation() {
        inputCommonInfomation();
        ((Intern) c).setMajors(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter majors: "));
        ((Intern) c).setSemester(ValidationAndNormalizingTextUtil.getInt("Enter Semeter: ", "Number only", "Out of range", 1, 50));
        ((Intern) c).setUniversityName(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter University Name: "));
    }

    public Candidate inputCandidateInformation() {
        switch (c.getType()) {
            case Experience:
                inputExperienceInformation();
                break;
            case Fresher:
                inputFresherInformation();
                break;
            case Intern:
                inputInterInformation();
                break;

        }
        return c;
    }

}
