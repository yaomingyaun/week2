package com.bw.ymy.yaomingyuan1210.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.ymy.yaomingyuan1210.Bean.SingBean;
import com.bw.ymy.yaomingyuan1210.R;
import com.bw.ymy.yaomingyuan1210.presenter.IPresenterIpl;
import com.bw.ymy.yaomingyuan1210.view.IView;

public class SingActivity extends AppCompatActivity implements View.OnClickListener,IView {

    private EditText zcphone,zcpass;
    private Button zhuce;
    IPresenterIpl iPresenterIpl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing);
        //获取
        zcphone=findViewById(R.id.zcphone);
        zcpass=findViewById(R.id.zcpass);
        zhuce=findViewById(R.id.zhuce);
        iPresenterIpl=new IPresenterIpl(this);
        zhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case  R.id.zhuce:
            String phone=zcphone.getText().toString();
            String pass=zcpass.getText().toString();
            iPresenterIpl.getRequest("http://www.zhaoapi.cn/user/reg?mobile="+phone+"&password="+pass,null,SingBean.class);
            break;
        }

    }

    @Override
    public void getRequest(Object data) {
        SingBean singBean= (SingBean) data;
        if(singBean.getCode().equals("0"))
        {
            Toast.makeText(SingActivity.this,singBean.getMsg()+"",Toast.LENGTH_LONG).show();
        }

    }
}
