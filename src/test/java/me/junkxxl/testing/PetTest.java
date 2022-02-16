package me.junkxxl.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.junkxxl.testing.model.Owner;
import me.junkxxl.testing.model.Pet;
import me.junkxxl.testing.model.PetType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

public class PetTest extends Start {


    @Test
    void getPets() {

        when().get(url + "pets").
                then().assertThat().statusCode(200).
                and().body("name", hasItem("Leo"));

    }

    @Test
    void postPet() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(
                        new Pet(14, "Vaska", "2012/06/08",
                                new PetType(1, "cat"),
                                new Owner(1, "", "", "", "", "")))).


                when().post(url + "pets").
                then().assertThat().statusCode(201).
                body("id", Matchers.equalTo(14)).
                body("name", Matchers.equalTo("Vaska")).
                body("birthDate", Matchers.equalTo("2012/06/08"));
    }


    @Test
    void getPetPettypes() {

        when().get(url + "pets/pettypes").
                then().assertThat().statusCode(200).
                and().body("name", hasItem("snake"));

    }


    @Test
    void deletePet() {
        when().delete(url + "pets/2").
                then().assertThat().statusCode(204);

    }

    @Test
    void getPet() {

        when().get(url + "pets/6").
                then().assertThat().statusCode(200).
                and().body("name", Matchers.equalTo("George"));

    }


    @Test
    void putPets() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(
                        new Pet(5, "Reks", "2013/06/08",
                                new PetType(3, "dog"),
                                new Owner(4, "", "", "", "", "")))).


                when().put(url + "pets/5").
                then().assertThat().statusCode(204);

    }


}
