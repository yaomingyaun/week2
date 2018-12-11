package com.bw.ymy.yaomingyuan1210.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.ymy.yaomingyuan1210.R;
import com.bw.ymy.yaomingyuan1210.fragment.one;
import com.bw.ymy.yaomingyuan1210.fragment.two;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends FragmentActivity {
    private ViewPager viewPager;
    private RadioGroup radio;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //获取资源id
        viewPager=findViewById(R.id.viewpage);
        radio=findViewById(R.id.radio);

        list=new ArrayList<Fragment>();
        list.add(new one());
        list.add(new two());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.but1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        viewPager.setCurrentItem(1);
                }
            }
        });

    }
}
