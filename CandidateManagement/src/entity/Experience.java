/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author khangpq
 */
public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) throws Exception {
        int maxExpInYear = LocalDateTime.now().getYear() - super.getYob();
        if (expInYear < 0 || expInYear > 100) {
            throw new Exception("Year of experience must be >= 0 and <=100");
        }
        if (maxExpInYear < expInYear) {
            throw new Exception("Year of experience must be <= Age(" + maxExpInYear + ")");
        }
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = ValidationAndNormalizingTextUtil.removeUnnecessaryBlank(proSkill);
    }

}
