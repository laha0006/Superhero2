import domain.Controller;
import domain.Superhero;
import ui.UserInterface;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        UserInterface ui = new UserInterface(controller);
        ui.start();
    }


}
