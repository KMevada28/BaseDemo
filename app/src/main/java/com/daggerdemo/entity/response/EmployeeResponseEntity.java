package com.daggerdemo.entity.response;

import com.squareup.moshi.Json;

public class EmployeeResponseEntity {

    @Json(name = "id")
    private String id;
    @Json(name = "employee_name")
    private String employeeName;
    @Json(name = "employee_salary")
    private String employeeSalary;
    @Json(name = "employee_age")
    private String employeeAge;
    @Json(name = "profile_image")
    private String profileImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}