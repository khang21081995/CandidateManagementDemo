/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import bo.CandidateManager;
import controller.CandidateManagerController;
import entity.Candidate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ValidationAndNormalizingTextUtil;

/**
 *
 * @author khangpq
 */
public class Main {

    public static void main(String[] args) {
        CandidateManagerController candidateManagerController
                = new CandidateManagerController();
        String menu = """
                      
                      CANDIDATE MANAGEMENT SYSTEM
                      1. Experience
                      2. Fresher
                      3. Internship
                      4. Searching
                      5. Display all candidate
                      6. Delete candidate by id
                      7. Update candidate by id
                      0. Exit
                      
                      (Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).
                      Your choice: """;
        while (true) {
            int choice = ValidationAndNormalizingTextUtil.getInt(menu, "Must input an integer number!", "Must input an integer in range [0,7]", 0, 7);
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    candidateManagerController.addCandidateByOptionMenu(choice);
                    break;
                case 4:
                    candidateManagerController.searching();
                    break;
                case 5:
                    candidateManagerController.displayAllCandidate();
                    break;
                case 6: {
                    try {
                        Candidate deletedCandidate = candidateManagerController.deleteCandidate();
                        System.out.println("Delete candidate success!");
                        System.out.println(deletedCandidate);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                break;

                case 7: {
                    try {
                        Candidate updatedCandidate = candidateManagerController.updateCandidate();
                        System.out.println("Update candidate success!");
                        System.out.println(updatedCandidate);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                break;

                case 0:
                    return;
                default:
                    throw new AssertionError();
            }
        }

    }
}
