package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyTracks {
    String token = ("Bearer BQAwl9ZcOARo6EeeJk8F2hFsmv_B3k2iMAqpaPcTOJ0iw_ZmBQ3IbJQK6hzzLPq9Iy7JIF1SMhGUKilv8abILLTLgYy9aq4Eu94dOuGty80LHa3JJpJgH7KNvlYe5djuhSBoByQS91uHCIT9cuCnmtXYOaCNe3bp_Qty6K1FylxNnPsZTteMPU98jAACxSNwm7pwVvKc9OMlIomiV8q4a68rW7VOzh7eHa67NaD1spxDxmpe0Soir0aiAA2gWcCUcn0");

     String  TrackId = "7Els4IIFYa4P4RxBkZkxdd";

    @Test
    public void getSeveralTracksThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getTrackThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Track_ID",TrackId)
                .get("\thttps://api.spotify.com/v1/tracks/{Track_ID}");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getTrackAudiosFeaturesThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Track_ID",TrackId)
                .get("https://api.spotify.com/v1/audio-features/{Track_ID}");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getTracksAudiosFeaturesThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",TrackId)
                .get("\thttps://api.spotify.com/v1/audio-features");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getTracksAudiosAnalysisThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Track_ID",TrackId)
                .get("\thttps://api.spotify.com/v1/audio-analysis/{Track_ID}");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

}
