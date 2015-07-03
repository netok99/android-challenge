package com.example.neto.challenge.models;

import java.util.List;

public class GetListCommentsResponse {

    private String photo_id;
    private List<Comment> comment;

    public GetListCommentsResponse(String photo_id, List<Comment> comment) {
        this.photo_id = photo_id;
        this.comment = comment;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
