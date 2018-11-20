/*
 * Copyright © 2017 Demo_By_K_Mevada. All rights reserved.
 */

package com.mvp_base.network.usecase;


public class CachableValue<T> {

    private final T value;

    private final boolean fromCache;

    private final boolean continued;

    public CachableValue(final T value, final boolean fromCache, final boolean continued) {
        this.value = value;
        this.fromCache = fromCache;
        this.continued = continued;
    }

    public T get() {
        return value;
    }

    public boolean isCached() {
        return fromCache;
    }

    public boolean isContinued() {
        return continued;
    }

}
