package com.bw.ymy.yaomingyuan1210.nutils;

import android.app.Application;
import android.graphics.Bitmap;

import com.bw.ymy.yaomingyuan1210.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //UMConfigure  报红  在 build 写上3个SDK
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(50)
                .diskCacheSize(50*1024*1024)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .cacheOnDisk(true)
                        .cacheInMemory(true)
                        .showImageOnLoading(R.mipmap.ic_launcher)
                        .showImageOnFail(R.mipmap.ic_launcher)
                        .showImageForEmptyUri(R.mipmap.ic_launcher)
                        .build())
                .build());

    }
}
