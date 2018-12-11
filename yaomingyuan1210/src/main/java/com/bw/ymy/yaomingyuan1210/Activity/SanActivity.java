package com.bw.ymy.yaomingyuan1210.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.ymy.yaomingyuan1210.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class SanActivity extends AppCompatActivity implements QRCodeView.Delegate {
private ZXingView zxing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san);
        zxing=findViewById(R.id.zxing);
        zxing.setDelegate(this);
    }

    //开启
    @Override
    protected void onResume() {
        super.onResume();
        zxing.startCamera();
        zxing.startSpotAndShowRect();
    }





        //关闭
    @Override
    protected void onStop() {
        super.onStop();
        zxing.stopCamera();
    }

    //销毁

    @Override
    protected void onDestroy() {
        super.onDestroy();
        zxing.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {

    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
