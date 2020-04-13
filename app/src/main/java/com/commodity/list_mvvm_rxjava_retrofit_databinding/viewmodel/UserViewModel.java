package com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.MyApplication;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.data.UserResponse;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.data.UserService;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.data.UsersFactory;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class UserViewModel extends Observable {


    private Context context;
    private List<User> userList;
    public ObservableInt userRecycler;
    public ObservableInt userProgressbar;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public UserViewModel(Context context) {
        this.context=context;
        this.userList=new ArrayList<>();
        userRecycler = new ObservableInt(View.GONE);
        userProgressbar = new ObservableInt(View.GONE);

    }

    public void onClickFabLoad()
    {
        initview();
        fetchUsersList();
    }

    private void initview() {
        userRecycler.set(View.GONE);
        userProgressbar.set(View.VISIBLE);
    }
    private void fetchUsersList() {

        MyApplication myApplication =MyApplication.create(context);
        UserService userService =myApplication.getUserService();

        Disposable disposable =userService.fetchUser(UsersFactory.RANDOM_USER_URL)
                .subscribeOn(myApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserResponse>() {
                    @Override
                    public void accept(UserResponse userResponse) throws Exception {
                        updateUserData(userResponse.getuserList());
                        userProgressbar.set(View.GONE);
                        userRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        userProgressbar.set(View.GONE);
                        userRecycler.set(View.GONE);
                        throwable.printStackTrace();

                    }
                });
        compositeDisposable.add(disposable);
    }

    private void updateUserData(List<User> getuserList) {
        userList.addAll(getuserList);
        setChanged();
        notifyObservers();

    }

    public List<User> getUserList()
    {
        return userList;
    }

    public void reset()
    {
        unSubscribeFromObservable();
        compositeDisposable=null;
        context=null;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }


}
