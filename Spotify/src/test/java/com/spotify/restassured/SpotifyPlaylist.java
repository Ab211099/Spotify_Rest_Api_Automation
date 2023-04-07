package com.spotify.restassured;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class SpotifyPlaylist {
    String token = ("Bearer BQD2LZEW7L9gGsqfrAVZR4tEQ0Ppth1F4F1bya-gxxUgsVQgWXupBd8ycKDxFUpuk7dGgjMU2MKIJGBC5q6zKUKqLd3eNoQyz4Z1GVqvZDt-cST6-nkYwhQ39-m5SolA_cvOLuGV04FWRIuv4DyhudrkxqFxwNFun25Tt5k7KSEMtpwo03NOwjx50o7PLs1W41mk9ARZX8I6Nx43JLlg-P0eYBda2mvm5nI_MptYn8m4O36-gbO69PwmXxUgbH87GqPYW1XFssYd2b0qq3YzOuxVHyxfYdVXoxX14AU-Jgv6Q4meZusCjTAGpEDCWFc");
    String userId = "31odxj2yvkmy3chuam72mam3jwoi";
    String PlaylisId = "6DnO0wuI3zqF85XYyySuK4";

    @Test
    public void getCurrentUserProfileApiExecution_ReturnSuccess(){
            Response getResult = given().accept("application/json")
                                        .contentType("application/json")
                                        .header("Authorization",token)
                                        .get("https://api.spotify.com/v1/me");

            String UserId = getResult.path("id");
            getResult.prettyPrint();
            getResult.then().assertThat().statusCode(200);
            Assert.assertEquals(UserId,"31odxj2yvkmy3chuam72mam3jwoi");

    }

    @Test
    public void getUserProfile_ReturnOkStatusCode(){
           Response getResult = given().accept("application/json")
                                        .contentType("application/json")
                                        .header("Authorization", token)
                                        .pathParam("UserId",userId)
                                        .get("https://api.spotify.com/v1/users/{UserId}");

           getResult.prettyPrint();
           getResult.then().assertThat().statusCode(200);
           String UserId = getResult.path("id");
           Assert.assertEquals(UserId,"31odxj2yvkmy3chuam72mam3jwoi");

    }

    @Test
    public void createPlaylist_ThenReturn_OkStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .body("{\n" +
                                            "  \"name\": \"Kahani suno\",\n" +
                                            "  \"description\": \"2.2\",\n" +
                                            "  \"public\": false\n" +
                                            "}")
                                    .when()
                                    .pathParam("UserId",userId)
                                    .post("https://api.spotify.com/v1/users/{UserId}/playlists");

        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);

    }

    @Test
    public void getUserPlaylists_ThenReturn_OkStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .pathParam("UserId",userId)
                                    .get("\thttps://api.spotify.com/v1/users/{UserId}/playlists");

            getResult.prettyPrint();
            getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getPlaylistItems_ThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .pathParam("Playlistid",PlaylisId)
                                    .get("https://api.spotify.com/v1/playlists/{Playlistid}/tracks");

            getResult.prettyPrint();
            getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getCurrentUserPlaylists_ThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .get("https://api.spotify.com/v1/me/playlists");

        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void getCurrentUserPlaylistsCoverImage_ThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .pathParam("PlaylistId",PlaylisId)
                                    .get("\thttps://api.spotify.com/v1/playlists/{PlaylistId}/images");

        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);
    }

    @Test
    public void addItemsToPlaylist_ThenReturn_OkStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .body("{\"uris\": [\"spotify:track:561jH07mF1jHuk7KlaeF0s\",\"spotify:track:7lQ8MOhq6IN2w8EYcFNSUk\"]}")
                                    .when()
                                    .pathParam("PlaylistId",PlaylisId)
                                    .post("https://api.spotify.com/v1/playlists/{PlaylistId}/tracks");

        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(201);

    }

    @Test
    public void remove_PlaylistsItems_ThenReturn_OkStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .body("{ \"tracks\": [{ \"uri\": \"spotify:track:1301WleyT98MSxVHPZCA6M\" }] }")
                                    .when()
                                    .pathParam("PlaylistId",PlaylisId)
                                    .delete("\thttps://api.spotify.com/v1/playlists/{PlaylistId}/tracks");

        getResult.prettyPrint();
        getResult.then().assertThat().statusCode(200);

    }

    @Test
    public void update_PlaylistsDetails_ThenReturn_OkStatus(){
        Response getResult = given().accept("application/json")
                                    .contentType("application/json")
                                    .header("Authorization",token)
                                    .body("{\n" +
                                            "  \"name\": \"Instrumental.2.0\",\n" +
                                            "  \"description\": \"Lofi Song.2.0\",\n" +
                                            "  \"public\": false\n" +
                                            "}")
                                    .when()
                                    .pathParam("PlaylistId",PlaylisId)
                                    .put("\thttps://api.spotify.com/v1/playlists/{PlaylistId}");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

}
