package com.example.neto.challenge.models;

public class GetListCommentsObjectResponse {

    private GetListCommentsResponse comments;
    private String stat;

    public GetListCommentsObjectResponse(GetListCommentsResponse comments, String stat) {
        this.comments = comments;
        this.stat = stat;
    }

    public GetListCommentsResponse getComments() {
        return comments;
    }

    public void setComments(GetListCommentsResponse comments) {
        this.comments = comments;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
