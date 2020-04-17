package com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.MyApplication;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.data.UserService;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel.EmpData;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.repository.EmpRepository;

import java.util.List;

public class EmpViewModel extends AndroidViewModel {

    EmpRepository empRepository;
    public EmpViewModel(@NonNull Application application) {
        super(application);
        Log.d("EmpViewModel: ","default constructor call and create repository");
        empRepository = new EmpRepository(application);

    }

    @SuppressLint("LongLogTag")
    public LiveData<List<EmpData>> getAllEmp()
    {
        Log.d("EmpViewModel getAllEmp(): ","getEmpMutableLivedata() from EmpRepository and return");
        MyApplication myApplication =MyApplication.create(getApplication());
        UserService userService =myApplication.getUserService();
        return empRepository.getEmpMutableLivedata(userService);
    }
}
