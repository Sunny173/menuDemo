package com.oo2oo.menudemo.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


/**
 * Created by sun on 2018/7/18.
 */

public class RightScrollListener extends RecyclerView.OnScrollListener {

    BaseViewAdapter leftAdapter;
    RecyclerView leftView;

    public RightScrollListener(RecyclerView left_view) {
        leftView = left_view;
        leftAdapter = (BaseViewAdapter) leftView.getAdapter();
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int position = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
//        Log.e("position:", "position:" + position);
        int lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
//        Log.e("lastPosition:", "lastPosition:" + lastPosition);
        int rightCount = recyclerView.getAdapter().getItemCount();
        BaseViewAdapter rightAdapter = null;
        if (recyclerView.getAdapter() instanceof BaseViewAdapter) {
            rightAdapter = (BaseViewAdapter) recyclerView.getAdapter();
        } else {
            return;
        }


        if (dy > 0) {
            if (position + 1 < rightCount) {
                if (position == 0) {
                    leftAdapter.setSelectPosition(0);
                } else {
                    if (rightAdapter != null && rightAdapter.isTopNotEqualsNext(position)) {
                        int leftPosition = rightAdapter.boundPosition(position, leftView);
                        leftAdapter.setSelectPosition(leftPosition);
                        leftView.scrollToPosition(leftPosition);
                        Log.e("rightBoundLeftPosition:", "rightBoundLeftPosition:" + leftPosition);
                    }
                }
            }

        } else {
            if (position + 1 < rightCount) {
                if (position == 0) {
                    leftAdapter.setSelectPosition(0);
                } else {
                    if (rightAdapter != null && rightAdapter.isTopNotEqualsBefore(position)) {
                        int leftPosition = rightAdapter.boundPosition(position, leftView);
                        leftAdapter.setSelectPosition(leftPosition);
                        leftView.scrollToPosition(leftPosition);
                    }
                }
            }

        }


        /////////////////
    }
}