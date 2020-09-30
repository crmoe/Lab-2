package edu.ucdenver.university;
import java.time.LocalDate;

public class Undergraduate extends Student{

    public Undergraduate(String name, LocalDate dob){
        super(name, dob);

    }
    @Override
    public String toString(){
        return String.format("%-20s - %s - %-50s - Standing: %s", this.getName(), this.getDob(),
                this.getEmail(), "Undergraduate");

    }

}
