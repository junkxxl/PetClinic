package me.junkxxl.testing.model;

public class Visits {
    int id;
    String date;
    String description;
    Pet pet;

    public Visits(int id, String date, String description, Pet pet) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Pet getPet() {
        return pet;
    }
}
