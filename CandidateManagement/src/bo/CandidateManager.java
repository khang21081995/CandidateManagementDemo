/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author khangpq
 */
public class CandidateManager {

    private ArrayList<Candidate> candidates;
    private int lastId;

    public CandidateManager() {
        candidates = new ArrayList<>();
        lastId = 0;
    }

    public CandidateManager(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Candidate addCandidate(Candidate c) {
        c.setId(++lastId);
        candidates.add(c);
        return c;
    }

    public Candidate updateCandidate(int id, Candidate c) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            c.setId(id);
            candidates.set(index, c);
            return c;
        }
        throw new Exception("Candidate not found!");
    }

    public Candidate deleteCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.remove(index);
        }
        throw new Exception("Candidate does not exist!");
    }

    private int searchById(int id) {
        for (int index = 0; index < candidates.size(); index++) {
            if (candidates.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Candidate getCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.get(index);
        }
        throw new Exception("Id not found");
    }

    public ArrayList<Candidate> searchByNameAndType(String name, Candidate.CandidateType type) {
        ArrayList<Candidate> ret = new ArrayList<>();
        for (Candidate c : candidates) {
            if ((c.getFirstName().toLowerCase().contains(name.toLowerCase())
                    || c.getLastName().toLowerCase().contains(name.toLowerCase()))
                    && c.getType() == type) {
                ret.add(c);
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        String experience = "\n===========EXPERIENCE CANDIDATE============\n";
        String fresher = "\n===========FRESHER CANDIDATE===============\n";
        String inter = "\n===========INTERN CANDIDATE================\n";
        for (Candidate c : candidates) {
            switch (c.getType()) {
                case Experience:
                    experience += c.getId() + "|" + c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                case Fresher:
                    fresher += c.getId() + "|" + c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                case Intern:
                    inter += c.getId() + "|" + c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
            }
        }

        return experience + fresher + inter;
    }

}
