package domain;

import data.FileHandler;

import java.util.ArrayList;

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

}
