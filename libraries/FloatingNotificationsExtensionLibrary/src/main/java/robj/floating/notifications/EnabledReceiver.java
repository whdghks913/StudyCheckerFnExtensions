package robj.floating.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class EnabledReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.v("Extension", "Enabled called..");
		context = context.getApplicationContext();
	
	    if (intent.getAction().equals("robj.floating.notifications.extension.ENABLED"))
	    {
	    	Extension.setEnabled(context, intent.getIntExtra("id", 0), true);
		} else if (intent.getAction().equals("robj.floating.notifications.extension.DISABLED")) {
			Extension.setEnabled(context, intent.getIntExtra("id", 0), false);
		}
	}
	
}
