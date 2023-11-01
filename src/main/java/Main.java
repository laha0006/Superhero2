import data.Database;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import domain.Controller;
import domain.Superhero;
import ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        UserInterface ui = new UserInterface(controller);
        ui.start();
//        ArrayList<Superhero> superheroes = controller.getSuperheroList();
//        Database db = new Database();
//        db.writeToCsv(superheroes);




    }
}
