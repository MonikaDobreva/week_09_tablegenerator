package entities;

import io.github.fontysvenlo.annotations.Check;
import io.github.fontysvenlo.annotations.Default;
import io.github.fontysvenlo.annotations.ID;
import io.github.fontysvenlo.annotations.NotNull;

/**
 * Bit like a fontys course.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class CourseModule {

    @ID
    private Long moduleid;
    
    @NotNull
    String name;
    
    @NotNull
    @Default( value = "5" )
    @Check( value = "credits > 0" )
    Integer credits;
    
}
