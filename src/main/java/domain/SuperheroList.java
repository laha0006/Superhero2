package domain;

import data.Database;

import java.util.ArrayList;

public class SuperheroList {
    private final ArrayList<Superhero> superheroList;
    private final Database db;

    public SuperheroList() {
        superheroList = new ArrayList<>();
        db = new Database();
        loadDatabaseIntoList();
    }

    private void loadDatabaseIntoList() {
        ArrayList<String[]> data = db.loadData();
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
        db.writeToCsv(superheroList);
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

    public void delete(int index) {
        superheroList.remove(index);
        save();
    }

}
