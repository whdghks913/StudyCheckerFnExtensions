package com.tistory.itmir.studycheckerfnextensions;

import android.annotation.TargetApi;
import android.os.Build;
import android.preference.PreferenceManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class StudyCheckerNotificationListenerService extends NotificationListenerService {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String getPackageName = sbn.getPackageName();

        if (Tools.mPackageName.equals(getPackageName)) {
            Tools.showFN(this);
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        String getPackageName = sbn.getPackageName();

        if (Tools.mPackageName.equals(getPackageName)) {
            if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean("stay", true))
                Tools.hideFN(this);
        }
    }
}
