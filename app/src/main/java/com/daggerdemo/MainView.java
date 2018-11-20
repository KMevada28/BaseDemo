package com.daggerdemo;

import com.daggerdemo.base.BaseView;
import com.daggerdemo.entity.response.EmployeeResponseEntity;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */

public interface MainView extends BaseView {

    void displaySpeechRecognizer();

    void handleAPIError(String errorMessage);

    void showEmpData(EmployeeResponseEntity employeeResponseEntity);

}
