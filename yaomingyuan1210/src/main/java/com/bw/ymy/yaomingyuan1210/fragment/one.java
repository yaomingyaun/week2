package com.bw.ymy.yaomingyuan1210.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bw.ymy.yaomingyuan1210.Activity.SanActivity;
import com.bw.ymy.yaomingyuan1210.Bean.UserBean;
import com.bw.ymy.yaomingyuan1210.Adapter.MyBase;
import com.bw.ymy.yaomingyuan1210.R;
import com.bw.ymy.yaomingyuan1210.presenter.IPresenterIpl;
import com.bw.ymy.yaomingyuan1210.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import me.maxwin.view.XListView;

public class one extends Fragment implements IView {
    private Button kai;
    private Banner banner;
    IPresenterIpl iPresenterIpl;
    private MyBase adapter;
    private XListView xlistview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //获取资源id
             kai=view.findViewById(R.id.kai);
            iPresenterIpl=new IPresenterIpl(this);
            banner=view.findViewById(R.id.banner);

            xlistview=view.findViewById(R.id.xlistview);
        //适配器
        adapter=new MyBase(getContext());
        xlistview.setAdapter(adapter);
        //轮播图
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                UserBean.DataBean userBean= (UserBean.DataBean) path;
                com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(userBean.setImage(),imageView);

            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView=new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });
        inlodata();
        //点击
        kai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkk();
            }
        });
    }
    private void inlodata() {
        iPresenterIpl.getRequest("http://www.zhaoapi.cn/ad/getAd?token=05329B0DCBE400ED03760D7B27627FC7",null,UserBean.class);
    }
    //
    public  void checkk()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},100);
            }else
            {
                startActivity(new Intent(getActivity(),SanActivity.class));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            startActivity(new Intent(getActivity(),SanActivity.class));
        }
    }

    @Override
    public void getRequest(Object data) {

        UserBean userBean= (UserBean) data;
        banner.setImages(userBean.getData());
        banner.start();
        adapter.setlist(userBean.getData());

    }
}
