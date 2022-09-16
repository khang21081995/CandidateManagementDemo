/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.CandidateInputer;
import bo.CandidateManager;
import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author khangpq
 */
public class CandidateManagerController {

    private CandidateInputer candidateInputer;
    private CandidateManager candidateManager;

    public CandidateManagerController() {
        candidateManager = new CandidateManager();
    }

    private Candidate inputCandidate(Candidate.CandidateType type) {
        candidateInputer = new CandidateInputer(type);
        candidateInputer.inputCandidateInformation();
        Candidate c = candidateInputer.getCandidate();
        candidateManager.addCandidate(c);
        return c;
    }

    private Experience addExperienceCandidate() {
        Experience c = (Experience) inputCandidate(Candidate.CandidateType.Experience);
        return c;
    }

    private Fresher addFresherCandidate() {
        Fresher c = (Fresher) inputCandidate(Candidate.CandidateType.Fresher);
        return c;
    }

    private Intern addInternCandidate() {
        Intern c = (Intern) inputCandidate(Candidate.CandidateType.Intern);
        return c;
    }

    public void addCandidateByOptionMenu(int choice) {
        ArrayList<Candidate> ret = new ArrayList<>();
        do {
            switch (choice) {
                case 1://input experience
                    ret.add(addExperienceCandidate());
                    break;
                case 2://input fresher
                    ret.add(addFresherCandidate());

                    break;
                case 3://input intern
                    ret.add(addInternCandidate());
                    break;
            }
        } while (ValidationAndNormalizingTextUtil
                .pressYNtoContinue("Do you want to continue (Y/N)"));

        System.out.println("List of added candidate:");
        for (Candidate c : ret) {
            System.out.println(c.getFullName());
        }
    }

    public void displayAllCandidate() {
        System.out.println("List of candidate:");
        System.out.println(candidateManager);
    }

    public void searching() {
        String name = ValidationAndNormalizingTextUtil.getNonEmptyString("Input Candidate name (First name or Last name): ");
        int type = ValidationAndNormalizingTextUtil.getInt("Input type of candidate (0: Experience , 1: Fresher, 2: Intern): ", "Must input an integer number",
                "Integer number must in range [0,2]", 0, 2);
        ArrayList<Candidate> listFound = candidateManager.searchByNameAndType(name, Candidate.CandidateType.getTypeByInt(type));
        if (listFound.isEmpty()) {
            System.out.println("Not found!");
        } else {
            System.out.println("The candidates found:");
            for (Candidate c : listFound) {
                System.out.println(c);
            }
        }

    }

    public Candidate deleteCandidate() throws Exception {
        int id = ValidationAndNormalizingTextUtil.getInt("Input id of candidate: ", "Must input an integer number", "Integer number must in range [1," + Integer.MAX_VALUE + "]", 1, Integer.MAX_VALUE);
        return candidateManager.deleteCandidateById(id);
    }

    public Candidate updateCandidate() throws Exception {
        int id = ValidationAndNormalizingTextUtil.getInt("Input id of candidate: ", "Must input an integer number", "Integer number must in range [1," + Integer.MAX_VALUE + "]", 1, Integer.MAX_VALUE);
        Candidate c = candidateManager.getCandidateById(id);
        candidateInputer = new CandidateInputer(c.getType());
        c = candidateInputer.inputCandidateInformation();
        return candidateManager.updateCandidate(id, c);
    }

}
