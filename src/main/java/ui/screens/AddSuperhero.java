package ui.screens;

import domain.Controller;
import domain.Superhero;
import domain.SuperheroList;
import ui.Input;

public class AddSuperhero extends Screen {
    public AddSuperhero(String name, Controller controller) {
        super(name,controller);
    }

    public void inputSuperhero() {
        boolean isHuman;
        String name = Input.inputString("Superhero name: ");
        String realName = Input.inputString("Real name: ");
        String superPower = Input.inputString("Superpower: ");
        char isHumanYesNo = Input.inputChar("Is Human? (y/n): ");
        switch (isHumanYesNo) {
            case 'y':
                isHuman = true;
                break;
            case 'n':
                isHuman = false;
                break;
            default:
                isHuman = true;
                break;
        }
        int strength = Input.inputInt("Strength: ");
        int yearCreated = Input.inputInt("Year Created: ");

        controller.addSuperhero(new Superhero(name, realName, isHuman, superPower, yearCreated, strength));


    }
    @Override
    public boolean show() {
        inputSuperhero();
        return false;
    }

}
