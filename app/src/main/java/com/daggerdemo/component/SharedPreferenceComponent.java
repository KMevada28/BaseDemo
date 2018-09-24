package com.daggerdemo.component;

import com.daggerdemo.MainActivity;
import com.daggerdemo.module.SharedPreferenceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */
@Singleton
@Component(modules = {SharedPreferenceModule.class})
public interface SharedPreferenceComponent {
    void inject(MainActivity mainActivity);
}
