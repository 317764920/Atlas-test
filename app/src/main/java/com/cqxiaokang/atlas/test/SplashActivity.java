package com.cqxiaokang.atlas.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

/**
 * 启动页
 *
 * @liuchunxu 开发日期：2016/9/7 15:17
 */
public class SplashActivity extends BaseActivity<WelcomeView, WelcomePresenter> implements WelcomeView, View.OnClickListener {
    private static final int SHOW_TIME_MIN = 2000;
    ProgressDialog mypDialog;

    private int preProgress = 0;
    private long startTime;
    private Runnable getIsFirstEnter = new Runnable() {

        @Override
        public void run() {
            presenter.getIsFirstEnter();
        }
    };

    @Override
    public WelcomePresenter initPresenter() {
        return new WelcomePresenter(mContext);
    }

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_welcome);
        Button mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnUpdate.setOnClickListener(this);
    }

    @Override
    public void init() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void initData() {
//        MPermissions.requestPermissions(mActivity, 101, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        presenter.getHotFix();
        sendMsg();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void getHotFixSuccess() {
        presenter.downFixApk("http://test1.cqxiaokang.com/apk/cqxiaokang-fix.apk");
    }

    @Override
    public void getHotFixFail() {
        sendMsg();
    }

    @Override
    public void downFixApkSuccess(File file) {
        File optDir = new File(getFilesDir(), "fix_opt");
        if (!optDir.exists()) {
            optDir.mkdirs();
        }
//        boolean b = new Aceso().installPatch(optDir, file);
//        if (b) {
//            file.delete();
//        }
        sendMsg();
    }

    @Override
    public void downFixApkFail() {
        sendMsg();
    }

    @Override
    public void downFixApkProgress(float progress) {
        int currProgress = (int) (100 * progress);
        //防止界面卡死
        if (preProgress < currProgress) {
        }
        preProgress = currProgress;
    }

    @Override
    public void notFirstEnter() {
//        go2Activity(MainActivity.class);
    }

    @Override
    public void isFirstEnter() {
//        go2Activity(GuideActivity.class);
        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), "com.cqxiaokang.main.MainActivity");
        startActivity(intent);
    }

    /**
     * 向handler发送消息
     *
     * @刘春旭 开发日期：2017/2/28 11:56
     */
    private void sendMsg() {
        long loadingTime = System.currentTimeMillis() - startTime;
        if (loadingTime < SHOW_TIME_MIN) {// 如果比最小显示时间还短，就延时进入MainActivity，否则直接进入
            new Handler().postDelayed(getIsFirstEnter, SHOW_TIME_MIN - loadingTime);
        } else {
            new Handler().post(getIsFirstEnter);
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

//    @PermissionGrant(101)
//    public void requestSdcardSuccess() {
//        sendMsg();
//    }
//
//    @PermissionDenied(101)
//    public void requestSdcardFailed() {
//        sendMsg();
//    }

    @Override
    public void onClick(View v) {
        mypDialog = new ProgressDialog(this);
        //实例化
        mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //设置进度条风格，风格为圆形，旋转的
        mypDialog.setMessage("loading...");
        //设置ProgressDialog 的一个Button
        mypDialog.setIndeterminate(false);
        //设置ProgressDialog 的进度条是否不明确
        mypDialog.setCancelable(true);
        //设置ProgressDialog 是否可以按退回按键取消
        mypDialog.show();
        //让ProgressDialog显示
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Updater.update(getBaseContext());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                mypDialog.cancel();
                Toast.makeText(mActivity, "动态部署完成，重启APP完成效果查看", Toast.LENGTH_SHORT).show();
//                mypDialog.cancel();
//                Intent intent = getBaseContext().getPackageManager()
//                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
//                PendingIntent restartIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
//                AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, restartIntent); // 1秒钟后重启应用
//                System.exit(0);
            }
        }.execute();
    }
}
