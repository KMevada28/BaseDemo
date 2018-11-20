/*
 * Copyright © 2018 Demo_By_K_Mevada. All rights reserved.
 */

package com.daggerdemo.network.repository;

import com.daggerdemo.entity.response.EmployeeResponseEntity;
import com.daggerdemo.entity.response.LabelResponseEntity;
import com.daggerdemo.network.dataClass.ApiCallFactory;
import com.daggerdemo.network.domain.IApiCallRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Kundan on 07-12-2017.
 */

public class ApiCallRepository implements IApiCallRepository {

    private final ApiCallFactory apiCallFactory;

    @Inject
    public ApiCallRepository(ApiCallFactory apiCallFactory) {
        this.apiCallFactory = apiCallFactory;
    }

    @Override
    public Observable<EmployeeResponseEntity> getEmployee(String empId) {
        return apiCallFactory.getEmployee(empId);
    }

}