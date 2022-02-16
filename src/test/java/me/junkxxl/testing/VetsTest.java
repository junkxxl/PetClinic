package me.junkxxl.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.junkxxl.testing.model.Vets;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;

public class VetsTest extends Start {

    @Test
    void getVets() {
        when().get(url+"vets").
                then().assertThat().statusCode(200).
                body("lastName", hasItem("Jenkins")).
                body("firstName", hasItem("James"));

    }

    @Test
    void postVet() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(new Vets(7,"Vladimir","Pushkin"))).
                when().post(url+"vets").
                then().assertThat().statusCode(201).
                body("firstName", Matchers.equalTo("Vladimir")).
                body("lastName", Matchers.equalTo("Pushkin"));

    }
    @Test
    void deleteVet() {
        when().delete(url+"vets/4").
                then().assertThat().statusCode(204);


    }

    @Test
    void getVet() {
        when().get(url+"vets/3").
                then().assertThat().statusCode(200).
                body("lastName", Matchers.equalTo("Douglas")).
                body("firstName", Matchers.equalTo("Linda"));

    }

    @Test
    void putVet() throws JsonProcessingException {
        given().header("Content-type", "application/json").
                body(mapper.writeValueAsString(new Vets(3,"Anton","Grishin"))).
                when().put(url+"vets/3").
                then().assertThat().statusCode(204);

    }

}
