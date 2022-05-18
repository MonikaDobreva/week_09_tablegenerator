package io.github.fontysvenlo.ddlgenerator;

import entities.CourseModule;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class ModuleTableGeneratorTest extends GeneratorTestBase {


    
    
    /**
     * Create a table once, then run all tests on it.
     */
    public ModuleTableGeneratorTest() {
        super( CourseModule.class );
    }

    /**
     * Assert all column definitions are correct.Each test data line contains
     * field name, type and modifiers like NOT NULL etc.
     *
     * @param fieldName sic
     * @param expectedValue sic
     */
    //@Disabled( "Think TDD" )
    @ParameterizedTest
    @CsvSource( {
        "moduleid,SERIAL",
        "moduleid,PRIMARY KEY",
        "name,NOT NULL",
        "credits,NOT NULL",
        "credits,DEFAULT (5)",
        "credits,CHECK",
        "credits,(credits > 0)"
    } )
    public void columnDefs( String fieldName, String expectedValue ) {
        assertTypeConversion( tableDefinition, fieldName, expectedValue );
    }

}
