package com.mvp_base.network;/*
 * Copyright © 2017 Demo_By_K_Mevada. All rights reserved.
 */


import com.mvp_base.network.annotation.Cache;
import com.mvp_base.network.annotation.CachePolicy;
import com.mvp_base.network.annotation.CacheTimeout;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.Request;

public class CacheAdapterFactory extends CallAdapter.Factory {

    private static final RxJava2CallAdapterFactory rxFactory = RxJava2CallAdapterFactory.create();

    private static final ResponseCache cache = ResponseCache.create();

    public static CacheAdapterFactory create() {
        return new CacheAdapterFactory();
    }

    private CacheAdapterFactory() {
    }

    @Override
    public CallAdapter<?, Observable<?>> get(final Type type, final Annotation[] annotations, final Retrofit retrofit) {
        return new CacheRxAdapter(annotations, rxFactory.get(type, annotations, retrofit));
    }

    private static class CacheRxAdapter<R> implements CallAdapter<R, Observable<?>> {

        private CallAdapter<R, ?> rxCallAdapter;

        private CachePolicy cachePolicy = null;

        private long timout = CacheTimeout.NEVER;

        public CacheRxAdapter(final Annotation[] annotations, final CallAdapter<R, ?> rxCallAdapter) {
            this.rxCallAdapter = rxCallAdapter;
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Cache.class) {
                    Cache cacheAnnotation = (Cache) annotation;
                    cachePolicy = cacheAnnotation.value();
                } else if (annotation.annotationType() == CacheTimeout.class) {
                    CacheTimeout cacheTimeoutAnnotation = (CacheTimeout) annotation;
                    timout = cacheTimeoutAnnotation.value();
                }
            }
        }

        @Override
        public Type responseType() {
            return rxCallAdapter.responseType();
        }

        @Override
        public Observable<?> adapt(final Call<R> call) {
            Request request = call.request();
            if (cachePolicy != null) {
                return cache.cache(request, new AdapterObservableFactory<>(rxCallAdapter, call), cachePolicy, timout);
            } else {
                return (Observable<?>) rxCallAdapter.adapt(call);
            }
        }
    }

    private static class AdapterObservableFactory<R, T> implements ResponseCache.ObservableFactory<T> {

        private final CallAdapter<R, T> rxCallAdapter;

        private final Call<R> call;

        public AdapterObservableFactory(final CallAdapter<R, T> rxCallAdapter, final Call<R> call) {
            this.rxCallAdapter = rxCallAdapter;
            this.call = call;
        }

        @Override
        public Observable<T> create() {
            return (Observable<T>) rxCallAdapter.adapt(call);
        }
    }

}
