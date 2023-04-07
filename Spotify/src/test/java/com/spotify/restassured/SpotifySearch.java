package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifySearch {

    @Test
    public void searchThenReturn_OkStatus(){

        String token = ("Bearer BQAwl9ZcOARo6EeeJk8F2hFsmv_B3k2iMAqpaPcTOJ0iw_ZmBQ3IbJQK6hzzLPq9Iy7JIF1SMhGUKilv8abILLTLgYy9aq4Eu94dOuGty80LHa3JJpJgH7KNvlYe5djuhSBoByQS91uHCIT9cuCnmtXYOaCNe3bp_Qty6K1FylxNnPsZTteMPU98jAACxSNwm7pwVvKc9OMlIomiV8q4a68rW7VOzh7eHa67NaD1spxDxmpe0Soir0aiAA2gWcCUcn0");
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("q","arjit singh")
                .queryParam("type","track")
                .when()
                .get("\thttps://api.spotify.com/v1/search");
        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
}
