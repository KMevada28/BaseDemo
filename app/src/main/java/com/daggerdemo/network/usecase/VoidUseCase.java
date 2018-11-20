/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package com.daggerdemo.network.usecase;


import io.reactivex.Observable;

public abstract class VoidUseCase<R> extends UseCase<Void, R> {

    VoidUseCase(final UseCaseComposer useCaseComposer) {
        super(useCaseComposer);
    }

    protected abstract Observable<R> createUseCaseObservable();

    @Override
    protected final Observable<R> createUseCaseObservable(final Void param) {
        return createUseCaseObservable();
    }

    public final Observable<R> execute() {
        return execute(null);
    }

}
