package com.oo2oo.menudemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oo2oo.menudemo.adapter.BaseViewAdapter;
import com.oo2oo.menudemo.adapter.LeftAdatper;
import com.oo2oo.menudemo.adapter.RightAdatper;
import com.oo2oo.menudemo.adapter.RightScrollListener;
import com.oo2oo.menudemo.bean.LeftData;
import com.oo2oo.menudemo.bean.RightData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView left_view = findViewById(R.id.left_view);
        RecyclerView right_view = findViewById(R.id.right_view);
        right_view.setLayoutManager(new LinearLayoutManager(this));
        left_view.setLayoutManager(new LinearLayoutManager(this));

        BaseViewAdapter leftAdatper = new LeftAdatper(this, getLeftData(), right_view);
        left_view.setAdapter(leftAdatper);
//        ------设置右侧------------
        BaseViewAdapter rightAdapter = new RightAdatper(this, getRightData());
        right_view.addItemDecoration(new MeiTuanItem(this, rightAdapter));
        right_view.setAdapter(rightAdapter);
        right_view.addOnScrollListener(new RightScrollListener(left_view));

//-------------


    }

    @NonNull
    private ArrayList<RightData> getRightData() {
        ArrayList<RightData> rightlist = new ArrayList<>();
        rightlist.add(new RightData("油条", "菜品1"));
        rightlist.add(new RightData("咸菜", "菜品1"));
        for (int i = 0; i < 15; i++) {
            RightData temp = new RightData("油条", "菜品1");
            temp.food_name = temp.food_name + i;
            rightlist.add(temp);
        }
        rightlist.add(new RightData("豆浆", "菜品1"));
        rightlist.add(new RightData("豆腐脑", "菜品2"));

        for (int i = 0; i < 13; i++) {
            RightData temp = new RightData("豆腐脑", "菜品2");
            temp.food_name = temp.food_name + i;
            rightlist.add(temp);
        }
        rightlist.add(new RightData("小豆子", "菜品3"));

        for (int i = 0; i < 10; i++) {
            RightData temp = new RightData("牛肉面", "菜品3");
            temp.food_name = temp.food_name + i;
            rightlist.add(temp);
        }
        rightlist.add(new RightData("鸡蛋面", "菜品3"));
        return rightlist;
    }

    @NonNull
    private ArrayList<LeftData> getLeftData() {
        ArrayList<LeftData> leftlist = new ArrayList<>();
        leftlist.add(new LeftData("菜品1"));
        leftlist.add(new LeftData("菜品2"));
        leftlist.add(new LeftData("菜品2"));
        leftlist.add(new LeftData("菜品2"));
        leftlist.add(new LeftData("菜品2"));
        leftlist.add(new LeftData("菜品3"));
        leftlist.add(new LeftData("菜品3"));
        leftlist.add(new LeftData("菜品3"));
        leftlist.add(new LeftData("菜品3"));
        leftlist.add(new LeftData("菜品3"));
        leftlist.add(new LeftData("菜品3"));
        return leftlist;
    }


}
