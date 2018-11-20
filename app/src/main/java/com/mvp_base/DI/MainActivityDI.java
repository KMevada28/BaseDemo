package com.mvp_base.DI;

import android.content.Context;

import com.mvp_base.DI.component.DaggerMainActivityComponent;
import com.mvp_base.DI.component.MainActivityComponent;
import com.mvp_base.DI.module.MainDemoActivityModule;
import com.mvp_base.DI.module.SharedPreferenceModule;


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
