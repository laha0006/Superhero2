package ui.screens;

import domain.Controller;

public abstract class Screen {
    protected final String name;
    protected final Controller controller;

    public Screen(String name,Controller controller) {
        this.name = name;
        this.controller = controller;
    }
    public abstract boolean show();

    protected String getName() {
        return name;
    }
}
