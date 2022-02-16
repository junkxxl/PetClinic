package me.junkxxl.testing.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Pet {

    int id;
    String name;
    String birthDate;
    PetType type;
    Owner owner;

    public Pet(int id, String name, String birthDate, PetType type, Owner owner) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PetType getType() {
        return type;
    }

    public Owner getOwner() {
        return owner;
    }


}
