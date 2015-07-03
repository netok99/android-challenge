package com.example.neto.challenge.fragments;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.neto.challenge.Flickr;
import com.example.neto.challenge.R;
import com.example.neto.challenge.adapters.CommentAdapter;
import com.example.neto.challenge.models.Comment;
import com.example.neto.challenge.models.GetListCommentsObjectResponse;
import com.example.neto.challenge.models.Photo;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EFragment(R.layout.fragment_photo_detail)
public class PhotoDetailFragment extends Fragment{

    @FragmentArg
    Photo photo;

    @ViewById(R.id.tv_owner_information)
    TextView ownerInformation;

    @ViewById(R.id.tv_photo_name_information)
    TextView photoTitle;

    @ViewById(R.id.iv_image_information)
    ImageView image;

    @ViewById(R.id.tv_sum_comments_information)
    TextView sumComment;

    @ViewById(R.id.tv_views_information)
    TextView sumView;

    @ViewById(R.id.tv_nocomments_information)
    TextView noComment;

    @ViewById(R.id.list_comments_information)
    ListView listComment;

    @AfterViews
    void init(){
        loadDetailPhotos();
    }

    public void loadDetailPhotos(){
        Flickr flickr = new Flickr();
        flickr.getCommentsList(photo.getId(), new Callback<GetListCommentsObjectResponse>() {
            @Override
            public void success(GetListCommentsObjectResponse getListCommentsObjectResponse, Response response) {
                List<Comment> comments = getListCommentsObjectResponse.getComments().getComment();
                ownerInformation.setText(photo.getOwnername());
                photoTitle.setText(photo.getTitle());
                Picasso.with(getActivity()).load(photo.getUrl_o())
                        .resize(800, 800)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.gato_no)
                        .into(image);
                sumComment.setText(comments != null ? String.valueOf(comments.size()) : "0");
                sumView.setText(String.valueOf(photo.getViews()));
                //List of comments
                if (comments != null) {
                    noComment.setVisibility(View.GONE);
                    CommentAdapter adapter = new CommentAdapter(getActivity(), comments);
                    listComment.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    //cno comments
                    listComment.setVisibility(View.GONE);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(Flickr.TAG, "something Bad happened!", error);
            }
        });
    }
}
