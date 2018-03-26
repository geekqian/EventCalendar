package com.ingdan.base.common.widget.dialog;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;

import com.ingdan.base.common.R;


/**
 * 进度的Dialog
 */

public class LoadingDialog {

    private final QuickDialog mDialog;

    public LoadingDialog(Activity activity) {
        mDialog = QuickDialogBuilder.create(activity)
                .setContentView(R.layout.dialog_loading)
                .setWidth(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();
    }

    public void show(String text) {
        if (!TextUtils.isEmpty(text)) {
            mDialog.setText(R.id.tv_loading, text);
        }
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public void show() {
        mDialog.show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }
}
