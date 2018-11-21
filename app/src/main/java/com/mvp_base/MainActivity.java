package com.mvp_base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp_base.DI.MainActivityDI;
import com.mvp_base.base.BaseActivity;
import com.mvp_base.dataModel.EmployeeResponseDataModel;
import com.mvp_base.utils.StringUtils;
import com.mvp_base.viewModel.EmployeeResponseViewModel;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements MainView {
    @Inject
    SharedPreferences sharedPreferences;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnGet)
    Button btnGet;
    @BindView(R.id.inUsername)
    EditText inUsername;
    @BindView(R.id.inNumber)
    EditText inNumber;
    @BindView(R.id.inOrganization)
    EditText inOrganization;
    @BindView(R.id.inAge)
    EditText inAge;
    @BindView(R.id.inSalary)
    EditText inSalary;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityDI.getMainActivityComponent(this).inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.unbind();
    }

    @Override
    public void displaySpeechRecognizer() {

        Toast.makeText(this, sharedPreferences.getString(Constant.userNumberKey, Constant.emptyString)
                + " " +
                sharedPreferences.getString(Constant.userNameKey, Constant.emptyString), Toast.LENGTH_LONG).show();

    }

    @OnClick(R.id.btnSave)
    public void saveData() {
        if (inUsername.getText().toString().length() > 0
                && inNumber.getText().toString().length() > 0
                && inOrganization.getText().toString().length() > 0
                && inAge.getText().toString().length() > 0
                && inAge.getText().toString().length() > 0
                ) {

            //Here saving data via SharedPreference
        /*    sharedPreferences.edit().putString(Constant.userNameKey, inUsername.getText().toString())
                    .putString(Constant.userNumberKey, inNumber.getText().toString()).apply();*/

            if(mainPresenter.saveEmpDataToTable(inNumber.getText().toString(),
                    inUsername.getText().toString(),
                    inOrganization.getText().toString(),
                    inSalary.getText().toString(),
                    inAge.getText().toString())){
                clearData();
                Toast.makeText(this, R.string.you_have_success, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, R.string.please_fill_both_fields, Toast.LENGTH_SHORT).show();
        }
    }

    void clearData(){
        inNumber.setText(Constant.emptyString);
        inUsername.setText(Constant.emptyString);
        inOrganization.setText(Constant.emptyString);
        inSalary.setText(Constant.emptyString);
        inAge.setText(Constant.emptyString);
    }

    @OnClick(R.id.btnGet)
    public void getData() {

        //Here fetching data from shared preference
        /*if (sharedPreferences != null && sharedPreferences.contains(Constant.userNameKey)) {
            mainPresenter.calculateData("" + sharedPreferences.getString(Constant.userNameKey, Constant.emptyString));
        }*/

        //Here API call done for employee data
        /*if(inNumber.getText().toString().length()>0){
            mainPresenter.getEmployee(inNumber.getText().toString());
        }else{
            Toast.makeText(this, R.string.please_enter_emp_id, Toast.LENGTH_SHORT).show();
        }*/

        //Here Fetching Data from Table
        setDataFromTable(inNumber.getText().toString());

    }

    @Override
    public void handleAPIError(String errorMessage) {
        Toast.makeText(this, errorMessage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showEmpData(EmployeeResponseViewModel employeeResponseViewModel) {
        Toast.makeText(this, "EMP NAME :-"+employeeResponseViewModel.getEmployeeName(),Toast.LENGTH_LONG).show();
        Toast.makeText(this, "EMP SALARY:-"+employeeResponseViewModel.getEmployeeSalary(),Toast.LENGTH_LONG).show();
    }

    void setDataFromTable(String empId){
        List<EmployeeResponseDataModel> employeeResponseDataModelList = mainPresenter.fetchDataFromTable(empId);
        if(employeeResponseDataModelList.size()>0){
            EmployeeResponseDataModel employeeResponseDataModel = employeeResponseDataModelList.get(0);
            inNumber.setText(employeeResponseDataModel.getId());
            inUsername.setText(employeeResponseDataModel.getEmployeeName());
            inOrganization.setText(employeeResponseDataModel.getOrganization());
            inSalary.setText(employeeResponseDataModel.getEmployeeSalary());
            inAge.setText(employeeResponseDataModel.getEmployeeAge());
        }
    }
    
}
