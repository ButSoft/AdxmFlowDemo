package com.adxmi.android.demo;

import java.util.List;

import com.adxmi.customizedad.AdManager;
import com.adxmi.customizedad.ContentAdModel;
import com.adxmi.customizedad.ContentAdRequestListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.Toast;

import com.adxmi.android.flow.R;

public class ContentActivity extends Activity implements ContentAdRequestListener {
	private final static String mAppId = "6da89d8c06ac0bc2";
	private final static String mAppSecret = "007fc58cb2e2f410";

	// view
	private ListView mListView;
	private ContentAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		mListView = (ListView) findViewById(R.id.listview);

		// init
		AdManager.getInstance(this).init(mAppId, mAppSecret, AdManager.TYPE_CONTENT);
		// set debug log
		AdManager.getInstance(this).setEnableDebugLog(true);

		
		// Register the listener for the request of ads
		AdManager.getInstance(this).registerRequestAdListener(this);
		// Request ads
		AdManager.getInstance(ContentActivity.this).requestAd(10);
	}

	@Override
	public void onRequestResult(List<ContentAdModel> adsList) {
		// return
		if (adsList == null || adsList.size() == 0) {
			Toast.makeText(ContentActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
			return;
		}

		//
		mAdapter = new ContentAdapter(ContentActivity.this, adsList);
		mListView.setAdapter(mAdapter);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			// Call of showing ads
			boolean b = AdManager.getInstance(ContentActivity.this).onKeyBack();
			if (b) {
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

}
