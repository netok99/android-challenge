package com.example.neto.challenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neto.challenge.R;
import com.example.neto.challenge.interfaces.ViewOnClickListenerPhoto;
import com.example.neto.challenge.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder>{
    private List<Photo> photos;
    private LayoutInflater layoutInflater;
    private Context context;
    private ViewOnClickListenerPhoto viewOnClickListenerPhoto;

    public PhotoAdapter(List<Photo> photos, Context context){
        this.photos = photos;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_photo, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        Picasso.with(context)
                .load(photos.get(position).getUrl_z())
                .resize(70, 45)
                .placeholder(R.drawable.loading)
                .error(R.drawable.gato_no)
                .into(myViewHolder.iv_image);
        myViewHolder.tv_title.setText(photos.get(position).getTitle());
        myViewHolder.tv_description.setText(photos.get(position).getOwnername());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public ViewOnClickListenerPhoto getViewOnClickListenerPhoto() {
        return viewOnClickListenerPhoto;
    }

    public void setViewOnClickListenerPhoto(ViewOnClickListenerPhoto v) {
        this.viewOnClickListenerPhoto = v;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView iv_image;
        public TextView tv_title;
        public TextView tv_description;

        public MyViewHolder(View itemView){
            super(itemView);
            iv_image = (ImageView)itemView.findViewById(R.id.iv_image);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_description = (TextView)itemView.findViewById(R.id.tv_description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(viewOnClickListenerPhoto != null){
                viewOnClickListenerPhoto.onClickListener(v, getPosition());
            }
        }
    }
}