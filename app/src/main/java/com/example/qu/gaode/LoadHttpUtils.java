package com.example.qu.gaode;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


/**
 * 描述:封装HttpUtils工具类
 */
public class LoadHttpUtils {
    private boolean IsDispToast = true;
    private boolean IsDispProgressBar = true;
    private String ToastErrer = "";
    //    private int ReturnType=0;
    private Class<?> typeClass;
    private Loading loadstr;
    private GetListener mListener;
    private Context activity;

    ///设置提示文本是否显示
    public void SetIsDispToast(boolean isboolean) {
        IsDispToast = isboolean;
    }

    ///设置加载动画是否显示
    public void SetIsDispProgressBar(boolean isboolean) {
        IsDispProgressBar = isboolean;
    }

    ///设置提示异常文本
    public void SetToastErrer(String strContext) {
        ToastErrer = strContext;
    }

    ///设置回调接口索引
//    public void SetReturnType(int strContext)
//    {
//        ReturnType=strContext;
//    }
    ///构造函数
    public LoadHttpUtils(Context context) {
        activity = context;
        loadstr = new Loading(context);
        mListener = (GetListener) context;
    }

    ///构造函数
    public LoadHttpUtils(Context context, Fragment fragment) {
        activity = context;
        loadstr = new Loading(context);
        mListener = (GetListener) fragment;
    }

    ///构造函数
    public LoadHttpUtils(Context context, FrameLayout fragment) {
        activity = context;
        loadstr = new Loading(context);
        mListener = (GetListener) fragment;
    }

    ///回调接口
    public interface GetListener {
        void getData(String str, int retrunType);
    }

    ///调接口函数
    public void Post(String url, RequestParams params, final int returnType) {
        HttpUtils http = new HttpUtils();
        http.configSoTimeout(15000);
        http.send(HttpRequest.HttpMethod.POST,
                url,
                params,
                new RequestCallBack<String>() {

                    @Override
                    public void onStart() {
                        if (IsDispProgressBar) {
                            loadstr.p();
                        }
                    }

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        loadstr.v();
                        try {
                            if (mListener != null) {
                                mListener.getData(responseInfo.result, returnType);
                            } else {
//                                ToastUtil.toast(activity, "");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            if (!ToastErrer.equals("")) {
//                                ToastUtil.toast(activity, ToastErrer);
                            }
                        } finally {
                            if (IsDispProgressBar) {
                                loadstr.v();
                            }
                        }
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        try {
                            loadstr.v();
                            if ("org.apache.http.conn.HttpHostConnectException: Connection to http://114.215.159.154 refused".equals(msg)) {
//                                ToastUtil.toast(activity, "网络异常");
                            } else if ("java.net.SocketTimeoutException".equals(msg)) {
//                                ToastUtil.toast(activity, "网络连接超时");
                            }
                            if (IsDispToast) {
                                if ("org.apache.http.conn.HttpHostConnectException: Connection to http://114.215.159.154 refused".equals(msg)) {
//                                    ToastUtil.toast(activity, "网络异常");
                                } else if ("java.net.SocketTimeoutException".equals(msg)) {
//                                    ToastUtil.toast(activity, "网络连接超时");
                                } else {
//                                    ToastUtil.toast(activity, msg);
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            if (IsDispProgressBar) {
                                loadstr.v();
                            }
                        }
                    }
                });
    }
}
