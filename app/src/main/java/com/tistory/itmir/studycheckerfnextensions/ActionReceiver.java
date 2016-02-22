package com.tistory.itmir.studycheckerfnextensions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import robj.floating.notifications.Extension;

public class ActionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context mContext, Intent mIntent) {
        Log.e("ActionReceiver", "onReceive");

        try {
            if (mIntent.getAction().equals(Extension.INTENT)) {
                int action = mIntent.getIntExtra(Extension.ACTION, -1);
                if (action == 0) {
                    // Click Text
                    Intent myIntent = new Intent();
                    myIntent.setAction("com.mjsoft.apps.sc.action.STOP");
                    myIntent.putExtra("is_silent", true);
                    mContext.sendBroadcast(myIntent);

                    mContext.startActivity(mContext.getPackageManager().getLaunchIntentForPackage("com.mjsoft.apps.sc"));

                    Extension.hideAll(mIntent.getLongExtra(Extension.ID, -1), mContext);
                } else if (action == 1) {
                    // Show Study List
                    Intent myIntent = new Intent();
                    myIntent.setAction("com.mjsoft.apps.sc.action.SELECT");
                    myIntent.putExtra("is_silent", true);
                    mContext.sendBroadcast(myIntent);

                    Extension.hideAll(mIntent.getLongExtra(Extension.ID, -1), mContext);
                } else if (action == 2) {
                    // play
                    Intent myIntent = new Intent();
                    myIntent.setAction("com.mjsoft.apps.sc.action.REPLAY");
                    myIntent.putExtra("is_silent", true);
                    mContext.sendBroadcast(myIntent);

                    Extension.hideAll(mIntent.getLongExtra(Extension.ID, -1), mContext);
                } else if (action == 3) {
                    // pause
                    Intent myIntent = new Intent();
                    myIntent.setAction("com.mjsoft.apps.sc.action.PAUSE");
                    myIntent.putExtra("is_silent", true);
                    mContext.sendBroadcast(myIntent);

                    Extension.hideAll(mIntent.getLongExtra(Extension.ID, -1), mContext);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
