package com.talkingsdk;

import java.util.List;
import java.util.Properties;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import com.talkingsdk.models.LoginData;
import com.talkingsdk.models.PayData;
import com.talkingsdk.models.PlayerData;
import android.os.Bundle;

import org.json.JSONObject;
import org.json.JSONException;

public abstract class SdkCommonObject extends UnityPlayerActivity implements SdkBase, RequestBase {

    private String TAG = "SdkCommonObject";

    private Activity _parentActivity;
    private LoginData _loginData;
    private PayData _payData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getInstance().setSdkInstance(this);
    }

    public Activity getParentActivity() {
        return UnityPlayer.currentActivity;
    }

    public void onActivityCreate(Activity parentActivity) {
        this._parentActivity = parentActivity;
    }

    @Override
    public LoginData getLoginData() {
        return _loginData;
    }

    @Override
    public void setLoginData(LoginData ld) {
        _loginData = ld;
    }

    @Override
    public PayData getPayData() {
        return _payData;
    }

    @Override
    public void setPayData(PayData ld) {
        _payData = ld;
    }

    @Override
    public String getPlatformId() {
        return getPropertiesByKey("PlatformId");
    }

    @Override
    public String getAppKey(){
        return getPropertiesByKey("AppKey");
    }

    @Override
    public String getAppId(){
        return getPropertiesByKey("AppId");
    }

    @Override
    public String getAppSecret(){
        return getPropertiesByKey("AppSecret");
    }

    @Override
    public String getNotifyUri(){
        return getPropertiesByKey("NotifyUri");
    }

    //进入游戏
    @Override
    public void enterGame(PlayerData pd){
        Log.d(TAG, pd.toString());
    }

    //玩家角色升级
    @Override
    public void userUpLevel(PlayerData pd){
        Log.d(TAG, pd.toString());
    }

    //上传积分
    public void uploadScore(String strScore, String topnid){
        Log.d(TAG, "上传积分: strScore：" + strScore + " topnid:" + topnid);
    }

    @Override
    public void setMainActivity(Activity mainActivity) {
    }
    @Override
    public void setGameActivity(Activity gameActivity) {
    }

    // read parameters from appConfig file
    public String getPropertiesByKey(String key) {
        String url = null;
        Properties properties = new Properties();
        try {
            properties.load(getParentActivity().getAssets().open("appConfig.properties"));
            url = properties.getProperty(key).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplication().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplication().getPackageName();
        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    public void clearInstances() {
        StartBaseActivity.clearInstance();
    }


    // SdkObjectInfo
    String _unityGameObject = null;
    public String getUnityGameObject() {
        return _unityGameObject;
    }

    //初始化参数
    public String  getInitJSONParams() {
        JSONObject jo =  new JSONObject();
        try {
            jo.put("PlatformId", getPlatformId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo.toString();
    }


    public void setUnityGameObject(String unityGameObject ) {
        Log.d(TAG,"setUnityGameObject:" + unityGameObject);
        String initParams = getInitJSONParams();
        Log.d(TAG,"getInitJSONParams:" + initParams);
        UnityPlayer.UnitySendMessage(unityGameObject,"OnInitComplete", initParams);
        onActivityCreate(UnityPlayer.currentActivity);
        _unityGameObject = unityGameObject;
    }
}
