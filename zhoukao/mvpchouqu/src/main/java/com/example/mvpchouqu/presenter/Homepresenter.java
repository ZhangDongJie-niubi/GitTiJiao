package com.example.mvpchouqu.presenter;

import com.example.mvpchouqu.base.BasePresenter;
import com.example.mvpchouqu.bean.FuliInfo;
import com.example.mvpchouqu.constant.Constant;
import com.example.mvpchouqu.fragment.HomeFragment;
import com.example.mvpchouqu.model.RetrofitRequestImpl;
import com.example.mvpchouqu.util.GsonUtil;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class Homepresenter extends BasePresenter {
    private int mType;
    private RetrofitRequestImpl mRequest;
    private HomeFragment mHomeFragment;

    public Homepresenter(HomeFragment mHomeFragment) {
        mRequest = new RetrofitRequestImpl();
        this.mHomeFragment = mHomeFragment;
    }

    @Override
    public void requestData() {

    }

    public void requestData(int type) {
        this.mType = type;
        switch (type) {
            case 0:
                mHomeFragment.showLoading();
                mRequest.getData(Constant.FULI_URL, new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposavle(d);
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            GsonUtil gsonUtil = new GsonUtil();
                            Object gsonparse = gsonUtil.Gsonparse(string, FuliInfo.class);
                            mHomeFragment.onScuessData(gsonparse);
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
        }
    }
}
