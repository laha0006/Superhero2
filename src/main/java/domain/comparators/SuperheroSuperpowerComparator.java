package domain.comparators;

import domain.Superhero;

import java.util.Comparator;

public class SuperheroSuperpowerComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o2.getSuperPower().compareTo(o2.getSuperPower());
    }
}
