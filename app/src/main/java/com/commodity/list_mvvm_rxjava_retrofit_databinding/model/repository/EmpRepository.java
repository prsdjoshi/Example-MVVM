package com.commodity.list_mvvm_rxjava_retrofit_databinding.model.repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.MyApplication;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.data.UserService;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel.Emp;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel.EmpData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmpRepository {
    private ArrayList<EmpData> empData = new ArrayList<>();
    private MutableLiveData<List<EmpData>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public EmpRepository(Application application) {
        this.application = application;
        Log.d("EmpRepository: ","default constructor call");
    }

    @SuppressLint("LongLogTag")
    public MutableLiveData<List<EmpData>> getEmpMutableLivedata(UserService userService)
    {
        Log.d("EmpRepository MutableLiveData: ","getEmpMutableLivedata call");
        Call<Emp> call = userService.getEmp("http://dummy.restapiexample.com/api/v1/employees");
        call.enqueue(new Callback<Emp>() {
            @Override
            public void onResponse(Call<Emp> call, Response<Emp> response) {
                Emp emp=response.body();
                if(emp!=null&&emp.getData()!=null)
                {
                    Log.d("EmpRepository MutableLiveData: ","getEmpdata and set value to notify observer in view");
                    empData = (ArrayList<EmpData>) emp.getData();
                    mutableLiveData.setValue(empData);
                }
            }

            @Override
            public void onFailure(Call<Emp> call, Throwable t) {
                Log.d("EmpRepository MutableLiveData: ","onFailure() call");

            }
        });
        return mutableLiveData;
    }
}
