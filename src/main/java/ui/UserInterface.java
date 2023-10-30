package ui;

import domain.Controller;
import ui.screens.MainMenu;
import ui.screens.Screen;
import ui.screens.ShowDatabase;

public class UserInterface {

    private final Controller controller;
    public UserInterface(Controller controller) {
        this.controller = controller;
    }
    public void start() {
        MainMenu mainMenu = new MainMenu("Superhero v2",controller);
        Screen showDatabase = new ShowDatabase("Show Database",controller);
        mainMenu.addScreen(showDatabase);
        boolean run = true;
        while(run) {
            run = mainMenu.show();
        }
    }
}
