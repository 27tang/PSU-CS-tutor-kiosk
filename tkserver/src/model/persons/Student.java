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

    public Student(long studentId, long badgeNumber, String name) {
        super(studentId, badgeNumber);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
