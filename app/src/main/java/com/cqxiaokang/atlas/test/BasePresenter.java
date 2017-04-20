package com.cqxiaokang.atlas.test;

/**
 * 业务基类
 *
 * @liuchunxu
 * @2016年08月26日 09:22
 */
public abstract class BasePresenter<V>{
    public int PAGE_SIZE = 10;
    /*这个基类的Presenter 主要的作用就是将当前Presenter持有的view 在合适的时候给清除掉*/
    public V mView;

    public void attach(V mView) {
        this.mView = mView;
    }

//    public void detach() {
//        mView = null;
//    }

    public boolean isAttached() {
        return mView != null;
    }

}
