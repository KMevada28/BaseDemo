/*
 * Copyright © 2018 Demo_By_K_Mevada. All rights reserved.
 */

package com.daggerdemo.network;

import com.daggerdemo.entity.response.EmployeeResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LabelManagementAPI {

    @GET("employee/{empId}")
    Observable<EmployeeResponseEntity> getEmployeeResponse(@Path("empId") String empId);

}

