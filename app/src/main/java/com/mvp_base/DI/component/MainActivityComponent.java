package com.mvp_base.DI.component;

import com.mvp_base.DI.module.MainDemoActivityModule;
import com.mvp_base.MainActivity;
import com.mvp_base.DI.scopes.ActivityScope;
import com.mvp_base.DI.module.SharedPreferenceModule;

import dagger.Component;

/**
 * Created by kundankumar.mevada on 11/14/2018.
 */
@ActivityScope
@Component(modules = {MainDemoActivityModule.class, SharedPreferenceModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
