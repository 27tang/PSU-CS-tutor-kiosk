package service;

import model.persons.Student;
import model.persons.Tutor;
import testFakeDatabase.DatabaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 8/1/15.
 */
public class TutorsService {

    private Map<Long, Tutor> tutorsList = DatabaseClass.getTutors();

    public TutorsService() {
        tutorsList.put(900996708L, new Tutor(900996708, 99999, "X"));
        tutorsList.put(222222222L, new Tutor(222222222, 22222, "Rohan"));
        tutorsList.put(111111111L, new Tutor(111111111, 11111, "Mr Meeseeks"));
        tutorsList.put(333333333L, new Tutor(333333333, 33333, "Brook"));
    }

    public List<Tutor> getAllTutors() {
        return new ArrayList<Tutor>(tutorsList.values());
    }

    public Tutor getTutor(long tutorId) {
        return tutorsList.get(tutorId);
    }

    public Tutor addTutor(Tutor tutor){
        return tutorsList.put(tutor.getStudentId(), tutor);
    }

    public Tutor updateTutor(Tutor tutor) {
        //error checking?
        return tutorsList.put(tutor.getStudentId(), tutor);
    }

    public Tutor removeTutor(long tutorId){
        return tutorsList.remove(tutorId);
    }
}
