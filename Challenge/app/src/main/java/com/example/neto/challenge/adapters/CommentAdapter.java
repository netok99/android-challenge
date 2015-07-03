package com.example.neto.challenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.neto.challenge.R;
import com.example.neto.challenge.models.Comment;

import java.util.List;

public class CommentAdapter extends BaseAdapter {

    private Context context;
    private List<Comment> comments;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = comments.get(position);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.item_comment, null);

        TextView user = (TextView)layout.findViewById(R.id.tv_item_user_comment);
        user.setText(comment.getAuthorname());
        TextView textComment = (TextView)layout.findViewById(R.id.tv_item_comment);
        textComment.setText(comment.get_content());

        return layout;
    }
}
