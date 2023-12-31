package ui.screens;

import domain.Controller;
import ui.Input;
import ui.table.Row;
import ui.table.Table;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Screen {
    private final ArrayList<Screen> screens;
    public MainMenu(String name, Controller controller) {
        super(name,controller);
        screens = new ArrayList<>();
    }

    public MainMenu(String name,Controller controller,ArrayList<Screen> screens) {
        super(name,controller);
        this.screens = screens;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    @Override
    public boolean show() {
        while (true) {
            Table table = new Table(name, new ArrayList<>(List.of("#", "Option")), true);
            int count = 1;
            for (Screen screen : screens) {
                Row row = new Row();
                //System.out.println(count + ". " + screen.getName());
                row.addCell("" + count).addCell(screen.getName());
                table.addRow(row);
                count++;
            }
            table.addRow(new Row().addCell("" + 0).addCell("EXIT"));
            System.out.println(table.getTableString());
            int choice = Input.inputInt(">");
            if (choice == 0) return false;
            screens.get(choice - 1).show();
        }

    }
}
