package com.bw.ymy.yaomingyuan1210.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextview extends android.support.v7.widget.AppCompatTextView {
    public MyTextview(Context context) {
        super(context);
    }

    public MyTextview(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextview(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
