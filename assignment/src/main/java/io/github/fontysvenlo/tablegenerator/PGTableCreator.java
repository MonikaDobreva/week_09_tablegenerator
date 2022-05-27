package io.github.fontysvenlo.tablegenerator;

import io.github.fontysvenlo.annotations.Default;
import io.github.fontysvenlo.annotations.NotNull;
import io.github.fontysvenlo.annotations.Check;
import io.github.fontysvenlo.annotations.ID;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;

/**
 * Create table defintion for a class.
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 * @param <E> type type of the entity
 */
public class PGTableCreator<E> implements TableCreator<E> {

    final Class<E> entityType;

    public PGTableCreator( Class<E> entityType ) {
        this.entityType = entityType;
    }
    
    /**
     * Create the table definition from the entityType
     * 
     * @param out The Appendable where all lines of the table definition should be appended to
     * @throws IOException 
     */
    @Override
    public void createTable( Appendable out ) throws IOException {
        out.append("CREATE TABLE ").append(entityType.getSimpleName().toLowerCase()).append("s (\n");

            Field[] declaredFields = entityType.getDeclaredFields();
            List<String> outLines = new ArrayList<>();
            for ( Field field : declaredFields ) {
                StringBuilder ol = new StringBuilder();
                String pgType = TypeMappings.getPGTypeName( field.getType() );
                String declaration = processAnnotations( pgType, field );
                ol.append( "    " )
                        .append( declaration );
                outLines.add( ol.toString() );

            }
            String body = outLines.stream().collect( joining( "," + System.lineSeparator() ) );
            out.append( body )
                    .append( System.lineSeparator() )
                    .append( ");" )
                    .append( System.lineSeparator() )
                    .append( System.lineSeparator() );

        

    }

    
    /**
     * Process the name and annotations on the field to a PostgreSQL column definition.
     * 
     * @param pgTypeName name of the field/ column
     * @param field the java field definition, which may have annotations to be processed.
     * @return the column definition
     */
    String processAnnotations( String pgTypeName, Field field ) {
        StringBuilder annotationBuild = new StringBuilder();
        Annotation[] annotations = field.getDeclaredAnnotations();
        boolean contained = false;

        for (Annotation info : annotations){
            if (info.toString().contains("ID")){
                contained = true;

                if (pgTypeName.equals("INTEGER")){
                    annotationBuild.append(" SERIAL PRIMARY KEY");
                } else if (pgTypeName.equals("BIGINT")){
                    annotationBuild.append(" BIGSERIAL PRIMARY KEY");
                }

            } else if (info.toString().contains("NotNull")){
                annotationBuild.append(" NOT NULL");
            } else if (info.toString().contains("Default")){
                annotationBuild.append(" DEFAULT (").append(info.toString().split("\"")[1]).append(")");
            } else if (info.toString().contains("Check")){
                annotationBuild.append(" CHECK (").append(info.toString().split("\"")[1]).append(")");
            }
        }

        if (contained){
            return field.getName() + annotationBuild;
        } else {
            return field.getName() + " " + pgTypeName + annotationBuild;
        }
    }
}
