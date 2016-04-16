package com.adxmi.android.demo;

import com.adxmi.customizedad.AdManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.adxmi.android.flow.R;

public class IconActivity extends Activity implements OnClickListener {
	private final static String mAppId = "6da89d8c06ac0bc2";
	private final static String mAppSecret = "007fc58cb2e2f410";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icon);
		findViewById(R.id.icon_btn).setOnClickListener(this);

		
		
		// init
		AdManager.getInstance(this).init(mAppId, mAppSecret, AdManager.TYPE_ICON);
		// set debug log
		AdManager.getInstance(this).setEnableDebugLog(true);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.icon_btn:
			AdManager.getInstance(IconActivity.this).show();
			break;

		default:
			break;
		}

	}

}
