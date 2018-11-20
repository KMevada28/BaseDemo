package com.daggerdemo.DI.module;

import android.content.Context;

import com.daggerdemo.DI.scopes.ActivityScope;
import com.daggerdemo.network.NetworkClient;
import com.daggerdemo.network.domain.IApiCallRepository;
import com.daggerdemo.network.repository.ApiCallRepository;
import com.daggerdemo.network.usecase.AndroidUseCaseComposer;
import com.daggerdemo.network.usecase.UseCaseComposer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kundankumar.mevada on 11/14/2018.
 */

@Module
public class MainDemoActivityModule {

    public MainDemoActivityModule(Context context) {
        Context context1 = context;
    }

    @Provides
    @ActivityScope
    NetworkClient provideNetworkClient() {
        return NetworkClient.getInstance();
    }

    @Provides
    @ActivityScope
    IApiCallRepository provideApiCallRepository(ApiCallRepository apiCallRepository) {
        return apiCallRepository;
    }

    @Provides
    UseCaseComposer provideUseCaseComposer() {
        return new AndroidUseCaseComposer();
    }
}
