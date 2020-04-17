package com.commodity.list_mvvm_rxjava_retrofit_databinding.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.R;
import com.commodity.list_mvvm_rxjava_retrofit_databinding.model.empmodel.EmpData;

import java.util.List;

public class EmpAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<EmpData> empDataList;
    public EmpAdapter(List<EmpData> empData) {
        this.empDataList = empData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emp,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
            holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (empDataList != null && empDataList.size() > 0) {
            return empDataList.size();
        } else {
            return 0;
        }
    }
    public class ViewHolder extends BaseViewHolder {

        ImageView ivThumbnail;
        TextView tvName,tvSalary,tvAge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.label_name);
            tvSalary = itemView.findViewById(R.id.label_salary);
            tvAge = itemView.findViewById(R.id.label_age);
            ivThumbnail = itemView.findViewById(R.id.image_emp);
        }

        @Override
        protected void clear() {
            ivThumbnail.setImageDrawable(null);
            tvName.setText("");
            tvAge.setText("");
            tvSalary.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            EmpData empData = empDataList.get(position);
            if (empData.getProfile_image() != null) {
                Glide.with(itemView.getContext())
                        .load(empData.getProfile_image())
                        .into(ivThumbnail);
            }
            if (empData.getEmployee_name() != null) {
                tvName.setText(empData.getEmployee_name());
            }
            if (empData.getEmployee_salary() != null) {
                tvSalary.setText("Salary: "+empData.getEmployee_salary());
            }
            if (empData.getEmployee_age() != null) {
                tvAge.setText("Age: "+empData.getEmployee_age());
            }

        }
    }
}
abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    protected abstract void clear();
    public void onBind(int position)
    {
        mCurrentPosition = position;
        clear();
    }
    public int getCurrentPosition() {
        return mCurrentPosition;
    }
}
