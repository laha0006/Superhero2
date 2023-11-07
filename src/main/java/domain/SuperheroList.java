package domain;

import data.FileHandler;
import domain.comparators.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperheroList {
    private final ArrayList<Superhero> superheroList;
    private final FileHandler fileHandler;

    public SuperheroList() {
        superheroList = new ArrayList<>();
        fileHandler = new FileHandler();
        loadDatabaseIntoList();
    }

    private void loadDatabaseIntoList() {
        ArrayList<String[]> data = fileHandler.loadData();
        for(String[] sh : data) {
            superheroList.add(new Superhero(sh[0],
                    sh[1],
                    Boolean. parseBoolean(sh[2]),
                    sh[3],
                    Integer.parseInt(sh[4]),
                    Integer.parseInt(sh[5])));
        }
    }

    public void save() {
        fileHandler.writeToCsv(superheroList);
    }

    public void addSuperhero(Superhero superhero) {
        superheroList.add(superhero);
        save();
    }

    public Superhero search(String superheroName) {
        for (Superhero superhero : superheroList) {
            if (superhero.getName().toLowerCase().contains(superheroName.toLowerCase())) {
                return superhero;
            }
        }
        return null;
    }

    public ArrayList<Superhero> searchMany(String superheroName) {
        ArrayList<Superhero> superheroes = new ArrayList<>();
        for (Superhero superhero : superheroList) {
            if (superhero.getName().toLowerCase().contains(superheroName.toLowerCase())) {
                superheroes.add(superhero);
            }
        }
        return superheroes;
    }

    public ArrayList<Superhero> getSuperheroList() {
        return superheroList;
    }

    @Override
    public String toString() {
        return "superhero.Database{" +
                "superheroList=" + superheroList +
                '}';
    }

    public void delete(Superhero superhero) {
        superheroList.remove(superhero);
        save();
    }

    public void sortBy(int primary, int secondary,int order1, int order2) {
        ArrayList<Comparator<Superhero>> comparators = new ArrayList<>(List.of(
                new SuperheroNameComparator(),
                new SuperheroRealNameComparator(),
                new SuperheroIsHumanComparator(),
                new SuperheroSuperpowerComparator(),
                new SuperheroStrengthComparator(),
                new SuperheroYearCreatedComparator()
        ));
        Comparator<Superhero> primaryComparator = comparators.get(primary);
        Comparator<Superhero> secondaryComparator = comparators.get(secondary);
        if(order1 == 1) primaryComparator  = primaryComparator.reversed();
        if(order2 == 1) secondaryComparator  = secondaryComparator.reversed();
        superheroList.sort(primaryComparator
                .thenComparing(secondaryComparator));

    }
}
