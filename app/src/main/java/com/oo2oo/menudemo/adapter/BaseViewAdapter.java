package com.oo2oo.menudemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

/**
 * Created by sun on 2018/7/17.
 */

public abstract class BaseViewAdapter<T> extends RecyclerView.Adapter {
    private int selectPosition = -1;

    public Context context;
    public List<T> mData;

    public BaseViewAdapter(Context context, List<T> mData) {
        this.context = context;
        this.mData = mData;
    }

//    @Override
//    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new BaseHolder(LayoutInflater.from(context).inflate(getLayoutId(), parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(BaseHolder holder, int position) {
//        bind(holder, position);
//    }


    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public abstract String getTag(int position);

    public boolean isTopNotEqualsBefore(int position) {
        try {
            return getTag(position).equals(getTag(position - 1));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isTopNotEqualsNext(int position) {
        try {
            return getTag(position).equals(getTag(position + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断点击的tag==右侧列表的tag
     *
     * @param position 当前的位置
     * @param adapter  代判断的列表
     * @return
     */
    public int boundPosition(int position, BaseViewAdapter adapter) {
        int rightCount = adapter.getItemCount();
        for (int i = 0; i < rightCount; i++) {
            String rightTag = adapter.getTag(i);
            if (rightTag.equals(getTag(position))) {
                return i;
            } else {
                continue;
            }

        }
        return 0;
    }

    public int boundPosition(int position, RecyclerView right_view) {
        if (right_view.getAdapter() instanceof BaseViewAdapter) {
            return boundPosition(position, (BaseViewAdapter) right_view.getAdapter());
        } else {
            return 0;
        }
    }

//    public static class BaseHolder extends RecyclerView.ViewHolder {
//        private SparseArray<View> mViews = new SparseArray<>();
//        private View mConvertView;
//
//        public BaseHolder(View itemView) {
//            super(itemView);
//            mConvertView = itemView;
//        }
//
//        public <T extends View> T findViews(int resId) {
//            View view = mViews.get(resId);
//            if (null == view) {
//                view = mConvertView.findViewById(resId);
//                mViews.put(resId, view);
//            }
//            return (T) view;
//        }
//    }
}