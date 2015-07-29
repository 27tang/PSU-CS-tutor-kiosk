package model.persons;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by x on 7/28/15.
 */
@XmlRootElement
public class Student extends IdInfo {
    private String name;

    public Student() {
    }

    public Student(String studentId, String badgeNumber, String name) {
        super(studentId, badgeNumber);
        this.name = name;
    }
}
