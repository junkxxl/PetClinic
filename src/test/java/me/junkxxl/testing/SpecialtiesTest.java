package me.junkxxl.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.junkxxl.testing.model.Specialties;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

public class SpecialtiesTest extends Start {

    @Test
    void getSpecialties() {

        when().get(url + "specialties").
                then().assertThat().statusCode(200).
                and().body("name", hasItem("dentistry"));

    }

    @Test
    void postSpecialization() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(new Specialties(4, "dermatology"))).


                when().post(url + "specialties").
                then().assertThat().statusCode(201).
                body("id", Matchers.equalTo(4)).
                body("name", Matchers.equalTo("dermatology"));
    }


    @Test
    void deleteSpecialization() {
        when().delete(url + "specialties/3").
                then().assertThat().statusCode(400);

    }


    @Test
    void getSpecialization() {

        when().get(url + "specialties/3").
                then().assertThat().statusCode(200).
                and().body("name", Matchers.equalTo("dentistry"));

    }


    @Test
    void putSpecialization() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(new Specialties(1, "proctology"))).

                when().put(url + "specialties/1").
                then().assertThat().statusCode(204);

    }
}
