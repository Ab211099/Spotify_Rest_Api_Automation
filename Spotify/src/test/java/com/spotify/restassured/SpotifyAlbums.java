package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyAlbums {

    String token = ("Bearer BQAvZ7oCSSAGGmjoiN7L2CuOvFgSyy416GpfPlmw87Pe6akG5nAKEzkxfFFPp_r1e2te7kDaWU93p13epTKCjIlzxJNC8_02orYWYNFwnxCQw0cxQFPvl_tzULaqf5SjfD3fA0Em0XFOI9CQOXQ57aBQId0Gs7fDm47L1zjcPUPRXgROnfLdkkhcbUOz5V_hOMcKynot0W-KxrVN2dnNgu4wwGqgvRWDiLuy48cVahgSij3SQ4y17VS8dXkMX0UGEQo");

    String AlbumId = "5kiZkGMkfKm3tIlh2Tgfi5";

    @Test
    public void getSeveralAlbumsThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",AlbumId)
                .get("https://api.spotify.com/v1/albums");

            getResult.prettyPrint();
            Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getAlbumsTracksThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Album_ID",AlbumId)
                .get("https://api.spotify.com/v1/albums/{Album_ID}/tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getAlbumsThenReturn_OkStatus(){

        Response getResult = given().given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Album_ID",AlbumId)
                .get("\thttps://api.spotify.com/v1/albums/{Album_ID}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
}
