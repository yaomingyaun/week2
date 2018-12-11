package com.bw.ymy.yaomingyuan1210.presenter;

import com.bw.ymy.yaomingyuan1210.callback.MycallBack;
import com.bw.ymy.yaomingyuan1210.model.IModel;
import com.bw.ymy.yaomingyuan1210.model.IModeliml;
import com.bw.ymy.yaomingyuan1210.view.IView;

public class IPresenterIpl implements  IPresenter{

    private IView mIview;
    private IModeliml mImodel;

    public IPresenterIpl(IView mIview) {
        this.mIview = mIview;
        mImodel=new IModeliml();
    }

    @Override
    public void getRequest(String urlstr, String param, Class clazz) {
        mImodel.getRequest(urlstr, param, clazz, new MycallBack() {
            @Override
            public void onsuccess(Object data) {
                mIview.getRequest(data);
            }
        });

    }
    public  void detach()
    {
        if(mIview!=null)
        {
            mIview=null;

        }
        if(mImodel!=null)
        {
            mImodel=null;

        }
    }
}
