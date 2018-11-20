/*
 * Copyright © 2018 Nedbank. All rights reserved.
 */

package com.daggerdemo.network.dataClass;

import com.daggerdemo.entity.response.EmployeeResponseEntity;
import com.daggerdemo.network.LabelManagementAPI;
import com.daggerdemo.network.NetworkClient;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Kundan on 07-12-2017.
 */

public class ApiCallFactory {

    private final NetworkClient mNetworkClient;

    @Inject
    ApiCallFactory(NetworkClient networkClient) {
        this.mNetworkClient = networkClient;
    }

    public Observable<EmployeeResponseEntity> getEmployee(String empId) {
        return mNetworkClient.create(LabelManagementAPI.class).getEmployeeResponse(empId);
    }

}