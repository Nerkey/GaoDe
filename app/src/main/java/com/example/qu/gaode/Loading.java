package com.example.qu.gaode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2015/7/6.
 */
public class Loading {
    private ProgressDialog mDialog;
    private Context mContext;
    public int mSemaphore;

    public Loading(Context context) {
        mContext = context;
    }

    /**
     * 显示加载条
     */
    public void p() {
        mSemaphore++;
        if (null == mDialog) {
            initDialog();
        }
        try {
            mDialog.setMessage("正在处理...");
            mDialog.show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 隐藏加载条
     */
    public void v() {
        mSemaphore--;
        if (0 == mSemaphore && null != mDialog) {
            mDialog.cancel();
        }

        if (0 > mSemaphore) {
            mSemaphore = 0;
        }
    }

    /**
     * 初始化加载条
     */
    private void initDialog() {
        // TODO custom dialog
        mDialog = new ProgressDialog(mContext);
        mDialog.setCancelable(false);
        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // TODO Auto-generated method stub
                if (null != mCancelListener) {
                    mCancelListener.onCancel();
                }
            }
        });
        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {
                // TODO Auto-generated method stub
                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        try {
                            Activity activity = (Activity) mContext;
                            if (activity instanceof BaseActivity) {
                                BaseActivity base = (BaseActivity) activity;
                                base.onKeyDown(keyCode, event);
                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 这个方法运行不是很靠谱
     */
    private OnLoadingCancelListener mCancelListener;

    @Deprecated
    public void setOnCancelListener(OnLoadingCancelListener listener) {
        mCancelListener = listener;
    }

    @Deprecated
    public interface OnLoadingCancelListener {
        void onCancel();
    }
}
