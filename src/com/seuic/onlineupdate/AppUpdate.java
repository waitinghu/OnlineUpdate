package com.seuic.onlineupdate;

import java.io.Serializable;


public class AppUpdate implements Serializable {

    private static final long serialVersionUID = -1356876892850891288L;
    public final static String UTF8 = "UTF-8";
    public final static String NODE_ROOT = "oschina";

    private int versionCode;
    private String versionName;
    private String downloadUrl;
    private String updateLog;

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateLog() {
        return updateLog;
    }

    public void setUpdateLog(String updateLog) {
        this.updateLog = updateLog;
    }
}

