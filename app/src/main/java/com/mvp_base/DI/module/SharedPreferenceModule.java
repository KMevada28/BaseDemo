package com.mvp_base.DI.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mvp_base.DI.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */
@Module
public class SharedPreferenceModule {

    private Context context;

    public SharedPreferenceModule(Context context) {
        this.context = context;
    }

    @ActivityScope
    @Provides
    Context provideContext() {
        return context;
    }

    @ActivityScope
    @Provides
    SharedPreferences getSharedPreference() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
