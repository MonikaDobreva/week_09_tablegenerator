/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package entities;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
/**
 *
 * @author m.bonajo@fontys.nl
 */
public class StudentTest {

    @Test
    public void testSomeConstructor() {
        Student student = new Student();
        assertThat(student).isNotNull();
    }

}
