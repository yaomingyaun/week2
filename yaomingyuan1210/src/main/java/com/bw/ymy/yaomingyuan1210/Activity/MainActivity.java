package com.bw.ymy.yaomingyuan1210.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.ymy.yaomingyuan1210.Bean.DengBean;
import com.bw.ymy.yaomingyuan1210.R;
import com.bw.ymy.yaomingyuan1210.presenter.IPresenterIpl;
import com.bw.ymy.yaomingyuan1210.view.IView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView
{
            private EditText etphone,etpass;
            private Button login;
            private TextView sing;
            private ImageView qq_login;
            IPresenterIpl iPresenterIpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取资源Id
        etphone=findViewById(R.id.etphone);
        etpass=findViewById(R.id.etpass);
        login=findViewById(R.id.login);
        qq_login=findViewById(R.id.qq_login);
        sing=findViewById(R.id.sing);
        iPresenterIpl=new IPresenterIpl(this);
        //点击登录
        login.setOnClickListener(this);
        //点击注册
        sing.setOnClickListener(this);

        qq_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            //登录
            case  R.id.login:
                String phone=etphone.getText().toString();
                String pass=etpass.getText().toString();
                iPresenterIpl.getRequest("http://www.zhaoapi.cn/user/login?mobile="+phone+"&password="+pass,null,DengBean.class);
                break;
                //注册
            case  R.id.sing:
                Intent intent=new Intent(MainActivity.this,SingActivity.class);
                startActivity(intent);
                break;
            case R.id.qq_login:
                UMShareAPI umShareAPI=UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Intent intent=new Intent(MainActivity.this,ShowActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
                break;


        }
    }

    @Override
    public void getRequest(Object data) {

        DengBean dengBean= (DengBean) data;
        if(dengBean.getCode().equals("0"))
        {
            Toast.makeText(MainActivity.this,dengBean.getMsg()+"",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(MainActivity.this,ShowActivity.class);
            startActivity(intent);

        }else
        {
            Toast.makeText(MainActivity.this,dengBean.getMsg()+"",Toast.LENGTH_LONG).show();
        }

    }
}
