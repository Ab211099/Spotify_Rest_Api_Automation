package com.PetSwaggger;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SwaggetPetApiTesting {

    @Test
    public void uploadFileToPetStore() {

        File file = new File("C:\\Users\\Administrator\\Pictures\\Screenshots\\Screenshot (2).png");

        given().accept("application/json")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/101/uploadImage")
                .then()
                .log().ifStatusCodeIsEqualTo(200);

    }

    @Test
    public void addPetToPetStore() {

        given().accept("application/json")
                .contentType("application/json")
                .body("\n" +
                        "  \"id\": 9223372036854244000,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().ifStatusCodeIsEqualTo(200);

    }

    @Test
    public void findPetById() {

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .pathParam("id","9223372036854244000")
                .when()
                .get("https://petstore.swagger.io/v2/pet/{id}");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void updatePetInTheStoreWithFormData() {

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .pathParam("id","101")
                .formParam("name","kanha")
                .formParam("status","sold")
                .when()
                .pathParam("id",)
                .get("https://petstore.swagger.io/v2/pet/{id}");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void updateAnExistingPet() {

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 9223372036854244000,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"Kanha\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .put("https://petstore.swagger.io/v2/pet");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void findPetByStatus() {

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .queryParam("status","sold")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }


}
