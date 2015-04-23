package com.talkingsdk.models;

import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONException;

public class LoginData {
    private String _userId = "";
    private String _username = "";
    private String _nickName = "";
    private String _password = "";
    private String _sessionId = "";
    private HashMap<String, String> _ex = new HashMap<String,String>();

    public LoginData() {
    }

    public String getUserId() {
        return _userId;
    }

    public void setUserId(String userId) {
        this._userId = userId;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getNickName() {
        return _nickName;
    }

    public void setNickName(String nickName) {
        this._nickName = nickName;
    }

    public String getSessionId() {
        return _sessionId;
    }

    public void setSessionId(String sessionId) {
        this._sessionId = sessionId;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    public void setEx(HashMap<String,String> ex) {
        this._ex = ex;
    }

    public HashMap<String,String> getEx() {
        return _ex;
    }

    @Override
    public String toString() {
        return "LoginData [_userId=" + _userId + ", _username=" + _username + ", _nickName=" + _nickName
                + ", _password=" + _password + ", _sessionId=" + _sessionId
                + ", _ex=" + _ex + "]";
    }

    public String toJSON() {
        String jsonStr = null;
        try {
            JSONObject json = new JSONObject();
            json.put("UserId", this._userId == null ? "": this._userId );
            json.put("UserName", this._username == null ? "": this._username );
            json.put("NickName", this._nickName == null ? "": this._nickName );
            json.put("Password", this._password == null ? "": this._password );
            json.put("SessionId", this._sessionId == null ? "": this._sessionId );
            JSONObject ext = new JSONObject(this._ex);
            json.put("Ext", ext);
            jsonStr = json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
