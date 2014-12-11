package cn.edu.gdmec.s07131020.demo_wakelock;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {
private PowerManager manager;
private WakeLock lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        manager=(PowerManager) getSystemService(Context.POWER_SERVICE);
        lock=manager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "lock");
    }
    
    @Override
    	protected void onResume() {
    		super.onResume();
    		if(lock!=null){
    			lock.acquire();
    		}
    	}
    
    @Override
    	protected void onPause() {
    		super.onPause();
    		if(lock!=null&&lock.isHeld()){
    			lock.release();
    		}
    	}


   
}
