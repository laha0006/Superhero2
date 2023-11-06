package ui.screens;

import domain.Controller;
import ui.Input;
import ui.table.Row;
import ui.table.Table;

import java.util.ArrayList;
import java.util.List;

public class ShowSortedDatabase extends Screen {
    private Screen showDatabase;
    private ArrayList<String> sortByAttributes;

    public ShowSortedDatabase(String name, Controller controller) {
        super(name, controller);
        showDatabase = new ShowDatabase("Show",controller);
        sortByAttributes = new ArrayList<>();

    }

    private void showDatabase() {
        showDatabase.show();
    }

    private void sortBy(String prompt) {
        ArrayList<String> attributes = new ArrayList<>(List.of(
                "Superhero Name","Real Name","Is Human?","Superpower","Strength","Year Created"
        ));
        Table sortBy = new Table(prompt,
                new ArrayList<>(List.of("#","Attribute")));
        for(String attr : attributes) {
            if(!sortByAttributes.contains(attr)) {
                sortBy.addRow(new Row().addCell(attributes.indexOf(attr)+1).addCell(attr));
            }
        }
        System.out.println(sortBy);
        int choice = Input.inputInt("> ");
        sortByAttributes.add(attributes.get(choice-1));
    }

    private void sort() {
        controller.sortBy(sortByAttributes);
    }

    @Override
    public boolean show() {
        sortByAttributes.clear();
        sortBy("Sort by primary");
        sortBy("Sort by secondary");
        sort();
        showDatabase();
        return false;
    }
}
