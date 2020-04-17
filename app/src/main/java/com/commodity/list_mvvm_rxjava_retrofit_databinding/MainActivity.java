package com.commodity.list_mvvm_rxjava_retrofit_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.databinding.ActivityMainBinding;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainActivityBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }
    private void initDataBinding() {

        mainActivityBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        mainActivityBinding.setMainViewModel(mainViewModel);
    }
}
