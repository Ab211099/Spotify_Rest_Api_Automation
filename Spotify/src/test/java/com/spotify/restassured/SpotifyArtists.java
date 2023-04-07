package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyArtists {

    String token = ("Bearer BQAvZ7oCSSAGGmjoiN7L2CuOvFgSyy416GpfPlmw87Pe6akG5nAKEzkxfFFPp_r1e2te7kDaWU93p13epTKCjIlzxJNC8_02orYWYNFwnxCQw0cxQFPvl_tzULaqf5SjfD3fA0Em0XFOI9CQOXQ57aBQId0Gs7fDm47L1zjcPUPRXgROnfLdkkhcbUOz5V_hOMcKynot0W-KxrVN2dnNgu4wwGqgvRWDiLuy48cVahgSij3SQ4y17VS8dXkMX0UGEQo");

    String ArtistId = "0LyfQWJT6nXafLPZqxe9Of";
    @Test
    public void getArtistAlbumsThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("ArtistId",ArtistId)
                .get("\thttps://api.spotify.com/v1/artists/{ArtistId}/albums");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void getArtistThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("ArtistId",ArtistId)
                .get("https://api.spotify.com/v1/artists/{ArtistId}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getSeveralArtistThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",ArtistId)
                .get("https://api.spotify.com/v1/artists");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void getArtistRelatedArtistThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Artist_Id",ArtistId)
                .get("https://api.spotify.com/v1/artists/{Artist_Id}/related-artists");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getArtistTopTracksThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Artist_Id",ArtistId)
                .queryParam("market","ES")
                .get("https://api.spotify.com/v1/artists/{Artist_Id}/top-tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
}
