package ui.screens;

import domain.Controller;
import ui.Input;
import ui.table.Row;
import ui.table.Table;

import java.util.ArrayList;
import java.util.List;

public class ShowSortedDatabase extends Screen {
    private final ShowDatabase showDatabase;
    private final ArrayList<String> sortByAttributes;
    private final ArrayList<String> attributes;
    private final int[] orderBy = new int[2];

    public ShowSortedDatabase(String name, Controller controller) {
        super(name, controller);
        showDatabase = new ShowDatabase("Show",controller);
        attributes = new ArrayList<>(List.of(
                "Superhero Name","Real Name","Is Human?","Superpower","Strength","Year Created"
        ));
        sortByAttributes = new ArrayList<>();
    }

    private void showDatabase() {
        showDatabase.show();
    }

    private void sortBy(String prompt) {
        Table sortByTable = new Table(prompt,
                new ArrayList<>(List.of("#","Attribute")));
        for(String attr : attributes) {
            if(!sortByAttributes.contains(attr)) {
                sortByTable.addRow(new Row().addCell(attributes.indexOf(attr)+1).addCell(attr));
            }
        }
        System.out.println(sortByTable);
        int choice = Input.inputInt("> ",attributes.size(),false);
        sortByAttributes.add(attributes.get(choice-1));
    }

    private void setOrder(int index) {
        Table orderTable = new Table("Order in ",
                new ArrayList<>(List.of("#","Order")));
        orderTable.addRow(new Row().addCell(1).addCell("Ascending"));
        orderTable.addRow(new Row().addCell(2).addCell("Descending"));
        System.out.println(orderTable);
        int order = Input.inputInt("> ",2,false);
        orderBy[index] = order-1;
    }

    private void sort() {
        int primary = attributes.indexOf(sortByAttributes.get(0));
        int secondary = attributes.indexOf(sortByAttributes.get(1));
        controller.sortBy(primary,secondary,orderBy[0],orderBy[1]);
    }

    @Override
    public boolean show() {
        sortByAttributes.clear();
        sortBy("Sort by primary");
        setOrder(0);
        sortBy("Sort by secondary");
        setOrder(1);
        sort();
        showDatabase.show(attributes.indexOf(sortByAttributes.get(0)),
                attributes.indexOf(sortByAttributes.get(1)),
                orderBy[0],
                orderBy[1]);

        return false;
    }
}
