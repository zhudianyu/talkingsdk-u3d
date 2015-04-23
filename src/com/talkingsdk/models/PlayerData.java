package com.talkingsdk.models;

import java.util.HashMap;
import java.util.Map;
/**
*玩家信息bean 用于传递玩家角色信息
**/
public class PlayerData {
    private String serverNo; //区服
    private String roleName; //角色名称
    private int roleId; //角色id
    private int level; //等级
    private Map<String,String> ex = null; //其他信息

    public String getServerNo(){
        return serverNo;
    }

    public void setServerNo(String _serverNo){
        this.serverNo = _serverNo;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String _roleName){
        this.roleName = _roleName;
    }

    public int getRoleId(){
        return roleId;
    }

    public void setRoleId(int _roleId){
        this.roleId = _roleId;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int _level){
        this.level = _level;
    }

    public Map<String,String> getEx(){
        return ex;
    }

    public void setEx(Map<String,String> _ex){
        this.ex = _ex;
    }

    @Override
    public String toString() {
        return "PlayerData [serverNo=" + serverNo + ", roleName=" + roleName + ", roleId=" + roleId
                + ", level=" + level + "]";
    }

}
