package lego;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LegoSet implements Comparable<LegoSet> {
    // public static final LegoSetComparator COMPARATOR = new LegoSetComparator();
    public static final Comparator<LegoSet> COMPARATOR = new LegoSetComparator();

    @EqualsAndHashCode.Include
    private String code;
    private String name;
    private Theme theme;
    private int bricks;
    @ToString.Exclude
    private Set<Minifigure> minifigures;

    @Override
    public int compareTo(LegoSet o) {
        return Objects.compare(this, o, COMPARATOR);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    @AllArgsConstructor
    @Getter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Minifigure {
        @EqualsAndHashCode.Include
        private final String id;
        private final String name;
        private final int quantity;
    }

    public enum Theme {
        @JsonProperty("City") CITY,
        @JsonProperty("Harry Potter") HARRY_POTTER,
        @JsonProperty("Star Wars") STAR_WARS,
        @JsonProperty("Creator Expert") CREATOR_EXPERT
    }

    public static class LegoSetComparator
            implements Comparator<LegoSet> {
        @Override
        public int compare(LegoSet o1, LegoSet o2) {
            if (o1.bricks != o2.bricks) {
                // return -Integer.compare(o1.bricks, o2.bricks);
                // return Objects.compare(o1.bricks, o2.bricks,Comparator.naturalOrder());
                return Objects.compare(o1.bricks, o2.bricks, Comparator.reverseOrder());
            }

            // return o1.code.compareTo(o2.code);
            return Objects.compare(o1.code, o2.code, Comparator.naturalOrder());
        }
    }
}
