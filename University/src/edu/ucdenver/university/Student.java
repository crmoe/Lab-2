package edu.ucdenver.university;

import java.time.LocalDate;


public class Student{

    private String name;
    private LocalDate dob;
    private String email;

    public Student(String name, LocalDate dob){
        this.name = name;
        this.dob = dob;
        this.email = name.toLowerCase().replace(" ",".") + "@ucdenver.edu";

    }
    @Override
    public String toString(){
        return String.format("%-20s - %s - %-50s - Standing: %s", this.getName(), this.getDob(),
                this.getEmail(), "Grad Student");

    }
    public String getName(){ return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}