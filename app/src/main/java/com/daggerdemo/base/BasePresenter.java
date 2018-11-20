package com.daggerdemo.base;


import android.support.annotation.NonNull;

import com.daggerdemo.rxlifecycle.PresenterEvent;
import com.daggerdemo.rxlifecycle.RxLifecyclePresenter;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */

public abstract class BasePresenter<V extends BaseView> implements LifecycleProvider<Integer> {

    protected V view;

    private final BehaviorSubject<Integer> lifecycleSubject = BehaviorSubject.create();

    protected void onBind() {

    }

    protected void onUnbind() {

    }

    public final void bind(V viewToBind) {
        view = viewToBind;
        onBind();
        lifecycleSubject.onNext(PresenterEvent.ATTACH);
    }

    public final void unbind() {
        onUnbind();
        lifecycleSubject.onNext(PresenterEvent.DETACH);
        view = null;
    }

    @Override
    @NonNull
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecyclePresenter.bindPresenter(lifecycleSubject);
    }

    @NonNull
    @Override
    public Observable<Integer> lifecycle() {
        return lifecycleSubject.hide();
    }

    @NonNull
    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(@NonNull Integer event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }
}
