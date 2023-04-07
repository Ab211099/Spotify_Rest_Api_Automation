package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyAudiobooks {
    String token = ("Bearer BQDtKdbauvILMwJ6TjBZcCmTXYLdOFyCl0vaXh-fVM0aFjKhULcc5VSjN6Bi4ZfG9kxRZEQCYLw88nbU7a6XcZLreq9MqHVaJazTaAdJL0c6pWmlcU1V_FDqsjNHtkPwaZLOyltm_y_9y3laD41GsyfWV7AcGCqrcKQkp464PHx6TSygfyxoZ23EIjbhyAzLEN3Hj9h1uFKJCutOGuBRx5ihD35TXJK8LPyNgIYJphaXQkr5w7Kcuon4EIS-teCDNI0");

    String id = "18yVqkdbdRvS24c0Ilj2ci";
    @Test
    public void getSeveraAudiobookThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",id)
                .get("https://api.spotify.com/v1/audiobooks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getAnAudiobookThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id",id)
                .get("\thttps://api.spotify.com/v1/audiobooks/{id}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getAnAudiobookChaptersThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("id",id)
                .get("https://api.spotify.com/v1/audiobooks/{id}/chapters");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
}
