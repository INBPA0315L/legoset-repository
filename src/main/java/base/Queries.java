package base;

import lego.LegoSet;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Defines queries for your {@link Repository} implementation.
 *
 * @param <T> the type of your entity (first class)
 * @param <U> the type of your nested class (second class)
 * @param <V> the type of your enum class
 */
public interface Queries<T, U, V extends Enum<V>> {
    /**
     * Returns the greatest (maximum) value of pieces.
     *
     * @return the maximum of pieces
     */
    int getMaximumOfPieces();

    /**
     * Returns the list of LEGO sets ordered by:
     *
     * <ol>
     *     <li>the count of bricks (descending)
     *     <li>the number (ascending)
     * </ol>
     *
     * The method cannot modify the original list.
     *
     * @return the sorted list of LEGO sets
     */
    List<T> getSetsOrderByCountOfBricksDescThenByNumber();

    /**
     * Returns the name of each LEGO set that belongs to the given theme.
     *
     * @param theme the theme
     * @return the names
     */
    Set<String> getNamesOfSetsByTheme(
            @NonNull V theme);

    /**
     * Returns a dictionary that maps the number of each LEGO set to its theme.
     *
     * @return the dictionary
     */
    Map<String, V> getThemesByCodes();

    /**
     * Returns a dictionary that groups the LEGO sets by their pieces.
     *
     * @return the dictionary
     */
    Map<Integer, Set<T>> getSetsByPieces();
}
