package me.junkxxl.testing.model;

public class Owner {
    int id;
    String firstName;
    String lastName;
    String address;
    String city;
    String telephone;

    public Owner(int id, String firstname, String lastname, String address, String city, String telephone) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }
}

