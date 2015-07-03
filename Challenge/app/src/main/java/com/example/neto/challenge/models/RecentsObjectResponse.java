package com.example.neto.challenge.models;

public class RecentsObjectResponse {

    private RecentsPhotosResponse photos;
    private String stat;

    public RecentsObjectResponse(RecentsPhotosResponse photos, String stat) {
        this.photos = photos;
        this.stat = stat;
    }

    public RecentsPhotosResponse getPhotos() {
        return photos;
    }

    public void setPhotos(RecentsPhotosResponse photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
