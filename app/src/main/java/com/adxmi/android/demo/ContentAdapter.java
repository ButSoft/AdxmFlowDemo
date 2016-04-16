package com.adxmi.android.demo;

import java.util.List;

import com.adxmi.customizedad.AdManager;
import com.adxmi.customizedad.ContentAdModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.adxmi.android.flow.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ContentAdapter extends BaseAdapter {
	private Context mContext;
	private ImageLoader mImageLoader;
	private List<ContentAdModel> mList;

	public ContentAdapter(Context context, List<ContentAdModel> list) {
		this.mContext = context;
		this.mList = list;
		this.mImageLoader = ImageLoader.getInstance();
	}

	@Override
	public int getCount() {
		return mList == null ? 0 : mList.size();
	}

	@Override
	public ContentAdModel getItem(int position) {
		return mList == null ? null : mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		if (mList == null || mList.size() == 0) {
			return null;
		}

		ViewHold vh;
		if (convertView == null) {
			vh = new ViewHold();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_content, null);
			vh.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			vh.tv_name = (TextView) convertView.findViewById(R.id.name);
			vh.btn_install = (Button) convertView.findViewById(R.id.install_btn);
			convertView.setTag(vh);
		} else {
			vh = (ViewHold) convertView.getTag();
		}

		final ContentAdModel product = getItem(position);
		mImageLoader.displayImage(product.getIcon(), vh.iv_icon);
		vh.tv_name.setText(product.getName());
		vh.btn_install.setText(product.getBtn());

		vh.btn_install.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Jump to Google play
				AdManager.getInstance(mContext).onClickAd(product.getId());
			}
		});
		return convertView;
	}

	class ViewHold {
		ImageView iv_icon;
		TextView tv_name;
		Button btn_install;
	}

}