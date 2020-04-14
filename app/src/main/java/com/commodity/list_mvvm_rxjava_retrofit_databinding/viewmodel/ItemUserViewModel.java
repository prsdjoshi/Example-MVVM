package com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.User;

public class ItemUserViewModel extends BaseObservable {

    User user;
    Context context;
    public ItemUserViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public void onItemClick(View view)
    {

    }

    public String getFullName()
    {
        user.fullName=user.name.title + "." + user.name.firts + " " + user.name.last;
        return user.fullName;
    }
    public String getCell()
    {
        return user.cell;
    }
    public String getMail()
    {
        return user.mail;
    }

    public String getPictureProfile()
    {
        return user.picture.large;
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageview , String url)
    {
        Glide.with(imageview.getContext()).load(url).into(imageview);
    }
}
