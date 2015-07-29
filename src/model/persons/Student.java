package model.persons;

/**
 * Created by x on 7/28/15.
 */
public class Student extends IdInfo {
    private String name;

    public Student() {
    }

    public Student(String studentId, String badgeNumber, String name) {
        super(studentId, badgeNumber);
        this.name = name;
    }
}
