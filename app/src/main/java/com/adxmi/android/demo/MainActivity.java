package com.adxmi.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.adxmi.android.flow.R;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.icon_btn).setOnClickListener(this);
		findViewById(R.id.content_btn).setOnClickListener(this);
		findViewById(R.id.store_btn).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.icon_btn:
			startActivity(new Intent(MainActivity.this, IconActivity.class));
			break;
		case R.id.content_btn:
			startActivity(new Intent(MainActivity.this, ContentActivity.class));
			break;
		case R.id.store_btn:
			startActivity(new Intent(MainActivity.this, DemoStoreActivity.class));
			break;
		default:
			break;
		}
	}
}
