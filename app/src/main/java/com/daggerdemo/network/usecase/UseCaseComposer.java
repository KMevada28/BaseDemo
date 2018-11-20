/*
 * Copyright © 2017 Demo_By_K_Mevada. All rights reserved.
 */

package com.daggerdemo.network.usecase;


import io.reactivex.ObservableTransformer;

public interface UseCaseComposer {

    <T> ObservableTransformer<T, T> apply();

}
