package ui;

import domain.Controller;
import ui.screens.*;

public class UserInterface {

    private final Controller controller;
    public UserInterface(Controller controller) {
        this.controller = controller;
    }
    public void start() {
        MainMenu mainMenu = new MainMenu("Superhero v2",controller);
        Screen showDatabase = new ShowDatabase("Show Database",controller);
        Screen addSuphero = new AddSuperhero("Add Supehero",controller);
        Screen editSuphero = new EditSuperhero("Edit Supehero",controller);
        Screen searchDatabase = new SearchDatabase("Search Superhero", controller);
        Screen showSortedDatabase = new ShowSortedDatabase("Show Sorted Database",controller);
        Screen deleteSuperhero = new DeleteSuperhero("Delete Superhero", controller);
        mainMenu.addScreen(showDatabase);
        mainMenu.addScreen(showSortedDatabase);
        mainMenu.addScreen(addSuphero);
        mainMenu.addScreen(editSuphero);
        mainMenu.addScreen(searchDatabase);
        mainMenu.addScreen(deleteSuperhero);

        boolean run = true;
        while(run) {
            run = mainMenu.show();
        }
    }
}
