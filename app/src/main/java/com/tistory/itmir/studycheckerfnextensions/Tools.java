package com.tistory.itmir.studycheckerfnextensions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import robj.floating.notifications.Extension;

/**
 * Created by 종환 on 2015-03-01.
 */
public class Tools {
    public static final long ID = 19980913;
    public static final int ID_int = 19980913;
    public static final String mPackageName = "com.mjsoft.apps.sc";

    public static Bitmap resizeBitmap(Bitmap image) {
        Paint paint = new Paint();
        paint.setFilterBitmap(true);

        Bitmap result = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        float ratioX = 200 / (float) image.getWidth();
        float ratioY = 200 / (float) image.getHeight();
        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, 1, 1);

        Canvas canvas = new Canvas();
        canvas.setBitmap(result);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(image, 0, 0, paint);

        return result;
    }

    public static void showFN(Context mContext) {
        Extension.addOrUpdate(Tools.resizeBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.studychecker_icon)),
                mContext.getString(R.string.notification_msg),
                Tools.ID, Tools.ID_int,
                BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_home),
                BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_fullscreen_play),
                BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_fullscreen_pause),
                false, false, true,
                mContext);
    }

    public static void showFN(Context mContext, String mText) {
        Extension.addOrUpdate(Tools.resizeBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.studychecker_icon)),
                mText,
                Tools.ID, Tools.ID_int,
                BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_home),
                BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_fullscreen_play),
                BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_fullscreen_pause),
                false, false, true,
                mContext);
    }

    public static void hideFN(Context mContext) {
        Extension.remove(Tools.ID, mContext);
    }
}
