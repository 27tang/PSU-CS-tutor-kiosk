package service;

import model.persons.Student;
import testFakeDatabase.DatabaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 7/29/15.
 */
public class StudentsService {

    private Map<Long, Student> studentsList = DatabaseClass.getStudents();

    public StudentsService() {
        studentsList.put(999999991L, new Student(999999991, 11111, "Tom Wackos"));
        studentsList.put(999999992L, new Student(999999992, 11112, "Jill Wackos"));
        studentsList.put(999999993L, new Student(999999993, 11113, "Gunther Samuels"));
        studentsList.put(999999994L, new Student(999999994, 11114, "Jenny Craze"));
        studentsList.put(999999995L, new Student(999999995, 11115, "Kalifornia Grinderson"));
        studentsList.put(999999996L, new Student(999999996, 11116, "Willie Wellington"));
        studentsList.put(999999997L, new Student(999999997, 11117, "Chingo McGhee"));
        studentsList.put(999999998L, new Student(999999998, 11118, "Tallahassee Weasleman"));
        studentsList.put(999999999L, new Student(999999999, 11119, "Cranko Watterbager"));
        studentsList.put(999999990L, new Student(999999990, 11110, "Pepe Silvia"));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(studentsList.values());
    }

    public Student getStudent(long studentId) {
        return studentsList.get(studentId);
    }

    public Student addStudent(Student student){
        return studentsList.put(student.getStudentId(), student);
    }

    public Student updateStudent(Student student) {
        //error checking?
        return studentsList.put(student.getStudentId(), student);
    }

    public Student removeStudent(long studentId){
        return studentsList.remove(studentId);
    }
}
