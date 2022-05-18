package io.github.fontysvenlo.tablegenerator;

/**
 * Interface for table creator.
 * 
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 * @param <E> type to convert
 */
public interface TableCreator<E> {

    /**
     * Write the sql definition of a table for an entity type.The table should
     * be named using simple plural, like
     * {@code entityType.getSimpleName().toLowerCase() + 's'}.The column names
 should be dutch casing (bicyclePump -&gt; bicyclepump). If a field is
 Annotated with {@code @ID}, the first field with that
     * annotation is tagged primary key.
     *
     * @param out stream to print to
     * @throws java.lang.Exception whenever there is a need.
     */
    void createTable( Appendable out ) throws Exception;

}
