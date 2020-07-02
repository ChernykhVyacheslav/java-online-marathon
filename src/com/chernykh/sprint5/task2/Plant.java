package com.chernykh.sprint5.task2;

public class Plant {

    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws ColorException, TypeException {
        this.name = name;
        try {
            this.color = Color.valueOf(color);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new ColorException("Invalid value " + color + " for field color");
        }
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new TypeException("Invalid value " + type + " for field type");
        }
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type.name() +
                ", color: " + color.name() +
                ", name: " + name + '}';
    }
}
