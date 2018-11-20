package com.daggerdemo.DI;

import android.content.Context;

import com.daggerdemo.DI.component.DaggerMainActivityComponent;
import com.daggerdemo.DI.component.MainActivityComponent;
import com.daggerdemo.DI.module.MainDemoActivityModule;
import com.daggerdemo.module.SharedPreferenceModule;


/**
 * Created by kundankumar.mevada on 11/14/2018.
 */

public class MainActivityDI {

    private static MainActivityComponent mainActivityComponent;

    public static MainActivityComponent getMainActivityComponent(Context context) {
        if (mainActivityComponent == null) {
            mainActivityComponent = DaggerMainActivityComponent.builder()
                    .sharedPreferenceModule(new SharedPreferenceModule(context))
                    .mainDemoActivityModule(new MainDemoActivityModule(context))
                    .build();
        }
        return mainActivityComponent;
    }

}
