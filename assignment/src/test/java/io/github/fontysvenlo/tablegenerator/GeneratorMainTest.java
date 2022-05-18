package io.github.fontysvenlo.tablegenerator;

import io.github.fontysvenlo.tablegenerator.GeneratorMain;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
 
/**
 *
 * @author m.bonajo@fontys.nl
 */
public class GeneratorMainTest {

    /**
     * Test of main method, of class GeneratorMain.
     */
    @Test
    public void testMainWithoutArgs() {
        String[] args = new String[]{};
        ThrowingCallable code = () -> {
           GeneratorMain.main(args);
        };
        
        assertThatCode(code)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Supply class name");
    }
    
    @Test
    public void testMainWithValidClass() {
        String[] args = new String[]{"entities.Student"};
        ThrowingCallable code = () -> {
           GeneratorMain.main(args);
        };
        
        assertThatCode(code)
                .doesNotThrowAnyException();
    }
    
    @Test
    public void testMainWithInvalidClass() {
        String clazz = "test";
        String[] args = new String[]{clazz};
        
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        PrintStream err = System.err;
        
        System.setErr(new PrintStream(content));
        
        GeneratorMain.main(args);
        
        System.setErr(err);
        
        assertThat(content.toString()).contains("ClassNotFoundException", clazz);
    }
    
    @Test
    public void testConstructor() {
        GeneratorMain generatorMain = new GeneratorMain();
        assertThat(generatorMain).isNotNull();
    }

}
