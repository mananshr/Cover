package com.binjcover.netStat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

	public NetworkChangeReceiver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		String status = CheckNw.getConnectivityStatusString(context);
		 
        Toast.makeText(context, status, Toast.LENGTH_LONG).show();
	}

}
