package ui.screens;

import domain.Controller;
import domain.Superhero;
import ui.Input;
import ui.table.Row;
import ui.table.Table;

import java.util.ArrayList;
import java.util.List;

public class EditSuperhero extends Screen{
    public EditSuperhero(String name, Controller controller) {
        super(name, controller);
    }
    public boolean editSuperhero(Superhero superhero) {
        Table table = new Table("Edit " + superhero.getName(),
                new ArrayList<>(List.of("Superhero Name"," Real Name","Human?","Superpower","Strength","Year created")),true);
        table.addRow(new Row().addCell(superhero.getName())
                .addCell(superhero.getRealName())
                .addCell(superhero.isHuman())
                .addCell(superhero.getSuperPower())
                .addCell(superhero.getStrength())
                .addCell(superhero.getCreationYear()));
        //System.out.println("Edit: " + superhero.getName());
        System.out.println(table.getTableString());
        System.out.println("Press ENTER to Edit, 0 to EXIT");
        String back = Input.inputString(">");
        if (!back.isEmpty()) {
            return true;
        }
        System.out.println("Press Enter for no change.");
        System.out.println("Name: " + superhero.getName());
        String newName = Input.inputString("> ");
        if (!newName.isEmpty()) superhero.setName(newName);

        System.out.println("Real Name: " + superhero.getRealName());
        String newRealName = Input.inputString("> ");
        if (!newRealName.isEmpty()) superhero.setRealName(newRealName);

        System.out.println(superhero.getName() + " is " + (superhero.isHuman() ? "Human" : "not Human"));
        char choice = Input.inputChar("Change human status? (y)/(n)");
        if (choice == 'y') {
            superhero.setHuman(!superhero.isHuman());
        }

        System.out.println("Superpower: " + superhero.getSuperPower());
        String newSuperPowqer = Input.inputString(": ");
        if (!newSuperPowqer.isEmpty()) superhero.setSuperPower(newSuperPowqer);

        System.out.println("Strength: " + superhero.getStrength());
        String newStrength = Input.inputString(": ");
        if (!newStrength.isEmpty()) superhero.setStrength(Integer.parseInt(newStrength));

        System.out.println("Creation Year: " + superhero.getCreationYear());
        String newCreationYear = Input.inputString("> ");
        if (!newCreationYear.isEmpty()) superhero.setCreationYear(Integer.parseInt(newCreationYear));
        controller.saveToDb();
        return false;
    }
    public void editMenu() {
        System.out.println("Search by Superhero name.");
        String searchTerm = Input.inputString("Search: ");
        ArrayList<Superhero> result = controller.searchMany(searchTerm);
        boolean run = true;
        while (run) {
            int count = 1;
            if (!result.isEmpty()) {
                if (result.size() == 1) {
                    editSuperhero(result.get(0));
                    run = false;
                } else {
                    Table table = new Table("Search Results",
                            new ArrayList<>(List.of("#","Superhero")));
                    for (Superhero superhero : result) {
                        //System.out.println(count++ + ". " + superhero.getName());
                        table.addRow(new Row().addCell("" + count++).addCell(superhero.getName()));
                    }
                    System.out.println(table.getTableString());
                    System.out.println("Select superhero to EDIT. 0 to exit.");
                    int choice = Input.inputInt("> ",result.size(),true);
                    if(choice == 0) run = false;
                    if (choice <= result.size() && choice > 0) {
                        run = editSuperhero(result.get(choice - 1));
                    } else {
                        run = false;
                    }
                }
            } else {
                System.out.println("None Found.");
                run = false;
            }
        }
    }
    @Override
    public boolean show() {
        editMenu();
        return false;
    }
}
