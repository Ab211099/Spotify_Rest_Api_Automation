package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyEpisodes {

    String token = ("Bearer BQD-fT8vc2lCtqoT9O-5dc1di65b5EiqqyQq2HZiFTP9RIIrYNVfOJYTM6XbOV_qjw18giDYZ8vbgrbcxULXmA1c4Dsxl3ynSA4Fn2UetM0r4L-u1ZKIB-TlU0nX9r3tvoaNjk5uHPhT_4jTYMhSR7duKobrrLXqoXD70hzj5_k1pHAMdxR9HXrj1evDMm93wDvybdkESxJLIbjVrIB2Adl650SbzaLei6R3X1tW6buPAfLaWSN4zslfyUk8-Orie_YKlNbQlxs4v_tF5szTV3sxkf2qAUE");

    String EpisodeId = "0Qi5IGuvlPbN3yXGqfYWVM";

    @Test
    public void getSeveralEpisodesThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",EpisodeId)
                .get("https://api.spotify.com/v1/episodes");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
    @Test
    public void getEpisodeThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Episode_ID",EpisodeId)
                .get("https://api.spotify.com/v1/episodes/{Episode_ID}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
}
