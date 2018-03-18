package com.ingdan.eventcalendar.ui.base.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.ingdan.eventcalendar.R;

/**
 * Dialog的控制类
 */

public class QuickDialogBuilder {
    private QuickDialog mDialog;
    private AlertParams P;

    private QuickDialogBuilder(Context context, int themeResId) {
        this.mDialog = new QuickDialog(context, themeResId);
        P = new AlertParams(context);
    }

    private QuickDialogBuilder(Context context) {
        this(context, R.style.Theme_Dialog);
    }

    public static QuickDialogBuilder create(Context context, int themeResId) {
        return new QuickDialogBuilder(context, themeResId);
    }

    public static QuickDialogBuilder create(Context context) {
        return new QuickDialogBuilder(context);
    }

    public QuickDialogBuilder setText(int viewId, CharSequence text) {
        P.setText(viewId, text);
        return this;
    }

    public QuickDialogBuilder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        P.setOnClickListener(viewId, onClickListener);
        return this;
    }

    /**
     * 设置显示的View
     */
    public QuickDialogBuilder setContentView(int layoutResId) {
        P.mView = null;
        P.mViewLayoutResId = layoutResId;
        return this;
    }

    /**
     * 设置显示的布局
     */
    public QuickDialogBuilder setContentView(View view) {
        P.mView = view;
        P.mViewLayoutResId = 0;
        return this;
    }

    /**
     * 设置ContentView背景的颜色：默认白色
     */
    public QuickDialogBuilder setContentViewBgColor(int resId) {
        P.mBgColor = resId;
        return this;
    }

    /**
     * 设置ContentView背景的圆角：默认10dp
     *
     * @param radus 内部已转成dp
     * @return
     */
    public QuickDialogBuilder setContentViewBgRadius(int radus) {
        P.mBgRadius = radus;
        return this;
    }

    /**
     * 设置背景是否模糊：默认是模糊的
     *
     * @param isDimEnabled
     * @return
     */
    public QuickDialogBuilder setIsDimEnabled(boolean isDimEnabled) {
        P.isDimEnabled = isDimEnabled;
        return this;
    }

    /**
     * 设置宽度占满的比例
     */
    public QuickDialogBuilder setWidthScale(float scale) {
        P.mScale = scale;
        return this;
    }

    public QuickDialogBuilder fullWidth() {
        P.mScale = 1.0f;
        return this;
    }

    public QuickDialogBuilder fromBottom(boolean isAnim) {
        if (isAnim) {
            P.mAnimation = R.style.Anim_Dialog_Bottom;
        }
        P.mGravity = Gravity.BOTTOM;
        return this;
    }

    public QuickDialogBuilder setAnimation(int resId) {
        P.mAnimation = resId;
        return this;
    }


    public QuickDialogBuilder setWidth(int width) {
        P.mWidth = width;
        return this;
    }

    public QuickDialogBuilder setHeight(int height) {
        P.mHeight = height;
        return this;
    }

    /**
     * 设置点击空白是否消失
     */
    public QuickDialogBuilder setCancelable(boolean cancelable) {
        P.mCancelable = cancelable;
        return this;
    }

    /**
     * 设置取消的监听
     */
    public QuickDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        P.mOnCancelListener = onCancelListener;
        return this;
    }

    /**
     * 设置Dialog消息的监听
     */
    public QuickDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        P.mOnDismissListener = onDismissListener;
        return this;
    }

    /**
     * 设置按键的监听
     */
    public QuickDialogBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        P.mOnKeyListener = onKeyListener;
        return this;
    }

    public QuickDialog create() {
        mDialog.apply(P);
        return mDialog;
    }

    public QuickDialog show() {
        QuickDialog dialog = create();
        dialog.show();
        return dialog;
    }

    /**
     * 存放Dialog的变量、参数等
     */
    public static class AlertParams {
        public boolean mCancelable = true;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public View mView;
        public int mViewLayoutResId;

        // 存放文本的集合
        public SparseArray<CharSequence> mTextArray = new SparseArray<>();
        // 存放点击事件的集合
        public SparseArray<View.OnClickListener> mClickArray = new SparseArray<>();
        // 宽高
        public int mWidth;
        public int mHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        public int mGravity = Gravity.CENTER;
        public int mAnimation;
        public float mScale = 0.85f;
        public int mBgRadius = 5;
        public int mBgColor = Color.parseColor("#ffffffff");
        public boolean isDimEnabled = true;// 是否模糊

        public AlertParams(Context context) {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            mWidth =dm.widthPixels;
        }

        public void setText(int viewId, CharSequence text) {
            mTextArray.put(viewId, text);
        }

        public void setOnClickListener(int viewId, View.OnClickListener onClickListener) {
            mClickArray.put(viewId, onClickListener);
        }
    }


}
