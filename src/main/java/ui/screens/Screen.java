package ui.screens;

public abstract class Screen {
    protected final String name;

    public Screen(String name) {
        this.name = name;
    }
    public abstract boolean show();

    protected String getName() {
        return name;
    }
}
