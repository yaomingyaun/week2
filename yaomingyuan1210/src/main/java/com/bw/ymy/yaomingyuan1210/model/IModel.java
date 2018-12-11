package com.bw.ymy.yaomingyuan1210.model;

import com.bw.ymy.yaomingyuan1210.callback.MycallBack;

public interface IModel {
    void getRequest(String urlstr, String param, Class clazz, MycallBack mycallBack);
}
