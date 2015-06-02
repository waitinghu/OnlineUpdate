package com.seuic.onlineupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
    
    public static final String SERVIER_PATH = "";
    private Button btm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btm = (Button) findViewById(R.id.button);
        btm.setOnClickListener(this);
    }
    
    public int getCurrentAppVersion() {
        int currentVersionCode = 0;
        Context ctx = getApplicationContext();
        PackageManager manager = ctx.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
            String appVersionName = info.versionName; //版本名
            currentVersionCode = info.versionCode; //版本号
            System.out.println(currentVersionCode + " " + appVersionName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return currentVersionCode;
    }
    
    public AppUpdateInfo checkServerUpdate() {
        
        AppUpdateInfo info = null;
        
        
        
        return info;
    }
    
    
    public void checkUpdate() {
        
        final UpdateTask task = new UpdateTask();
        task.execute();
        Dialog dialog = new AlertDialog.Builder(MainActivity.this).setTitle("软件更新")
                .setMessage("正在检查服务器版本...")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        task.cancel(true);
                    }
                })
                .create();
        dialog.show();
    }
    
    
    public class UpdateTask extends AsyncTask<Void, Integer, AppUpdateInfo> {
        
        private boolean isUIStop = false;
        
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected AppUpdateInfo doInBackground(Void... params) {
            
            publishProgress(10);
            
            return null;
        }
        
        @Override
        protected void onPostExecute(AppUpdateInfo result) {
            super.onPostExecute(result);
        }
    }
    
    
    public void notNewVersionShow() {  
        int verCode = 1;//Config.getVerCode(this);  
        String verName = "";//Config.getVerName(this);  
        StringBuffer sb = new StringBuffer();  
        sb.append("当前版本:");  
        sb.append(verName);  
        sb.append(" Code:");  
        sb.append(verCode);  
        sb.append(",/n已是最新版,无需更新!");  
        Dialog dialog = new AlertDialog.Builder(MainActivity.this).setTitle("软件更新")  
                .setMessage(sb.toString())// 设置内容  
                .setPositiveButton("确定",// 设置确定按钮  
                        new DialogInterface.OnClickListener() {  
                            @Override  
                            public void onClick(DialogInterface dialog,  
                                    int which) {  
                                finish();  
                            }  
                        }).create();// 创建  
        // 显示对话框   
        dialog.show();  
    }  

    @Override
    public void onClick(View v) {
        checkUpdate();
    }
}
