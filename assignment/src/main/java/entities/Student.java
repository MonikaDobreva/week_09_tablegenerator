package entities;

import io.github.fontysvenlo.annotations.ID;
import java.time.LocalDate;

/**
 * Simple student with LocalDate birthday.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class Student {

    @ID
    private Integer snummer;
    private String lastname;
    private String firstname;
    private LocalDate dob;
    private short cohort;
    private String email;
    private String gender;
    private String student_class;
    
    
}
