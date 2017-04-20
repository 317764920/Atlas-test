package com.cqxiaokang.atlas.test;

import java.io.File;

/**
 * 欢迎视图接口
 *
 * @liuchunxu
 * @2016年08月26日 10:27
 */
public interface WelcomeView {
    /**
     * 去首页
     *
     * @liuchunxu 开发日期：2016/8/26 10:28
     */
    void notFirstEnter();

    /**
     * 去引导页
     *
     * @liuchunxu 开发日期：2016/8/26 10:28
     */
    void isFirstEnter();

    /**
     * 获取热修复信息成功
     *
     * @刘春旭 开发日期：2017/2/27 14:18
     */
    void getHotFixSuccess();

    /**
     * 获取热修复信息失败
     *
     * @刘春旭 开发日期：2017/2/27 14:18
     */
    void getHotFixFail();

    /**
     * 下载fix成功
     *
     * @刘春旭 开发日期：2017/2/28 11:58
     */
    void downFixApkSuccess(File file);

    /**
     * 下载fix失败
     *
     * @刘春旭 开发日期：2017/2/28 11:58
     */
    void downFixApkFail();

    /**
     * 下载fix进度
     *
     * @刘春旭 开发日期：2017/2/28 11:58
     */
    void downFixApkProgress(float progress);
}
