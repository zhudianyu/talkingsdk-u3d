package com.talkingsdk;

import com.talkingsdk.models.LoginData;
import com.talkingsdk.models.PayData;

public interface RequestBase {
    public void onLoginedRequest(LoginData loginData, int code);
    public void onPaidRequest(PayData payData, int code);
    public void onLogoutRequest(int code);
    public void onChangeAccountRequest(LoginData loginData, int code);
}
