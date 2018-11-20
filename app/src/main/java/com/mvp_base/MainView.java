package com.mvp_base;

import com.mvp_base.base.BaseView;
import com.mvp_base.entity.response.EmployeeResponseEntity;

/**
 * Created by kundankumar.mevada on 9/20/2018.
 */

public interface MainView extends BaseView {

    void displaySpeechRecognizer();

    void handleAPIError(String errorMessage);

    void showEmpData(EmployeeResponseEntity employeeResponseEntity);

}
