package domain;

import data.Database;

import java.util.ArrayList;

public class Controller {

    private final SuperheroList superheroList;
    public Controller() {
        superheroList = new SuperheroList();
    }
    public ArrayList<Superhero> getSuperheroList() {
        return superheroList.getSuperheroList();
    }

    public void addSuperhero(Superhero superhero) {
        superheroList.addSuperhero(superhero);
    }

    public ArrayList<Superhero> searchMany(String searchTerm) {
        return superheroList.searchMany(searchTerm);
    }

    public void saveToDb() {
        superheroList.save();
    }
}
