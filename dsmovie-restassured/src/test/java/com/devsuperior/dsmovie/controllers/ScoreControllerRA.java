package com.devsuperior.dsmovie.controllers;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class ScoreControllerRA {

    private Long existingMovieId, nonExistingMovieId;
    private Map<String, Object> putMovieInstance;

    @BeforeEach
    void setUp() {
        baseURI = "http://localhost:8080";

        existingMovieId = 11L;
        nonExistingMovieId = 100L;

        putMovieInstance = new HashMap<>();
        putMovieInstance.put("title", "Test Movie");
        putMovieInstance.put("score", 0.0);
        putMovieInstance.put("count", 0);
        putMovieInstance.put("image", "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg");
    }

    @Test
    public void saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist() throws Exception {
        nonExistingMovieId = 100L;

        JSONObject score = new JSONObject(putMovieInstance);

        given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(score.toString())
                .when()
                .put("/scores/{id}", nonExistingMovieId)
                .then()
                .statusCode(404);
    }

    @Test
    public void saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId() throws Exception {
        existingMovieId = 1L;

        JSONObject score = new JSONObject(putMovieInstance);

        given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(score.toString())
                .when()
                .put("/scores")
                .then()
                .statusCode(422)
                .body("errors[0].fieldName", equalTo("movieId"))
                .body("errors[0].message", equalTo("Campo requerido"))
                .body("status", is(422));
    }

    @Test
    public void saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero() throws Exception {
        putMovieInstance.put("score", -1.0);
        putMovieInstance.put("movieId", 2L);

        JSONObject score = new JSONObject(putMovieInstance);

        given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(score.toString())
                .when()
                .put("/scores")
                .then()
                .statusCode(422)
                .body("errors[0].fieldName", equalTo("score"))
                .body("errors[0].message", equalTo("Valor mínimo 0"))
                .body("status", is(422));
    }
}
