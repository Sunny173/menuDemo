package com.oo2oo.menudemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.oo2oo.menudemo.adapter.BaseViewAdapter;

/**
 * Created by sun on 2018/7/17.
 */

public class MeiTuanItem extends RecyclerView.ItemDecoration {
    private int mTitleHeight;
    private BaseViewAdapter baseViewAdapter;
    private Paint mPaint;
    private Rect mBounds;
    private int backgroundColor;
    private int textColor;
    private int textSize;

    public MeiTuanItem(Context context, int mTitleHeight, BaseViewAdapter baseViewAdapter, int backgroundColor, int textColor, int textSize) {
        this.mTitleHeight = dip2px(context, mTitleHeight);
        this.baseViewAdapter = baseViewAdapter;
        mPaint = new Paint();
        mBounds = new Rect();
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.textSize = sp2px(context, textSize);

    }

    public MeiTuanItem(Context context, BaseViewAdapter baseViewAdapter) {
        this(context, dip2px(context, 10), baseViewAdapter, Color.LTGRAY, Color.DKGRAY, sp2px(context, 9));
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            int position = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
            View itemView = parent.findViewHolderForAdapterPosition(position).itemView;
            if (position + 1 < baseViewAdapter.getItemCount()) {
                if (!baseViewAdapter.isTopNotEqualsNext(position)) {
                    if (itemView.getTop() + itemView.getHeight() < mTitleHeight) {
                        c.save();
                        c.translate(0, itemView.getTop() + itemView.getHeight() - mTitleHeight);
                    }
                }
            }
            mPaint.setColor(backgroundColor);
            c.drawRect(parent.getPaddingLeft(), parent.getPaddingTop(), parent.getRight() - parent.getPaddingRight(), parent.getTop() + mTitleHeight, mPaint);

            mPaint.setTextSize(textSize);
            mPaint.setColor(textColor);
            String positionStr = baseViewAdapter.getTag(position);
            mPaint.getTextBounds(positionStr, 0, positionStr.length(), mBounds);
            c.drawText(positionStr, parent.getPaddingLeft(), parent.getPaddingTop() + mTitleHeight - (mTitleHeight / 2 - mBounds.height() / 2), mPaint);


        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int paddingLeft = parent.getPaddingLeft();
        int paddingRight = parent.getRight() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
            int position = lp.getViewLayoutPosition();
            if (position == 0) {
                setText(c, paddingLeft, paddingRight, child, lp, position);

            } else {
                if (!baseViewAdapter.isTopNotEqualsBefore(position)) {
                    setText(c, paddingLeft, paddingRight, child, lp, position);

                } else {

                }
            }
        }
    }

    private void setText(Canvas c, int paddingLeft, int paddingRight, View child, RecyclerView.LayoutParams lp, int position) {
        mPaint.setColor(backgroundColor);
        c.drawRect(paddingLeft, child.getTop() - lp.topMargin - mTitleHeight, paddingRight, child.getTop() - lp.topMargin, mPaint);
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
        String positionStr = baseViewAdapter.getTag(position);
        mPaint.getTextBounds(positionStr, 0, positionStr.length(), mBounds);
        c.drawText(positionStr, child.getPaddingLeft(), child.getTop() - lp.topMargin - (mTitleHeight / 2 - mBounds.height() / 2), mPaint);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (position == 0) {
            outRect.set(0, mTitleHeight, 0, 0);
        } else {
            if (!baseViewAdapter.isTopNotEqualsBefore(position)) {
                outRect.set(0, mTitleHeight, 0, 0);
            } else {
                outRect.set(0, 0, 0, 0);
            }
        }
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}