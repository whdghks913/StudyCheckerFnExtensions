package robj.floating.notifications;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class Reply extends Activity {
	
	private long id;
	private int replyId;
	
	@Override
	protected final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
		id = getIntent().getLongExtra("id", -1);
		
		Resources res = null; Context viewContext = null;
		try {
			viewContext = createPackageContext(Extension.parent, Context.CONTEXT_IGNORE_SECURITY);
			res = viewContext.getResources();
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(res != null)
		{
			final RelativeLayout view = (RelativeLayout) LayoutInflater.from(viewContext).inflate(getIntent().getBooleanExtra("lightTheme", false) ? 
					res.getLayout(res.getIdentifier("activity_reply", "layout", Extension.parent)) : 
						res.getLayout(res.getIdentifier("activity_reply_dark", "layout", Extension.parent)), null);
			
			replyId = res.getIdentifier("etReply", "id", Extension.parent);
			final EditText et = (EditText) view.findViewById(replyId);
			et.setHint(getIntent().getStringExtra("hint"));

			TextView message = (TextView) view.findViewById(res.getIdentifier("tvMessage", "id", Extension.parent));
			message.setMovementMethod(new ScrollingMovementMethod());
			message.setText(getIntent().getStringExtra("previous"));

			if(getIntent().getBooleanExtra("extraBtn", false))
			{
				ImageButton img = (ImageButton) view.findViewById(res.getIdentifier("btnExtra", "id", Extension.parent));
				img.setImageBitmap((Bitmap) getIntent().getParcelableExtra("extraBtnImage"));
				img.setVisibility(View.VISIBLE);
				img.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						onExtraButtonClick(v);
					}});
			}
		
			ImageView contact = ((ImageView) view.findViewById(res.getIdentifier("imgContact", "id", Extension.parent)));
			contact.setImageBitmap((Bitmap) getIntent().getParcelableExtra("image")); //image link to contact card
			contact.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					onImageClick(v);
				}});
			
			((ImageButton) view.findViewById(res.getIdentifier("btnSend", "id", Extension.parent))).setOnClickListener(
					new OnClickListener()
					{
						@Override
						public final void onClick(View v)
						{
							onReply(((EditText) findViewById(replyId)).getText().toString());
						}
				
					}
							
					);
			
			setContentView(view);
		}
	}
	
	public long getId()
	{
		return id;
	}
	
	public abstract void onReply(String msg);
	
	public abstract void onImageClick(View v);
	
	public abstract void onExtraButtonClick(View v);
	
}
