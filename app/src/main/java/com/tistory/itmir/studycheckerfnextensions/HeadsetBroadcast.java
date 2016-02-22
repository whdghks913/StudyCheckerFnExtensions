package com.tistory.itmir.studycheckerfnextensions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import robj.floating.notifications.Extension;

public class HeadsetBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context mContext, Intent mIntent) {
        String mAction = mIntent.getAction();
        Log.e("HeadsetBroadcast", "onReceive");

        if ("itmir.study.checker.show".equals(mAction)) {
            mContext.startService(new Intent(mContext, MyService.class));
        } else if (mAction.equals(Intent.ACTION_HEADSET_PLUG)) {
            /**
             * 1 : 이어폰 낌, 0 : 이어폰 뺌
             */
            int state = mIntent.getIntExtra("state", 0);
            if (state == 1) {
                Log.e("HeadsetBroadcast", "state=1");
                mContext.startService(new Intent(mContext, MyService.class));
            } else {
                Log.e("HeadsetBroadcast", "state=0");
                Extension.remove(Tools.ID, mContext);
            }
        }
    }
}
