package com.daggerdemo.DI.component;

import com.daggerdemo.DI.module.MainDemoActivityModule;
import com.daggerdemo.MainActivity;
import com.daggerdemo.DI.scopes.ActivityScope;
import com.daggerdemo.module.SharedPreferenceModule;

import dagger.Component;

/**
 * Created by kundankumar.mevada on 11/14/2018.
 */
@ActivityScope
@Component(modules = {MainDemoActivityModule.class, SharedPreferenceModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
