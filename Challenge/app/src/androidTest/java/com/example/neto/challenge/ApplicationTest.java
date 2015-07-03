package com.example.neto.challenge;

import android.app.Application;
import android.test.ApplicationTestCase;
import com.example.neto.challenge.models.GetListCommentsObjectResponse;
import com.example.neto.challenge.models.RecentsObjectResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void FlickrGetRecent(){
        Flickr flickr = new Flickr();
        flickr.getRecent(new Callback<RecentsObjectResponse>() {
            @Override
            public void success(RecentsObjectResponse recentsObjectResponse, Response response) {
                boolean test = false;
                if (recentsObjectResponse != null){
                    test = true;
                }
                assertEquals(test, true);
            }

            @Override
            public void failure(RetrofitError error) {
                assertEquals(false, true);
            }
        });

    }

    public void FlickrGetCommentsList() {
        Flickr flickr = new Flickr();
        flickr.getCommentsList("18680828694", new Callback<GetListCommentsObjectResponse>() {
            @Override
            public void success(GetListCommentsObjectResponse getListCommentsObjectResponse, Response response) {
                boolean test = false;
                if (getListCommentsObjectResponse != null){
                    test = true;
                }
                assertEquals(test, true);
            }

            @Override
            public void failure(RetrofitError error) {
                assertEquals(false, true);
            }
        });
    }
}