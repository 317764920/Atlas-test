package com.cqxiaokang.atlas.test;

/**
 * 欢迎业务接口
 *
 * @liuchunxu
 * @2016年08月26日 15:09
 */
public interface IWelcomePresenter {
    /**
     * 判断是否是第一次进入APP
     *
     * @liuchunxu 开发日期：2016/8/26 15:10
     */
    void getIsFirstEnter();

    /**
     * 获取热修复补丁信息
     *
     * @刘春旭 开发日期：2017/2/27 14:14
     */
    void getHotFix();

    /**
     * 下载fix补丁
     *
     * @刘春旭 开发日期：2017/2/28 11:59
     */
    void downFixApk(String apkUrl);
}
