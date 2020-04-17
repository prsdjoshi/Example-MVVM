package com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel;

import com.google.gson.annotations.SerializedName;

public class EmpData
{
    @SerializedName("id")
    private String id;
    @SerializedName("employee_name")
    private String employee_name;
    @SerializedName("employee_salary")
    private String employee_salary;
    @SerializedName("employee_age")
    private String employee_age;
    @SerializedName("profile_image")
    private String profile_image;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setEmployee_name(String employee_name){
        this.employee_name = employee_name;
    }
    public String getEmployee_name(){
        return this.employee_name;
    }
    public void setEmployee_salary(String employee_salary){
        this.employee_salary = employee_salary;
    }
    public String getEmployee_salary(){
        return this.employee_salary;
    }
    public void setEmployee_age(String employee_age){
        this.employee_age = employee_age;
    }
    public String getEmployee_age(){
        return this.employee_age;
    }
    public void setProfile_image(String profile_image){
        this.profile_image = profile_image;
    }
    public String getProfile_image(){
        return this.profile_image;
    }
}