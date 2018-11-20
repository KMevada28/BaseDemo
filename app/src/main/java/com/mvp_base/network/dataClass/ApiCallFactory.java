/*
 * Copyright © 2018 Demo_By_K_Mevada. All rights reserved.
 */

package com.mvp_base.network.dataClass;

import com.mvp_base.entity.response.EmployeeResponseEntity;
import com.mvp_base.network.LabelManagementAPI;
import com.mvp_base.network.NetworkClient;

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