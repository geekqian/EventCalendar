package com.ingdan.base.common.widget.popup;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class QuickPopBuilder {
    private PopPrams P;
    private QuickPop mPopupWindow;

    public static QuickPopBuilder create(Activity activity) {
        return new QuickPopBuilder(activity);
    }

    private QuickPopBuilder(Context context) {
        mPopupWindow = new QuickPop(context);
        P = new PopPrams();
    }

    public QuickPop create() {
        mPopupWindow.apply(P);
        return mPopupWindow;
    }

    /**
     * @param width 宽
     */
    public QuickPopBuilder setWidth(int width) {
        P.mWidth = width;
        return this;
    }

    /**
     * @param height 高
     */
    public QuickPopBuilder setHeight(int height) {
        P.mHeight = height;
        return this;
    }

    /**
     * 设置背景灰色程度
     *
     * @param level 0.0f-1.0f
     */
    public QuickPopBuilder setBackGroundLevel(float level) {
        P.mLevel = level;
        return this;
    }

    /**
     * 设置动画
     */
    public QuickPopBuilder animationStyle(int animationStyle) {
        P.animationStyle = animationStyle;
        return this;
    }

    /**
     * 设置Outside是否可点击
     *
     * @param touchable 是否可点击
     */
    public QuickPopBuilder setOutsideTouchable(boolean touchable) {
        P.touchable = touchable;
        return this;
    }

    public QuickPopBuilder setContentView(int layoutResId) {
        P.layoutResId = layoutResId;
        return this;
    }

    public QuickPopBuilder setContentView(View view) {
        P.mView = view;
        return this;
    }

    public QuickPopBuilder fullWidth() {
        P.isFullWidth = true;
        return this;
    }

    public QuickPopBuilder setText(int viewId, CharSequence text) {
        P.setText(viewId, text);
        return this;
    }

    public QuickPopBuilder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        P.setOnClickListener(viewId, onClickListener);
        return this;
    }

    /**
     * 设置背景是否模糊：默认是模糊的
     *
     * @param isDimEnabled
     * @return
     */
    public QuickPopBuilder setIsDimEnabled(boolean isDimEnabled) {
        P.isDimEnabled = isDimEnabled;
        return this;
    }

    public static class PopPrams {
        public int layoutResId;//布局id
        public View mView;
        public int mWidth, mHeight;//弹窗的宽和高
        public float mLevel = 0.7f;//屏幕背景灰色程度
        public int animationStyle;//动画Id
        public boolean touchable = true;
        // 存放文本的集合
        public SparseArray<CharSequence> mTextArray = new SparseArray<>();
        // 存放点击事件的集合
        public SparseArray<View.OnClickListener> mClickArray = new SparseArray<>();
        public boolean isFullWidth;
        public boolean isDimEnabled=true;

        public void setText(int viewId, CharSequence text) {
            mTextArray.put(viewId, text);
        }

        public void setOnClickListener(int viewId, View.OnClickListener onClickListener) {
            mClickArray.put(viewId, onClickListener);
        }
    }
}
