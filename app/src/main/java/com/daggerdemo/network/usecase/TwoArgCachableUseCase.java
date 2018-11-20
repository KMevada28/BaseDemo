/*
 * Copyright © 2017 Demo_By_K_Mevada. All rights reserved.
 */

package com.daggerdemo.network.usecase;


import java.util.Iterator;
import java.util.Map;

import io.reactivex.Observable;

public abstract class TwoArgCachableUseCase<A,B,R> extends CachableUseCase<TwoArgCachableUseCase.Pair<A,B>,R> {

    public TwoArgCachableUseCase(final UseCaseComposer composer) {
        super(composer);
    }

    protected abstract Observable<R> createCachableUseCaseObservable(A first, B second);

    public Observable<CachableValue<R>> execute(A first, B second) {
        return super.execute(new Pair<>(first, second));
    }

    public boolean isRunningForParam(final A param) {
        if (param == null) {
            return false;
        }
        for (Pair<A,B> key : observablesMap.keySet()) {
            if (key.first.equals(param)) {
                return true;
            }
        }
        return false;
    }

    public B getSecondParam(final A firstParam) {
        if (firstParam == null) {
            return null;
        }
        for (Map.Entry<Pair<A,B>, Observable<CachableValue<R>>> entry : observablesMap.entrySet()) {
            if (entry.getKey().first.equals(firstParam)) {
                return entry.getKey().second;
            }
        }
        return null;
    }

    public void invalidateCacheForFirst(A param) {
        for (Iterator<Map.Entry<Pair<A,B>, CachedValue<R>>> it = cache.entrySet().iterator(); it.hasNext(); ) {
            Pair<A,B> key = it.next().getKey();
            if (key.first.equals(param)) {
                it.remove();
            }
        }
    }

    public void invalidateCache(A first, B second) {
        invalidateCache(new Pair<>(first, second));
    }

    @Override
    protected final Observable<R> createCachableUseCaseObservable(Pair<A,B> param) {
        return createCachableUseCaseObservable(param.first, param.second);
    }

    @Override
    protected final boolean shouldCache(final Pair<A, B> param) {
        return shouldCache(param.first, param.second);
    }

    protected boolean shouldCache(final A first, final B second) {
        return true;
    }

    protected static class Pair<F,S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }
}
