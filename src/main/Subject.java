package main;

public class Subject {
    private String name;
    private Colour colour;

    public Subject(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public Colour getColour() {
        return colour;
    }
}
