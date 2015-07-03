package com.example.neto.challenge.models;

public class Comment {

    private String id;
    private String author;
    private String authorname;
    private String iconserver;
    private int iconfarm;
    private String datecreate;
    private String realname;
    private String _content;

    public Comment(String id, String author, String authorname, String iconserver, int iconfarm,
                   String datecreate, String realname, String _content) {
        this.id = id;
        this.author = author;
        this.authorname = authorname;
        this.iconserver = iconserver;
        this.iconfarm = iconfarm;
        this.datecreate = datecreate;
        this.realname = realname;
        this._content = _content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public int getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(int iconfarm) {
        this.iconfarm = iconfarm;
    }

    public String getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(String datecreate) {
        this.datecreate = datecreate;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
