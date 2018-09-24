package com.daggerdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daggerdemo.DI.SharedPrefDI;
import com.daggerdemo.base.BaseActivity;

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
        SharedPrefDI.getShredPreferenceComponent(this).inject(this);
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
        if (sharedPreferences != null && sharedPreferences.contains(Constant.userNameKey)) {
            mainPresenter.calculateData("" + sharedPreferences.getString(Constant.userNameKey, Constant.emptyString));
        }
    }

}
