package com.commodity.list_mvvm_rxjava_retrofit_databinding;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.view.EmpActivity;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.view.UserActivity;

public class MainViewModel extends ViewModel {

    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }
    public void onClickEmpLoad()
    {
        context.startActivity(new Intent(context, EmpActivity.class));
    }
    public void onClickUserLoad()
    {
        context.startActivity(new Intent(context, UserActivity.class));
    }
}
