package lego;

import base.Queries;
import base.Repository;
import lombok.NonNull;

import java.io.IOException;
import java.util.*;

public class LegoRepository
        extends Repository<LegoSet>
        implements Queries<LegoSet, LegoSet.Minifigure, LegoSet.Theme> {

    public LegoRepository() throws IOException {
        super(LegoSet.class);
    }

    @Override
    public int getMaximumOfPieces() {
        int max = getAll().get(0).getBricks();
        for (int i = 1; i < getAll().size(); i++) {
            if (getAll().get(i).getBricks() > max) {
                max = getAll().get(i).getBricks();
            }
        }
        return max;
    }

    @Override
    public List<LegoSet> getSetsOrderByCountOfBricksDescThenByNumber() {
        List<LegoSet> copy = new ArrayList<>(getAll());
        copy.sort(LegoSet.COMPARATOR);
        return copy;
    }

    @Override
    public Set<String> getNamesOfSetsByTheme(LegoSet.@NonNull Theme theme) {
        Set<String> names = new HashSet<>();
        for (LegoSet legoSet : getAll()) {
            if (legoSet.getTheme() == theme) {
                names.add(legoSet.getName());
            }
        }
        return names;
    }

    @Override
    public Map<String, LegoSet.Theme> getThemesByCodes() {
        Map<String, LegoSet.Theme> result = new HashMap<>();
        for (LegoSet legoSet : getAll()) {
            result.put(legoSet.getCode(), legoSet.getTheme());
        }
        return result;
    }

    @Override
    public Map<Integer, Set<LegoSet>> getSetsByPieces() {
        return null;
    }

    public static void main(String[] args) throws IOException {
        LegoRepository repository = new LegoRepository();
        System.out.println(repository);
        System.out.println(repository.getMaximumOfPieces());

        for (String name : repository.getNamesOfSetsByTheme(LegoSet.Theme.CITY)) {
            System.out.println(name);
        }
    }
}
