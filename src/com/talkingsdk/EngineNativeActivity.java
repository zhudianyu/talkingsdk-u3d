package com.talkingsdk;


import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import com.talkingsdk.models.LoginData;

import android.os.Bundle;

public class EngineNativeActivity extends UnityPlayerActivity{
    static EngineNativeActivity _instance = null;

    public static EngineNativeActivity getInstance() {
        return _instance;
    }

    public static void clearInstance() {
        _instance = null;
    }

    protected void onCreate(Bundle savedInstanceState) {
        _instance = this;
        super.onCreate(savedInstanceState);
        MainApplication.getInstance().getSdkInstance().setGameActivity(this);
         MainApplication.getInstance().getSdkInstance().onActivityCreate(this);
    }

    public void destroyToorBar() {}

    @Override
    protected void onResume() {
        super.onResume();
        MainApplication.getInstance().getSdkInstance().onGameResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainApplication.getInstance().getSdkInstance().onGameFade();
    }

    protected void notifyGameLogined(LoginData loginData) {
        String json = loginData.toString();
        String unityGameObject = MainApplication.getInstance().getSdkInstance().getUnityGameObject();
        UnityPlayer.UnitySendMessage(unityGameObject, "OnInitComplete", json);
    }
}
