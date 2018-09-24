package com.daggerdemo.DI;

import android.content.Context;

import com.daggerdemo.component.DaggerSharedPreferenceComponent;
import com.daggerdemo.component.SharedPreferenceComponent;
import com.daggerdemo.module.SharedPreferenceModule;

/**
 * Created by kundankumar.mevada on 9/24/2018.
 */

public class SharedPrefDI {

    private static SharedPreferenceComponent sharedPreferenceComponent;

    public static SharedPreferenceComponent getShredPreferenceComponent(Context context) {
        if (sharedPreferenceComponent == null) {
            sharedPreferenceComponent = DaggerSharedPreferenceComponent.builder()
                    .sharedPreferenceModule(new SharedPreferenceModule(context)).build();
        }
        return sharedPreferenceComponent;
    }

}
