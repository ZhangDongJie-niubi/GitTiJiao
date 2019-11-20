package com.example.mvp.presenter;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.constant.Constant;
import com.example.mvp.model.RetrofitRequestImpl;
import com.example.mvp.model.bean.RiBaoInfo;
import com.example.mvp.ui.fragment.RiBaoSubFragment;
import com.example.mvp.util.GsonUtil;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class RiBaoPresenter extends BasePresenter {
    private int mType;
    private RetrofitRequestImpl mRequest;
    private RiBaoSubFragment mHomeFragment;

    public RiBaoPresenter(RiBaoSubFragment mHomeFragment) {
        mRequest = new RetrofitRequestImpl();
        this.mHomeFragment = mHomeFragment;
    }

    @Override
    public void requestData() {

    }

    //P层从M层进行数据请求
    public void requestData(int type) {
        this.mType = type;
        switch (type) {
            //日报
            case 0:
                mHomeFragment.showLoading();
                mRequest.getData(Constant.RIBAO_URL, new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposeable(d);
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonStr = value.string();
                            GsonUtil gsonUtil = new GsonUtil();
                            Object object = gsonUtil.GsonParse(jsonStr, RiBaoInfo.class);
                            mHomeFragment.onScuessData(object);
                            mHomeFragment.dimisLoading();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        mHomeFragment.onFaileData(e.getMessage());
                        mHomeFragment.dimisLoading();
                    }

                    @Override
                    public void onComplete() {
                        mHomeFragment.dimisLoading();
                    }
                });
                break;

                //主題
            case 1:
               /* mRequest.getData(Constant.ZHUTI_URL, new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //添加网络开关(父类中的方法)
                        addDisposeable(d);
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonStr = value.string();
                            GsonUtil gsonUtil = new GsonUtil();
                            Object object = gsonUtil.GsonParse(jsonStr, ZhuTi.class);
                            mHomeFragment.onScuessData(object);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        mHomeFragment.onFaileData(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });*/
                break;

                //專欄
            case 2:
                break;

                //熱門
            case 3:
                break;


        }


    }

}
