package com.commodity.list_mvvm_rxjava_retrofit_databinding.view;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.commodity.list_mvvm_rxjava_retrofit_databinding.R;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.databinding.ItemUserBinding;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.User;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.viewmodel.ItemUserViewModel;

import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {
    private List<User> userList;

    public UserAdapter() {
        this.userList = Collections.emptyList();
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user,parent,false);
        return new UserAdapterViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        holder.bindUser(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public class UserAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemUserBinding itemUserBinding;
        public UserAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public UserAdapterViewHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.itemUser);
            this.itemUserBinding = itemUserBinding;
        }

        public void bindUser(User user) {
            if(itemUserBinding.getUserViewModel() ==null)
            {
                itemUserBinding.setUserViewModel(new ItemUserViewModel(user,itemView.getContext()));
            }
        }
    }
}
