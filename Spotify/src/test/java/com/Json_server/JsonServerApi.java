package com.Json_server;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonServerApi {

    @Test
    public void createPost_ReturnOkStatus(){
       Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"id\" : 9,\n" +
                        "        \"title\": \"Bridgelabz\",\n" +
                        "        \"author\": \"QA tester\"\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/posts");
       getResult.prettyPrint();
       getResult.then().assertThat().statusCode(201);
    }

    @Test
    public void getAllPosts_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .get(" http://localhost:3000/posts");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getSpecificPosts_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("Post_ID","2")
                .get(" http://localhost:3000/posts/{Post_ID}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void updateSpecificPost_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"title\": \"Ravan\",\n" +
                        "        \"author\": \"Sharad tandale\"\n" +
                        "    }")
                .pathParam("Post_ID","3")
                .put(" http://localhost:3000/posts/{Post_ID}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void deleteSpecificPost_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("Post_ID","9")
                .delete(" http://localhost:3000/posts/{Post_ID}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getAllComents_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .get(" http://localhost:3000/comments");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }
    @Test
    public void addComents_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"id\": 2,\n" +
                        "        \"body\": \"comment\",\n" +
                        "        \"postId\": 5\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/comments");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);
    }

    @Test
    public void getAllComentsForSpecificPostId_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .queryParam("postId","5")
                .get(" http://localhost:3000/comments");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }


    @Test
    public void updateSpecificComment_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"body\": \"comment2\",\n" +
                        "    \"postId\": 5\n" +
                        "}")
                .when()
                .pathParam("id","2")
                .put("http://localhost:3000/comments/{id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }


    @Test
    public void deleteSpecificComments_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .pathParam("Id","2")
                .delete(" http://localhost:3000/comments/{Id}");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getAllProfiles_ReturnOkStatus(){
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .get(" http://localhost:3000/profile");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void addProfile_ReturnOkStatus() {
        Response getResult = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "        \"Id\" : 3,\n" +
                        "        \"Name\" : \"Yogesh\",\n" +
                        "        \"City\": \"Pune\",\n" +
                        "        \"postId\": 1\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/profile");
        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);
    }

}
