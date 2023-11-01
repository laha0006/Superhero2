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
}
