package com.example.neto.challenge;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.example.neto.challenge.fragments.PhotoDetailFragment;
import com.example.neto.challenge.fragments.PhotoDetailFragment_;
import com.example.neto.challenge.models.Photo;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_photo_detail)
public class PhotoDetailActivity extends ActionBarActivity {

    @ViewById(R.id.tb_main)
    Toolbar toolbar;

    @Extra("photo")
    Photo photo;

    @AfterViews
    void initActivity() {
        toolbar.setTitle(photo.getTitle());
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Fragment
        PhotoDetailFragment fragment = (PhotoDetailFragment) getSupportFragmentManager().findFragmentByTag("mainFragDetail");
        if(fragment == null) {
            fragment = PhotoDetailFragment_.builder().photo(photo).build();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container_detail, fragment, "mainFragDetail");
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
