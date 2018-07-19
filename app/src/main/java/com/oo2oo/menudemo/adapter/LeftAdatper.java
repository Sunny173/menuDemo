package com.oo2oo.menudemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oo2oo.menudemo.R;
import com.oo2oo.menudemo.bean.LeftData;

import java.util.List;

/**
 * Created by sun on 2018/7/18.
 */

public class LeftAdatper extends BaseViewAdapter<LeftData> {
    RecyclerView right_view;

    public LeftAdatper(Context context, List mData, RecyclerView right_view) {
        super(context, mData);
        this.right_view = right_view;
    }


    @Override
    public String getTag(int position) {
        return mData.get(position).menu_name;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_view, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position == getSelectPosition()) {
            ((MyViewHolder) holder).bindSelectStatus(mData.get(position));
        } else {
            ((MyViewHolder) holder).bindDefaultStatus(mData.get(position));

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectPosition(position);
                ((LinearLayoutManager) right_view.getLayoutManager()).
                        scrollToPositionWithOffset(boundPosition(position, right_view), 0);
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_menu_type;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_menu_type = itemView.findViewById(R.id.tv_menu_type);

        }

        public void bindSelectStatus(LeftData leftData) {
            tv_menu_type.setText(leftData.menu_name);
            tv_menu_type.setBackgroundColor(Color.WHITE);
        }

        public void bindDefaultStatus(LeftData leftData) {
            tv_menu_type.setText(leftData.menu_name);
            tv_menu_type.setBackgroundColor(Color.TRANSPARENT);

        }
    }


}