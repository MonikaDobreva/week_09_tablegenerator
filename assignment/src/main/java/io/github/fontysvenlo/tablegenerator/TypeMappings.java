package io.github.fontysvenlo.tablegenerator;

import java.util.Map;
import static java.util.Map.entry;

/**
 * Type mappings. Only implemented for postgresql.
 * 
 * In case you wonder: this is an enum with NO values. That is legal Java
 * and avoid having to test a non existing constructor, and any values.
 * You can use this trick for utility classes with only static members.
 * 
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public enum TypeMappings {
    ; // look ma, no values.
    public static final Map<Class<?>, String> pgTypeMap = Map.ofEntries( 
        entry( java.lang.String.class, "TEXT" ),
        entry( java.lang.Character.class, "CHAR(1)" ),
        entry( java.lang.Integer.class, "INTEGER" ),
        entry( int.class, "INTEGER" ),
        entry( java.lang.Short.class, "SMALLINT" ),
        entry( short.class, "SMALLINT" ),
        entry( java.lang.Long.class, "BIGINT" ),
        entry( long.class, "BIGINT" ),
        entry( java.math.BigDecimal.class, "DECIMAL" ),
        entry( java.math.BigInteger.class, "NUMERIC" ),
        entry( java.lang.Float.class, "REAL" ),
        entry( float.class, "REAL" ),
        entry( java.lang.Double.class, "DOUBLE PRECISION" ),
        entry( double.class, "DOUBLE PRECISION" ),
        entry( java.time.LocalDate.class, "DATE" ),
        entry( java.time.LocalDateTime.class, "TIMESTAMP" )
    );

    public static String getPGTypeName( Class<?> c ) {
        return pgTypeMap.get( c );
    }

}
