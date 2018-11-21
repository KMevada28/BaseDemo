package com.mvp_base;

import android.content.SharedPreferences;

import com.mvp_base.base.BasePresenter;
import com.mvp_base.dataModel.EmployeeResponseDataModel;
import com.mvp_base.errors.ErrorHandler;
import com.mvp_base.mapper.dataModelToViewModel.EmployeeResponseDataModelToViewModelMapper;
import com.mvp_base.useCase.DemoRequestUseCase;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */

public class MainPresenter extends BasePresenter<MainView> {

    SharedPreferences sharedPreferences;
    DemoRequestUseCase demoRequestUseCase;
    ErrorHandler errorHandler;
    EmployeeResponseDataModelToViewModelMapper dataModelToViewModelMapper;

    @Inject
    public MainPresenter(SharedPreferences sharedPreferences, DemoRequestUseCase demoRequestUseCase, ErrorHandler errorHandler, EmployeeResponseDataModelToViewModelMapper dataModelToViewModelMapper) {
        this.sharedPreferences = sharedPreferences;
        this.demoRequestUseCase = demoRequestUseCase;
        this.errorHandler = errorHandler;
        this.dataModelToViewModelMapper = dataModelToViewModelMapper;
    }

    boolean calculateData(String userName) {
        if (userName.length() > 0 && view != null) {
            view.displaySpeechRecognizer();
            return true;
        } else {
            return false;
        }
    }

    void getEmployee(String empId) {

        if (view == null) {
            return;
        }

        demoRequestUseCase.execute(empId)
                .compose(bindToLifecycle())
                .subscribe(employeeResponseDataModel -> view.showEmpData(this.dataModelToViewModelMapper.mapEmployeeResponseViewModel(employeeResponseDataModel)), throwable -> {
                    if (view != null) {
                        view.handleAPIError(errorHandler.getErrorMessage(throwable).getMessage());
                    }
                });
      }

      boolean saveEmpDataToTable(String empId, String empName, String empOrg, String empSalary, String empAge){
          EmployeeResponseDataModel employeeResponseDataModel = new EmployeeResponseDataModel();
          employeeResponseDataModel.setId(empId);
          employeeResponseDataModel.setEmployeeName(empName);
          employeeResponseDataModel.setOrganization(empOrg);
          employeeResponseDataModel.setEmployeeSalary(empSalary);
          employeeResponseDataModel.setEmployeeAge(empAge);
          return employeeResponseDataModel.save();
      }

    List<EmployeeResponseDataModel> fetchDataFromTable(String empId){
        List<EmployeeResponseDataModel> employeeResponseDataModels = new ArrayList<>();
          if(empId.length()>0){
              /*employeeResponseDataModels = SQLite.select().
                      from(EmployeeResponseDataModel.class).
                      where(EmployeeResponseDataModel.id.is(empId)).
                      queryList();*/
          }else{
              employeeResponseDataModels = SQLite.select().
                      from(EmployeeResponseDataModel.class).queryList();
          }
          return employeeResponseDataModels;
      }

}
