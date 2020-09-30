package edu.ucdenver.university;

import java.time.LocalDate;
import java.util.ArrayList;

public class University{
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public University(){
        this.students = new ArrayList<>(100);
        this.courses = new ArrayList<>(100);

    }
    @Override
    public String toString(){
        return String.format("University with %d students and %d courses.", this.getStudents().size(),
                this.getCourses().size());

    }
    public Student getStudent(String name) throws IllegalArgumentException{
        for (Student s: students){
            if (s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        throw new IllegalArgumentException("Student not in the university.");

    }
    public Course getCourse(String subject, int number) throws IllegalArgumentException{
        for (Course c: courses){
            if (c.getSubject().equalsIgnoreCase(subject) && c.getNumber()==number){
                return c;
            }
        }
        throw new IllegalArgumentException("Course not in Subjects.");

    }
    public void addUndergrad(String name, LocalDate dob){students.add(new Undergraduate(name,dob));}
    public void addMaster(String name, LocalDate dob){students.add(new Master(name,dob));}
    public void addPhD(String name, LocalDate dob, String topic){students.add(new PhD(name,dob,topic));}

    public void addCourse(String subject,int number, String title) throws IllegalArgumentException{
        try{
            this.getCourse(subject,number);
        }
        catch(IllegalArgumentException iae){
            this.courses.add(new Course(subject, number,title));
            return;
        }
        throw new IllegalArgumentException("The course is already in the Subjects.");
    }

    public ArrayList<Student> getStudents(){
        return students;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
}