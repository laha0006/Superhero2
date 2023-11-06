package domain.comparators;

import domain.Superhero;

import java.util.Comparator;

public class SuperheroIsHumanComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Boolean.compare(o1.isHuman(),o2.isHuman())
    }
}
