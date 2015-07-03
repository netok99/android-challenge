package com.example.neto.challenge.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.neto.challenge.Flickr;
import com.example.neto.challenge.PhotoDetailActivity_;
import com.example.neto.challenge.R;
import com.example.neto.challenge.interfaces.ViewOnClickListenerPhoto;
import com.example.neto.challenge.adapters.PhotoAdapter;
import com.example.neto.challenge.models.Photo;
import com.example.neto.challenge.models.RecentsObjectResponse;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EFragment(R.layout.fragment_photo)
public class PhotoFragment extends Fragment implements ViewOnClickListenerPhoto {

    @ViewById(R.id.rv_list)
    RecyclerView recyclerView;

    List<Photo> photoList;

    @AfterViews
    void init(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        loadPhotos();
    }

    private void loadPhotos(){
        Flickr flickr = new Flickr();
        flickr.getRecent(new Callback<RecentsObjectResponse>() {
            @Override
            public void success(RecentsObjectResponse recentsObjectResponse, Response response) {
                photoList = recentsObjectResponse.getPhotos().getPhoto();
                PhotoAdapter adapter = new PhotoAdapter(photoList, getActivity());
                adapter.setViewOnClickListenerPhoto(PhotoFragment.this);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(Flickr.TAG, "something Bad happened!", error);
            }
        });
    }

    @Override
    public void onClickListener(View view, int position) {
        Intent it = new Intent(getActivity(), PhotoDetailActivity_.class);
        it.putExtra("photo", photoList.get(position));
        startActivity(it);
    }
}
