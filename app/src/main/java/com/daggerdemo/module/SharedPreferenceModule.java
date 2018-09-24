package com.daggerdemo.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */
@Module
public class SharedPreferenceModule {

    Context context;

    public SharedPreferenceModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences getSharedPreference() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
