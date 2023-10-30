package ui.screens;

import java.util.ArrayList;
import java.util.List;

import domain.Controller;
import domain.Superhero;
import ui.Color;
import ui.Input;
import ui.table.*;

public class ShowDatabase extends Screen {

    public ShowDatabase(String name,Controller controller) {
        super(name,controller);

    }
    public void showDatabase() throws Exception {
        ArrayList<Superhero> superheroes = controller.getSuperheroList();
        Table table = new Table("Superheros",
                new ArrayList<>(List.of("Superhero Name","Real Name",
                        "Human?","Superpower","Strength","Year Created")),true);
        for (Superhero hero : superheroes) {
            table.addRow(new Row().addCell(hero.getName())
                    .addCell(hero.getRealName(), Color.ORANGE)
                    .addCell(hero.isHuman())
                    .addCell(hero.getSuperPower())
                    .addCell(hero.getStrength())
                    .addCell(hero.getCreationYear()));
        }
        System.out.println(table.getTableString());
    }

    @Override
    public boolean show() {
        try {
            showDatabase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Input.back();
        return false;
    }
}
