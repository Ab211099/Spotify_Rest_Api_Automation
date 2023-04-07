package com.spotify.restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class SpotifyPlayer {

    String token = ("Bearer BQACm11DsY5gVnudv3WC3tz8_Js26zpcAbsNiDabh8yoDgjfTEzzocGeEMxt0ZrwqysrJSdrGWbmmPA7IfpPdGb_sP8XiSUnEyIQQHdVBvTN-zfCxDPb35iv3lji0twe62Z188BRTZWNaoAthBS2jeilhIPcOUzwGPRYZ9RpEmYX6VlxlaZqQyC-WxSxftp5uCTp8UaSzQXpfUtnuLinpa52x8SMuWb0RwwZf5_SxtU-5hPqYXa4gn2zLNJ6CbaSq60");

    String Uri ;

    @Test
    public void getUserQueueThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/queue");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),403);
    }
    @Test
    public void getRecentlyPlayedTracksThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/me/player/recently-played");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }
    @Test
    public void getPlaybackStateThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),204);
    }

    @Test
    public void getAvailableDevicesThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("\thttps://api.spotify.com/v1/me/player/devices");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

    @Test
    public void getCurrentPlayingTracksThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/currently-playing");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),204);
    }
    @Test
    public void getSkipToNextThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/next");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),405);
    }
    @Test
    public void getSkipToPreviousThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .get("https://api.spotify.com/v1/me/player/previous");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),405);
    }

    @Test
    public void getTrackThenReturn_OKStatus(){
        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .pathParam("Track_ID","7Els4IIFYa4P4RxBkZkxdd")
                .get("https://api.spotify.com/v1/tracks/{Track_ID}");
        getResult.prettyPrint();

         Uri = getResult.path("uri");
        Assert.assertEquals(getResult.statusCode(),200);
    }


    @Test
    public void getAddItemsToPlaybackQueueThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("uri",Uri)
                .post("https://api.spotify.com/v1/me/player/queue");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),403);
    }

    @Test
    public void getPausePlaybackThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .post("https://api.spotify.com/v1/me/player/pause");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),403);
    }

    @Test
    public void getSetRepeatModeThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("state","561jH07mF1jHuk7KlaeF0s")
                .post("https://api.spotify.com/v1/me/player/repeat");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),403);
    }

    @Test
    public void getSeekPositionThenReturn_OkStatus(){

        Response getResult = given().accept("application/json")
                .contentType("application/json")
                .header("Authorization",token)
                .queryParam("position_ms","90000")
                .post("https://api.spotify.com/v1/me/player/seek");

        getResult.prettyPrint();
        Assert.assertEquals(getResult.statusCode(),200);
    }

}
