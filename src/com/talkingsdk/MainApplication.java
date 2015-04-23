package com.talkingsdk;


import com.talkingsdk.models.LoginData;
import com.talkingsdk.models.PayData;

import android.app.Application;

public class MainApplication implements SdkObjectInfo{

    // code 表示登录是的状态
    // wandoujia code==3 正常登录；code==4 新注册
    public native void notifyGameLogined(LoginData ld, int code);
    // 91
    // ND_COM_PLATFORM_ERROR_USER_SWITCH_ACCOUNT 玩家将要注销帐号
    // ND_COM_PLATFORM_ERROR_USER_RESTART        玩家将要注销帐号
    // ND_COM_PLATFORM_ERROR_CANCEL              取消帐号登录 玩家点击社区注销账号按钮但未输入新账号登录,而是退出界面可捕捉此状态
    public native void notifyGameLogout(int code);
    public native void notifyGamePaid(PayData pd, int code);
    public native void exitApp(int code);

    private SdkBase _sdkInstance = null;
    public SdkBase getSdkInstance()
    {
        return _sdkInstance;
    }


    public void setSdkInstance(SdkBase obj) 
    {
        _sdkInstance = obj;
    }


    private static MainApplication _instance = null;
    public static MainApplication getInstance()
    {
        if(_instance == null){
            _instance = new MainApplication();
        }
        return _instance;
    }

    public String getSdkObjectPackagePath(){
        return "";
    }

}
