package io.github.fontysvenlo.ddlgenerator;

import entities.Student;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Test the generator for a Student class.
 *
 * This test class creates the table once and then uses several method to test
 * the features of that table.
 *
 * There are some assumptions:
 * <ol>
 * <li>The first line start with CREATE TABLE tablename.
 * <li>Each field generates a line in the table definition</li>
 * <li>Said line contains the complete declaration, terminated with a comma,
 * unless it is the last column in the table declaration.</li>
 * <li>Constraint attributes are written on the same line</li>
 * <li>The table definition is terminate with "\n);\n"</li>
 * </ol>
 *
 * The approach is to find a 'keyword' such as the filed
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class StudentTableGeneratorTest extends GeneratorTestBase{

    public StudentTableGeneratorTest(  ) {
        super( Student.class );
    }


    /**
     * Test field definition using provided assertTypeConversion in super class.
     */
    //@Disabled( "Think TDD" )
    @Test
    void firstNameGeneratesText() {
        String fieldName = "firstname";
        String expectedType = "TEXT";
        assertTypeConversion( tableDefinition, fieldName, expectedType );
    }

    /**
     * Test field definition using provided assertTypeConversion in super class.
     */
    //@Disabled( "Think TDD" )
    @Test
    void idGeneratesPrimaryKey() {
        String fieldName = "snummer";
        String expectedType = "SERIAL PRIMARY KEY";
        assertTypeConversion( tableDefinition, fieldName, expectedType );
    }
}
