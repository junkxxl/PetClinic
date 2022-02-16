package me.junkxxl.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.junkxxl.testing.model.PetType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

public class PetTypeTest extends Start {


    @Test
    void getPetTypes() {

        when().get(url + "pettypes").
                then().assertThat().statusCode(200).
                and().body("name", hasItem("bird"));

    }

    @Test
    void postPetType() throws JsonProcessingException {

        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(new PetType(7, "turtle"))).


                when().post(url + "pettypes").
                then().assertThat().statusCode(201).
                body("id", Matchers.equalTo(7)).
                body("name", Matchers.equalTo("turtle"));

    }

    @Test
    void deletePetType() {
        when().delete(url + "pettypes/2").
                then().assertThat().statusCode(204);

    }

    @Test
    void getPetType() {

        when().get(url + "pettypes/1").
                then().assertThat().statusCode(200).
                and().body("name", Matchers.equalTo("cat"));

    }

    @Test
    void putPetType() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(new PetType(3, "dog"))).

                when().put(url + "pettypes/3").
                then().assertThat().statusCode(204);

    }

}
