package model.persons;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by x on 7/28/15.
 */

@XmlRootElement
public class IdInfo {
    private String studentId;
    private String badgeNumber;

    public IdInfo() {
    }

    public IdInfo(String studentId, String badgeNumber) {
        this.studentId = studentId;
        this.badgeNumber = badgeNumber;
    }
}
