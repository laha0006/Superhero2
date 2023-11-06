package ui.screens;

import domain.Controller;
import domain.Superhero;
import ui.Input;
import ui.table.*;

import java.util.ArrayList;
import java.util.List;

public class SearchDatabase extends Screen{
    public SearchDatabase(String name, Controller controller) {
        super(name, controller);
    }

    public void searchSuperhero() {
        boolean searching = true;
        while(searching) {
            System.out.println("0 to EXIT");
            String searchTerm = Input.inputString("Search: ");
            try {
                if(Integer.parseInt(searchTerm) == 0) {
                    return;
                }
            } catch (Exception ignored) {}


            Superhero sh = controller.search(searchTerm);
            if (sh != null) {
                Table table = new Table(sh.getName(),
                        new ArrayList<>(List.of("Superhero Name", " Real Name", "Human?", "Superpower", "Strength", "Year created")));
                table.addRow(new Row().addCell(sh.getName())
                        .addCell(sh.getRealName())
                        .addCell(sh.isHuman())
                        .addCell(sh.getSuperPower())
                        .addCell(sh.getStrength())
                        .addCell(sh.getCreationYear()));

                System.out.println(table.getTableString());
                searching = false;
                System.out.println("Press ENTER to EXIT");
                Input.inputString("> ");
            } else {
                System.out.println("None found.");
            }
        }
    }

    @Override
    public boolean show() {
        searchSuperhero();
        return false;
    }
}
