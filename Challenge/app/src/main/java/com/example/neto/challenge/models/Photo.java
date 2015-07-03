package com.example.neto.challenge.models;

import java.io.Serializable;

public class Photo implements Serializable{
    private String id;
    private String owner;
    private String secret;
    private String server;
    private int farm;
    private String title;
    private int isPublic;
    private int isfriend;
    private int isfamily;
    private String linkPhoto;
    private String ownername;
    private int views;
    private String url_n;
    private String url_c;
    private String url_b;
    private String url_z;
    private String url_o;

    public Photo(String id, String owner, String secret, String server, int farm, String title,
                 int isPublic, int isfriend, int isfamily, String linkPhoto, String ownername,
                 int views, String url_n, String url_c, String url_b, String url_z, String url_o) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.isPublic = isPublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
        this.linkPhoto = linkPhoto;
        this.ownername = ownername;
        this.views = views;
        this.url_n = url_n;
        this.url_c = url_c;
        this.url_b = url_b;
        this.url_z = url_z;
        this.url_o = url_o;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public String getLinkPhoto() {
        return linkPhoto;
    }

    public void setLinkPhoto(String linkPhoto) {
        this.linkPhoto = linkPhoto;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getUrl_n() {
        return url_n;
    }

    public void setUrl_n(String url_n) {
        this.url_n = url_n;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUrl_c() {
        return url_c;
    }

    public void setUrl_c(String url_c) {
        this.url_c = url_c;
    }

    public String getUrl_b() {
        return url_b;
    }

    public void setUrl_b(String url_b) {
        this.url_b = url_b;
    }

    public String getUrl_z() {
        return url_z;
    }

    public void setUrl_z(String url_z) {
        this.url_z = url_z;
    }

    public String getUrl_o() {

        return url_o;
    }

    public void setUrl_o(String url_o) {
        this.url_o = url_o;
    }
}
