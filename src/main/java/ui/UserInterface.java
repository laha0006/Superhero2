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
        mainMenu.addScreen(showDatabase);
        mainMenu.addScreen(addSuphero);
        mainMenu.addScreen(editSuphero);

        boolean run = true;
        while(run) {
            run = mainMenu.show();
        }
    }
}
