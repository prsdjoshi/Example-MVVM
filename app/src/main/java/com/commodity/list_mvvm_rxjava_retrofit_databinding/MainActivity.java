package com.commodity.list_mvvm_rxjava_retrofit_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.databinding.ActivityMainBinding;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.view.UserAdapter;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel.UserViewModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding mainActivityBinding;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

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

        mainActivityBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
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
