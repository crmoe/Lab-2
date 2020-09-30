package edu.ucdenver.university;
import java.time.LocalDate;

public class PhD extends Graduate{

    public PhD(String name, LocalDate dob){
        super(name,dob);
    }
    @Override
    public String toString(){
        return String.format("%-20s - %s - %-50s - Standing: %s", this.getName(), this.getDob(),
                this.getEmail(), "PhD Student");

    }
}
