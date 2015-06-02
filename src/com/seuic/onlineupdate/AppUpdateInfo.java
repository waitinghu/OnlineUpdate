package com.seuic.onlineupdate;

public class AppUpdateInfo {
    
    private int version;
    private String description;
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public AppUpdateInfo(int version, String description) {
        super();
        this.version = version;
        this.description = description;
    }
}
