package model.persons;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by x on 7/28/15.
 */

@XmlRootElement
public class IdInfo {
    private long studentId;
    private long badgeNumber;

    public IdInfo() {
    }

    public IdInfo(Long studentId, long badgeNumber) {
        this.studentId = studentId;
        this.badgeNumber = badgeNumber;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(long badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
}
