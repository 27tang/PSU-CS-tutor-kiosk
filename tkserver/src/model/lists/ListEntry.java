package model.lists;

import model.persons.Student;
import model.persons.Tutor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by x on 7/28/15.
 */

@XmlRootElement
public class ListEntry {

    private long entryId;
    private long tuteeId;
    private String course;
    private int location;
    private long tutorId;
    private Date date;

    public ListEntry() {
    }

    public ListEntry(long entryId, long tuteeId, String course, int location, long tutorId) {
        this.entryId = entryId;
        this.tuteeId = tuteeId;
        this.course = course;
        this.location = location;
        this.tutorId = tutorId;
        this.date = new Date();
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public long getTuteeId() {
        return tuteeId;
    }

    public void setTuteeId(long tuteeId) {
        this.tuteeId = tuteeId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public long getTutorId() {
        return tutorId;
    }

    public void setTutorId(long tutorId) {
        this.tutorId = tutorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}