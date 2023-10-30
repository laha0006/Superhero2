package domain;

import java.util.ArrayList;

public class Controller {

    private final Database db;
    public Controller() {
        db = new Database();
    }
    public ArrayList<Superhero> getSuperheroList() {
        return db.getSuperheroList();
    }
}
