package com.adxmi.android.demo;

import java.io.File;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Configure imageLoader
		initImageLoader();
	}

	private void initImageLoader() {
		File cacheDir = StorageUtils.getOwnCacheDirectory(this, Environment.getExternalStorageState() + File.separator + "test");
		DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).build();

		L.writeDebugLogs(false);
		L.writeLogs(false);
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).threadPoolSize(5)
				.threadPriority(Thread.NORM_PRIORITY - 1).diskCache(new UnlimitedDiscCache(cacheDir))
				.defaultDisplayImageOptions(options).build();
		ImageLoader.getInstance().init(config);
	}
}