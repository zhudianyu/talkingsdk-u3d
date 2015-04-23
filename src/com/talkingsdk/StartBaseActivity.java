package com.talkingsdk;

import android.app.Activity;
import android.os.Bundle;

public class StartBaseActivity extends Activity {
    private static StartBaseActivity _instance = null;

    public static StartBaseActivity getInstance() {
        return _instance;
    }

    public static void clearInstance() {
        _instance = null;
    }

    protected void onCreate(Bundle savedInstanceState) {
        _instance = this;
        super.onCreate(savedInstanceState);
        if (getIntent().getAction() == "android.intent.action.MAIN") {
            MainApplication.getInstance().getSdkInstance().setMainActivity(this);
        }
    }

    @Override
    protected void onResume() {
        _instance = this;
        super.onResume();
        if (getIntent().getAction() == "android.intent.action.MAIN") {
            MainApplication.getInstance().getSdkInstance().onActivityCreate(this);
        }
    }
}
