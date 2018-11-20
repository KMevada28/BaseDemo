/*
 * Copyright © 2018 Nedbank. All rights reserved.
 */

package com.mvp_base.mapper.dataModelToViewModel;


import com.mvp_base.dataModel.EmployeeResponseDataModel;
import com.mvp_base.viewModel.EmployeeResponseViewModel;

import javax.inject.Inject;

public class EmployeeResponseDataModelToViewModelMapper {

    @Inject
    EmployeeResponseDataModelToViewModelMapper() {
    }

    public EmployeeResponseViewModel mapEmployeeResponseViewModel(EmployeeResponseDataModel employeeResponseDataModel) {
        EmployeeResponseViewModel employeeResponseViewModel = new EmployeeResponseViewModel();
        employeeResponseViewModel.setEmployeeName(employeeResponseDataModel.getEmployeeName());
        employeeResponseViewModel.setEmployeeAge(employeeResponseDataModel.getEmployeeAge());
        employeeResponseViewModel.setEmployeeSalary(employeeResponseDataModel.getEmployeeSalary());
        return employeeResponseViewModel;
    }
}
