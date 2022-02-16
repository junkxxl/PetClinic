package me.junkxxl.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.junkxxl.testing.model.Owner;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;


public class OwnerTest extends Start {


    @Test
    void getOwners() {
        when().get(url + "owners").
                then().assertThat().statusCode(200).
                and().body("firstName", hasItem("George"));

    }

    @Test
    void postOwner() throws JsonProcessingException {
        given().header("Content-type", "application/json").body(mapper.writeValueAsString(new Owner(11, "Alex", "Ivanov",
                        "Mira 35", "Moscow", "9256221042"))).
                when().post(url + "owners").
                then().assertThat().statusCode(201).
                body("firstName", Matchers.equalTo("Alex")).
                body("lastName", Matchers.equalTo("Ivanov")).
                body("address", Matchers.equalTo("Mira 35")).
                body("city", Matchers.equalTo("Moscow")).
                body("telephone", Matchers.equalTo("9256221042"));

    }

    @Test
    void getOwner() {
        when().get(url + "owners/4").
                then().assertThat().statusCode(200).
                body("lastName", Matchers.equalTo("Davis"));

    }

    @Test
    void deleteOwner() {
        when().delete(url + "owners/10").
                then().assertThat().statusCode(204);


    }

    @Test
    void putOwner() throws JsonProcessingException {
        given().header("Content-type", "application/json").body(mapper.writeValueAsString(new Owner(3, "Alexey", "Petrov",
                        "Lenina 2", "Moscow", "9065681167"))).
                when().put(url + "owners/3").
                then().assertThat().statusCode(204);


    }

}
