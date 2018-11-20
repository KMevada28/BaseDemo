/*
 * Copyright © 2018 Demo_By_K_Mevada. All rights reserved.
 */

package com.mvp_base.network.repository;

import com.mvp_base.entity.response.EmployeeResponseEntity;
import com.mvp_base.network.dataClass.ApiCallFactory;
import com.mvp_base.network.domain.IApiCallRepository;

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