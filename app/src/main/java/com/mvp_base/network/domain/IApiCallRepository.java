package com.mvp_base.network.domain;

import com.mvp_base.entity.response.EmployeeResponseEntity;

import io.reactivex.Observable;

/**
 * Created by kundankumar.mevada on 11/14/2018.
 */

public interface IApiCallRepository {
    Observable<EmployeeResponseEntity> getEmployee(String empId);
}