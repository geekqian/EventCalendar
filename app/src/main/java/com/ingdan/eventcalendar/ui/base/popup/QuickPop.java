package com.ingdan.eventcalendar.ui.base.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;


/**
 * 通用的PopupWidow
 */

public class QuickPop extends PopupWindow {
    private final Context mContext;
    private ViewHelper mViewHelper = null;

    public QuickPop(Context context) {
        super(context);
        this.mContext = context;
    }

    public void apply(QuickPopBuilder.PopPrams P) {
        // 1.设置布局
        mViewHelper = null;
        if (P.layoutResId != 0) {
            mViewHelper = new ViewHelper(mContext, P.layoutResId);
        }
        if (P.mView != null) {
            mViewHelper = new ViewHelper(P.mView);
        }
        if (mViewHelper == null) {
            throw new IllegalArgumentException("请调用setContentView方法设置布局");
        }
        // 设置背景
        View contentView = mViewHelper.getContentView();
        measureWidthAndHeight(contentView);
        setContentView(contentView);
        // 设置宽高
        if (P.mWidth > 0) {
            setWidth(P.mWidth);
        } else {
            setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        if (P.mHeight > 0) {
            setHeight(P.mHeight);
        } else {
            setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        if (P.isFullWidth) {
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        }

        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(P.touchable);
        setFocusable(P.touchable);
        // 动画
        if (P.animationStyle != 0) {
            setAnimationStyle(P.animationStyle);
        }

        // 2.设置文本
        int textSize = P.mTextArray.size();
        for (int i = 0; i < textSize; i++) {
            mViewHelper.setText(P.mTextArray.keyAt(i), P.mTextArray.valueAt(i));
        }
        // 3.设置点击
        int clickSize = P.mClickArray.size();
        for (int i = 0; i < clickSize; i++) {
            mViewHelper.setOnClickListener(P.mClickArray.keyAt(i), P.mClickArray.valueAt(i));
        }
        if (P.isDimEnabled) {
            if (P.mLevel > 0 && P.mLevel <= 1) {
                setBackGroundLevel(P.mLevel);
            }
        }
    }

    /**
     * 测量View的宽高
     *
     * @param view View
     */
    private void measureWidthAndHeight(View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getMeasureWidth() {
        return mViewHelper.getContentView().getMeasuredWidth();
    }

    public int getMeasureHeight() {
        return mViewHelper.getContentView().getMeasuredHeight();
    }

    /**
     * 设置背景灰色程度
     *
     * @param level 0.0f-1.0f
     */
    private void setBackGroundLevel(float level) {
        if (mContext instanceof Activity) {
            Window mWindow = ((Activity) mContext).getWindow();
            WindowManager.LayoutParams params = mWindow.getAttributes();
            params.alpha = level;
            mWindow.setAttributes(params);
        }
    }

    @Override
    public void dismiss() {
        setBackGroundLevel(1.0f);
        super.dismiss();
    }

    /**
     * 自动关闭
     *
     * @param time
     */
    public void autoDismiss(long time) {
        mViewHelper.getContentView().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, time);
    }

    public void setText(int viewId, CharSequence text) {
        mViewHelper.setText(viewId, text);
    }

    public void setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        mViewHelper.setOnClickListener(viewId, onClickListener);
    }

    public <T extends View> T getView(int viewId) {
        return mViewHelper.getView(viewId);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mViewHelper.getContentView().setOnClickListener(onClickListener);
    }
}
