package com.commodity.list_mvvm_rxjava_retrofit_databinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.R;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel.EmpData;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel.EmpViewModel;

import java.util.List;

public class EmpActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefresh;
    RecyclerView mRecyclerView;
    public EmpViewModel empViewModel;
    public EmpAdapter empAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);
        initializationViews();
        empViewModel = ViewModelProviders.of(this).get(EmpViewModel.class);
        getEmpList();
        swipeRefresh.setOnRefreshListener(() -> {
            getEmpList();
        });
    }


    private void initializationViews() {
        Log.d("EmpActivity: ","initializationViews() call");
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }
    private void getEmpList() {
        Log.d("EmpActivity: ","initializationViews() call and observe active");
        swipeRefresh.setRefreshing(true);
        empViewModel.getAllEmp().observe(this, new Observer<List<EmpData>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onChanged(List<EmpData> empData) {
                Log.d("EmpActivity observe Livedata: ","onChanged() call");
                swipeRefresh.setRefreshing(false);
                prepareRecycleview(empData);
            }
        });
    }

    private void prepareRecycleview(List<EmpData> empData) {
        Log.d("prepareRecycleview: ","create Adapter");
        empAdapter = new EmpAdapter(empData);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        Log.d("prepareRecycleview: ","set Adapter");
        mRecyclerView.setAdapter(empAdapter);
        empAdapter.notifyDataSetChanged();

    }

}
