package com.mvp_base;

import android.content.SharedPreferences;

import com.mvp_base.base.BasePresenter;
import com.mvp_base.errors.ErrorHandler;
import com.mvp_base.mapper.dataModelToViewModel.EmployeeResponseDataModelToViewModelMapper;
import com.mvp_base.useCase.DemoRequestUseCase;

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

}
