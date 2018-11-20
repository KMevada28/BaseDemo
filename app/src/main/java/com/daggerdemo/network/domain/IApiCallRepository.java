package com.daggerdemo.network.domain;

import com.daggerdemo.entity.response.EmployeeResponseEntity;
import com.daggerdemo.entity.response.LabelResponseEntity;

import io.reactivex.Observable;

/**
 * Created by kundankumar.mevada on 11/14/2018.
 */

public interface IApiCallRepository {
    Observable<EmployeeResponseEntity> getEmployee(String empId);
}