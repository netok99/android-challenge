package com.example.neto.challenge;

import com.example.neto.challenge.interfaces.FlickrService;
import com.example.neto.challenge.models.GetListCommentsObjectResponse;
import com.example.neto.challenge.models.RecentsObjectResponse;
import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.Callback;
import retrofit.converter.GsonConverter;

public class Flickr{

    private final String KEY = "822c35b1dcf57122de07ad39d7360735";
    private final String SECRET = "b60663c5d2aca5cc";
    private final String ENDPOINT = "https://api.flickr.com/services";

    public static final String TAG = "Flickr";

    //Recent photos list
    public void getRecent(Callback<RecentsObjectResponse> callback){
        int numberPhotos = 100;
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ENDPOINT)
                .build();
        FlickrService flickrService = restAdapter.create(FlickrService.class);
        flickrService.getRecent(KEY, numberPhotos, callback);
    }

    //Photo Comments
    public void getCommentsList(String id, Callback<GetListCommentsObjectResponse> callback){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new Gson()))
                .setEndpoint(ENDPOINT)
                .build();
        FlickrService flickrService = restAdapter.create(FlickrService.class);
        flickrService.getCommentsList(KEY, id, callback);
    }
}
