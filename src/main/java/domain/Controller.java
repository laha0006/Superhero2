package domain;

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

    public Superhero search(String searchTerm) {
        return superheroList.search(searchTerm);
    }

    public void delete(Superhero superhero) {
        superheroList.delete(superhero);
    }

    public void sortBy(int primary, int secondary,int order1, int order2) {
        superheroList.sortBy(primary,secondary,order1,order2);
    }
}
