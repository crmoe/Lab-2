package edu.ucdenver.university;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
    private String subject; // CSCI
    private int number; //3920
    private String title; //Adv. Prog.
    private ArrayList<Student> students;
    public Course(String subject, int number, String title){
        this.subject = subject.toUpperCase();
        this.number = number;
        this.title = title;
        this.students = new ArrayList<>();
        }
    }
    public String toString(){
        return String.format("%s%04d - %s", this.subject, this.number, this.title);

    }
    public String getSubject(){
        return subject;
    }
    public int getNumber(){
        return number;
    }
    public String getTitle(){
        return title;
    }
    public void addStudentToCourse(Student student) {
        if (!this.students.contains(student)){
            this.students.add(student);
        }
    }
    public ArrayList<Student> getEnrolledStudents() {
        return this.students;
    }


}
