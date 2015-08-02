package testFakeDatabase;

import model.lists.ListEntry;
import model.persons.Student;
import model.persons.Tutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by x on 7/28/15.
 */
public class DatabaseClass {

    private static Map<Long, ListEntry> listEntries = new HashMap<>();

    private static Map<Long, Student> students = new HashMap<>();

    private static Map<Long, Tutor> tutors = new HashMap<>();

    public static Map<Long, ListEntry> getListEntries() {
        return listEntries;
    }

    public static Map<Long, Student> getStudents() {
        return students;
    }

    public static Map<Long, Tutor> getTutors() {
        return tutors;
    }
}
