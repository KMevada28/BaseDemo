/*
 * Copyright © 2018 Nedbank. All rights reserved.
 */

package com.mvp_base.mapper.entityToDataModel;


import com.mvp_base.dataModel.EmployeeResponseDataModel;
import com.mvp_base.entity.response.EmployeeResponseEntity;

import javax.inject.Inject;

public class EmployeeResponseEntityToDataModelMapper {


    @Inject
    EmployeeResponseEntityToDataModelMapper() {
    }

    public EmployeeResponseDataModel mapEmployeeResponseDataModel(EmployeeResponseEntity employeeResponseEntity) {
        EmployeeResponseDataModel employeeResponseDataModel = new EmployeeResponseDataModel();
        employeeResponseDataModel.setEmployeeName(employeeResponseEntity.getEmployeeName());
        employeeResponseDataModel.setEmployeeAge(employeeResponseEntity.getEmployeeAge());
        employeeResponseDataModel.setEmployeeSalary(employeeResponseEntity.getEmployeeSalary());
        return employeeResponseDataModel;
    }
}
