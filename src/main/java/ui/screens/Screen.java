package ui.screens;

public abstract class Screen {
    private final String name;

    public Screen(String name) {
        this.name = name;
    }
    public abstract boolean show();

}
