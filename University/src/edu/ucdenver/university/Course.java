package edu.ucdenver.university;

public class Course {
    private String subject; // CSCI
    private int number; //3920
    private String title; //Adv. Prog.

    public Course(String subject, int number, String title){
        this.subject = subject.toUpperCase();
        this.number = number;
        this.title = title;

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
    public List<Student> getEnrolledStudents() {
        return this.students;
    }
}
