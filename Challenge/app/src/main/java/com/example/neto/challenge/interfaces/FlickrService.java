package com.example.neto.challenge.interfaces;

import com.example.neto.challenge.models.GetListCommentsObjectResponse;
import com.example.neto.challenge.models.RecentsObjectResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface FlickrService {

    @GET("/rest/?method=flickr.photos.getRecent&format=json&nojsoncallback=1&extras=owner_name," +
            "views,url_n,url_c,url_b,url_z,url_o")
    void getRecent(@Query("api_key") String key, @Query("per_page") int perPage,
                   Callback<RecentsObjectResponse> callback);

    @GET("/rest/?method=flickr.photos.comments.getList&format=json&nojsoncallback=1")
    void getCommentsList(@Query("api_key") String key, @Query("photo_id") String photoId,
                      Callback<GetListCommentsObjectResponse> callback);

}
