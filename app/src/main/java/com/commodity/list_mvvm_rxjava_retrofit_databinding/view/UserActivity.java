package com.commodity.list_mvvm_rxjava_retrofit_databinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.R;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.databinding.ActivityUserBinding;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel.UserViewModel;

import java.util.Observable;
import java.util.Observer;

public class UserActivity extends AppCompatActivity implements Observer {

    private ActivityUserBinding mainActivityBinding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_user);

        initDataBinding();
        setSupportActionBar(mainActivityBinding.toolbar);
        setListUserView(mainActivityBinding.listUser);
        setupObserver(userViewModel);

    }

    private void setListUserView(RecyclerView listUser) {
        UserAdapter adapter = new UserAdapter();
        listUser.setAdapter(adapter);
        listUser.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDataBinding() {

        mainActivityBinding= DataBindingUtil.setContentView(this, R.layout.activity_user);
        userViewModel = new UserViewModel(this);
        mainActivityBinding.setMainViewModel(userViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userViewModel.reset();
    }
    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }
    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof UserViewModel) {
            UserAdapter peopleAdapter = (UserAdapter) mainActivityBinding.listUser.getAdapter();
            UserViewModel peopleViewModel = (UserViewModel) observable;
            peopleAdapter.setUserList(peopleViewModel.getUserList());
        }
    }



}
