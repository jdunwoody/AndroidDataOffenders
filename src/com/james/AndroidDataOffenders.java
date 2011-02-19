package com.james;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Process;

public class AndroidDataOffenders extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TrafficStats stats = new TrafficStats();

		stats.getMobileRxBytes();
		stats.getTotalRxBytes();

		int myUid = Process.myUid();
		ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

		for (RunningAppProcessInfo processInfo : activityManager.getRunningAppProcesses()) {
			System.out.println(processInfo.processName + " hase used " + stats.getUidRxBytes(processInfo.uid) + " bytes");
		}

		setContentView(R.layout.main);
	}
}