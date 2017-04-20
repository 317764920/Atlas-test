package com.cqxiaokang.atlas.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * activity基类
 *
 * @liuchunxu 开发日期：2016/7/27 15:01
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    public String TAG = getClass().getSimpleName();
    public Context mContext;
    public Activity mActivity;
    /*定义一个Presenter 用于解绑持有的View
    *
    * 在onCreate进行初始化Presenter的操作
    * 在onResume中进行绑定
    * 在onDestroy 中进行解绑
    *
    * */
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, TAG);
        mContext = getApplicationContext();
        mActivity = this;
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach((V) this);
        }
        //改变状态栏颜色
//        ViewUtils.initWindow(mActivity, getResources().getColor(R.color.system_bar_color));
        //将activity入自定义栈
        // 定制流程
        setContentLayout();
        //绑定activity---butterknife
//        ButterKnife.bind(mActivity);
        //绑定activity---eventbus，监听网络状态
        init();
        initData();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void go2Activity(Class cls) {
        startActivity(new Intent(mContext, cls));
    }

    public void go2Activity(Class cls, Bundle bundle) {
        Intent intent = new Intent(mContext, cls);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void startPlugin(String targetPackage) {
//        Intent intent = XkPlugin.createIntent(mContext, targetPackage);
//        mContext.startActivity(intent);
    }

    public void startPlugin(String targetPackage, Bundle bundle) {
//        Intent intent = XkPlugin.createIntent(mContext, targetPackage);
//        intent.putExtras(bundle);
//        mContext.startActivity(intent);
    }

    /**
     * 适配为不同的View 装载不同Presenter
     *
     * @liuchunxu 开发日期：2016/8/26 9:26
     */
    public abstract T initPresenter();

    /**
     * @throws : void
     * @Description(功能描述) : 加载布局
     * @author(作者) ： liuchunxu
     * @date (开发日期) : 2015年7月7日 下午3:50:18
     */
    public abstract void setContentLayout();

    /**
     * @throws : void
     * @Description(功能描述) : 初始化
     * @author(作者) ： liuchunxu
     * @date (开发日期) : 2015年7月7日 下午3:50:43
     */
    public abstract void init();

    /**
     * 初始化数据
     *
     * @liuchunxu 开发日期：2016/8/29 9:26
     */
    public abstract void initData();
}
