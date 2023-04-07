package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyLibrary {

    String token = ("Bearer BQD-fT8vc2lCtqoT9O-5dc1di65b5EiqqyQq2HZiFTP9RIIrYNVfOJYTM6XbOV_qjw18giDYZ8vbgrbcxULXmA1c4Dsxl3ynSA4Fn2UetM0r4L-u1ZKIB-TlU0nX9r3tvoaNjk5uHPhT_4jTYMhSR7duKobrrLXqoXD70hzj5_k1pHAMdxR9HXrj1evDMm93wDvybdkESxJLIbjVrIB2Adl650SbzaLei6R3X1tW6buPAfLaWSN4zslfyUk8-Orie_YKlNbQlxs4v_tF5szTV3sxkf2qAUE");

    String AlbumId = "0mNU7NPXsBH6NiWilJOz3c";
    String EpisodeId = "5n0QzRGIHzkChZfctLNQB5";
    String TrackId = "561jH07mF1jHuk7KlaeF0s";

    String ShowsId = "5OkQQ1EKGJPMv098wR3dl1";
    @Test
    public void checkUserSavedAlbumsThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",AlbumId)
                .get("https://api.spotify.com/v1/me/albums/contains");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void checkUserSavedEpisodesThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",EpisodeId)
                .get("https://api.spotify.com/v1/me/episodes/contains");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void checkUserSavedTracksThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",TrackId)
                .get("https://api.spotify.com/v1/me/tracks/contains");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void saveAlbumsForCurrentUserThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",AlbumId)
                .put("https://api.spotify.com/v1/me/albums");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void saveTrackForCurrentUserThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",TrackId)
                .put("https://api.spotify.com/v1/me/tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void saveEpisodeForCurrentUserThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",EpisodeId)
                .put("https://api.spotify.com/v1/me/episodes");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void saveShowForCurrentUserThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("ids",ShowsId)
                .put("https://api.spotify.com/v1/me/shows");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getUsersSavedAlbumsThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/albums");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getUsersSavedAudiobookThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/me/audiobooks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getUsersSavedEpisodesThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/episodes");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }

    @Test
    public void getUsersSavedShowsThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/shows");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
    @Test
    public void getUsersSavedTracksThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/tracks");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);

    }
}

