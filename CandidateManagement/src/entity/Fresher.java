/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author khangpq
 */
public class Fresher extends Candidate {

    public enum GraduationRank {
        Excellence, Good, Fair, Poor;

        public int getIntType() {
            switch (this) {
                case Excellence:
                    return 1;
                case Good:
                    return 2;
                case Fair:
                    return 3;
                case Poor:
                    return 4;
                default:
                    throw new AssertionError();
            }
        }

        public static GraduationRank getTypeByInt(int type) {
            switch (type) {
                case 1:
                    return Excellence;
                case 2:
                    return Good;
                case 3:
                    return Fair;
                case 4:
                    return Poor;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int graduationDate;
    private GraduationRank graduationRank;
    private String education;

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

}
