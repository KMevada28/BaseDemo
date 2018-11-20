package com.mvp_base.DI.module;

import android.content.Context;

import com.mvp_base.DI.scopes.ActivityScope;
import com.mvp_base.network.NetworkClient;
import com.mvp_base.network.domain.IApiCallRepository;
import com.mvp_base.network.repository.ApiCallRepository;
import com.mvp_base.network.usecase.AndroidUseCaseComposer;
import com.mvp_base.network.usecase.UseCaseComposer;


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
