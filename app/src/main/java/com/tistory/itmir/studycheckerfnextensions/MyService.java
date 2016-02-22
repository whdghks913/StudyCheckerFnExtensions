package com.tistory.itmir.studycheckerfnextensions;

import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;

import robj.floating.notifications.Extension;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * public static void addOrUpdate(final Bitmap image, final String message, final long id,
         * final Bitmap actionOne, final Bitmap actionTwo, final Bitmap actionThree,
         * final boolean persistent, final boolean stack, final boolean hideCounter, Context context)
         */
        Tools.showFN(this);
        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
