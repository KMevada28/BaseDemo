package com.daggerdemo.base;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    protected void onBind() {

    }

    protected void onUnbind() {

    }

    public final void bind(V viewToBind) {
        view = viewToBind;
        onBind();
        //lifecycleSubject.onNext(PresenterEvent.ATTACH);
    }

    public final void unbind() {
        onUnbind();
        //lifecycleSubject.onNext(PresenterEvent.DETACH);
        view = null;
    }
}
