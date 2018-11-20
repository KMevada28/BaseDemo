package com.mvp_base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp_base.DI.MainActivityDI;
import com.mvp_base.base.BaseActivity;
import com.mvp_base.viewModel.EmployeeResponseViewModel;

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
        if (inUsername.getText().toString().length() > 0 && inNumber.getText().toString().length() > 0) {
            sharedPreferences.edit().putString(Constant.userNameKey, inUsername.getText().toString())
                    .putString(Constant.userNumberKey, inNumber.getText().toString()).apply();
            inNumber.setText(Constant.emptyString);
            inUsername.setText(Constant.emptyString);
            Toast.makeText(this, R.string.you_have_success, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.please_fill_both_fields, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnGet)
    public void getData() {
        /*if (sharedPreferences != null && sharedPreferences.contains(Constant.userNameKey)) {
            mainPresenter.calculateData("" + sharedPreferences.getString(Constant.userNameKey, Constant.emptyString));
        }*/
        if(inNumber.getText().toString().length()>0){
            mainPresenter.getEmployee(inNumber.getText().toString());
        }else{
            Toast.makeText(this, R.string.please_enter_emp_id, Toast.LENGTH_SHORT).show();
        }

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
}
