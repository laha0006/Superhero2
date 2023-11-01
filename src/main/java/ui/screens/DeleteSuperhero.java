package ui.screens;

import domain.Controller;
import domain.Superhero;
import ui.Input;
import ui.table.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeleteSuperhero extends Screen{
    public DeleteSuperhero(String name, Controller controller) {
        super(name, controller);
    }

     public void deleteSuperhero() {
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
                System.out.println("Type DELETE to DELETE or Press ENTER to EXIT");
                String choice = Input.inputString("> ");
                if(Objects.equals(choice, "DELETE")) controller.delete(sh);
            } else {
                System.out.println("None found.");
            }
        }
    }

    @Override
    public boolean show() {
        deleteSuperhero();
        return false;
    }
}
