package ui;

import ui.screens.MainMenu;
import ui.screens.Screen;

public class UserInterface {

    public UserInterface() {

    }
    public void start() {
        Screen mainMenu = new MainMenu("Superhero v2");
        boolean run = true;
        while(run) {
            run = mainMenu.show();
        }
    }
}
