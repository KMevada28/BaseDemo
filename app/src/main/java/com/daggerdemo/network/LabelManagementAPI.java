/*
 * Copyright © 2018 Demo_By_K_Mevada. All rights reserved.
 */

package com.daggerdemo.network;

import com.daggerdemo.entity.response.EmployeeResponseEntity;
import com.daggerdemo.entity.response.LabelResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LabelManagementAPI {

    @GET("employee")
    Observable<EmployeeResponseEntity> getEmployeeResponse(String empId);

}

