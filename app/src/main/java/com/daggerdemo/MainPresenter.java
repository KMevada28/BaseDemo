package com.daggerdemo;

import android.content.SharedPreferences;

import com.daggerdemo.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */

public class MainPresenter extends BasePresenter<MainView> {

    SharedPreferences sharedPreferences;

    @Inject
    public MainPresenter(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    boolean calculateData(String userName) {
        if (userName.length() > 0 && view != null) {
            view.displaySpeechRecognizer();
            return true;
        } else {
            return false;
        }
    }
}
