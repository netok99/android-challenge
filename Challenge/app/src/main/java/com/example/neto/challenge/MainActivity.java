package com.example.neto.challenge;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.example.neto.challenge.fragments.PhotoFragment;
import com.example.neto.challenge.fragments.PhotoFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.tb_main)
    Toolbar mToolbar;

    @AfterViews
    void initActivity(){
        mToolbar.setTitle("Flickr");
        mToolbar.setSubtitle("");
        mToolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(mToolbar);

        //FRAGMENT
        PhotoFragment fragment = (PhotoFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(fragment == null) {
            fragment = PhotoFragment_.builder().build();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container, fragment, "mainFrag");
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
