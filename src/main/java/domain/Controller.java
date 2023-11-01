package domain;

import java.util.ArrayList;

public class Controller {

    private final SuperheroList db;
    public Controller() {
        db = new SuperheroList();
    }
    public ArrayList<Superhero> getSuperheroList() {
        return db.getSuperheroList();
    }
}
