package com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Emp
{
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<EmpData> data;

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setData(List<EmpData> data){
        this.data = data;
    }
    public List<EmpData> getData(){
        return this.data;
    }
}