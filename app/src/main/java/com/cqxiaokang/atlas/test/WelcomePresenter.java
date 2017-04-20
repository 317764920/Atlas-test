package com.cqxiaokang.atlas.test;

import android.content.Context;
import android.os.Handler;

/**
 * 欢迎业务实现
 *
 * @liuchunxu
 * @2016年08月26日 10:23
 */
public class WelcomePresenter extends BasePresenter<WelcomeView> implements IWelcomePresenter {
    private Context mContext;

    public WelcomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 判断是否是第一次进入APP
     *
     * @liuchunxu 开发日期：2016/8/26 10:32
     */
    public void getIsFirstEnter() {
        mView.isFirstEnter();
    }

    @Override
    public void getHotFix() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.getHotFixSuccess();
            }
        }, 3000);
    }

    @Override
    public void downFixApk(String apkUrl) {
//        DownloadUtils.download(apkUrl, new FileDownCallBack(Constants.CACHE_FIX_DIR_APK, Constants.CACHE_FIX_FILE_APK) {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//                mView.downFixApkFail();
//            }
//
//            @Override
//            public void onResponse(File response, int id) {
//                mView.downFixApkSuccess(response);
//            }
//
//            @Override
//            public void inProgress(float progress, long total, int id) {
//                mView.downFixApkProgress(progress);
//            }
//        });
    }
}
