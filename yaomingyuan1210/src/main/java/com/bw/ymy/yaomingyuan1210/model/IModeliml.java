package com.bw.ymy.yaomingyuan1210.model;

import android.os.AsyncTask;

import com.bw.ymy.yaomingyuan1210.nutils.Nutils;
import com.bw.ymy.yaomingyuan1210.callback.MycallBack;
import com.google.gson.Gson;

public class IModeliml implements  IModel  {

    public  <T> T getRequest(String urlstr,String param,Class clazz)
    {
        return  (T)new Gson().fromJson(Nutils.getRequest(urlstr),clazz);
    }
    @Override
    public void getRequest(final String urlstr,final String param, final Class clazz,final MycallBack mycallBack) {

        new AsyncTask<String,Void,Object>()
        {
            @Override
            protected Object doInBackground(String... strings) {
                return getRequest(urlstr,param,clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
              mycallBack.onsuccess(o);
            }
        }.execute(urlstr);

    }
}
