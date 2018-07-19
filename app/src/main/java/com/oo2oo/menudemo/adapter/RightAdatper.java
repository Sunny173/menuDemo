package com.oo2oo.menudemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oo2oo.menudemo.R;
import com.oo2oo.menudemo.bean.RightData;

import java.util.ArrayList;

/**
 * Created by sun on 2018/7/18.
 */

public class RightAdatper extends BaseViewAdapter<RightData> {

    public RightAdatper(Context context, ArrayList<RightData> mData) {
        super(context, mData);
    }


    @Override
    public String getTag(int position) {
        return mData.get(position).food_type;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_view, null, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).setData(mData.get(position));
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);

        }

        public void setData(RightData data) {
            tv_name.setText(data.food_name);
        }
    }
}