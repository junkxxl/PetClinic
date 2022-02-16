package me.junkxxl.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.junkxxl.testing.model.Owner;
import me.junkxxl.testing.model.Pet;
import me.junkxxl.testing.model.PetType;
import me.junkxxl.testing.model.Visits;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

public class VisitsTest extends Start {

    @Test
    void getVisits() {
        when().get(url + "visits").
                then().assertThat().statusCode(200).
                body("description", hasItem("rabies shot"));

    }

    @Test
    void postVisit() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(
                        new Visits(5, "2013/01/04", "spayed",
                                new Pet(2, "", "2012/06/08",
                                        new PetType(1, ""),
                                        new Owner(1, "", "", "", "", ""))))).

                when().post(url + "visits").
                then().assertThat().statusCode(201).
                body("description", Matchers.equalTo("spayed")).
                body("date", Matchers.equalTo("2013/01/04"));

    }

    @Test
    void deleteVisit() {
        when().delete(url + "visits/3").
                then().assertThat().statusCode(204);


    }

    @Test
    void getVisit() {
        when().get(url + "visits/2").
                then().assertThat().statusCode(200).
                body("description", Matchers.equalTo("rabies shot"));

    }

    @Test
    void putVisit() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(
                        new Visits(5, "2015/06/09", "vaccination",
                                new Pet(9, "", "2012/06/08",
                                        new PetType(1, ""),
                                        new Owner(1, "", "", "", "", ""))))).
                when().put(url + "visits/4").
                then().assertThat().statusCode(204);


    }
}
