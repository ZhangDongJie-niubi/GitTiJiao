package com.example.mvpchouqu.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.example.mvpchouqu.base.BaseFragment;
import com.example.mvpchouqu.base.BasePresenter;
import com.example.mvpchouqu.R;
import com.example.mvpchouqu.bean.FuliInfo;
import com.example.mvpchouqu.presenter.Homepresenter;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @Nullable
    @BindView(R.id.processbar12)
    ProgressBar progressBar;
    private int mType;
    private Homepresenter mpresenter;

    public HomeFragment(int mType) {
        this.mType = mType;
    }


    @Override
    protected void initData() {
        //V层需要更新Ui的话需要向P层发送请求数据的通知(指令)
        mpresenter.requestData(mType);
    }

    @Override
    protected BasePresenter CreatePresenter() {
        mpresenter = new Homepresenter(this);
        return mpresenter;
    }

    @Override
    protected int setLayout() {
        switch (mType) {
            case 0:
                return R.layout.fragment_ribao;
            case 1:
                return R.layout.fragment_zhuti;
            case 2:
                return R.layout.fragment_zhuanlan;
            case 3:
                return R.layout.fragment_remen;
        }
        return 0;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void dimisLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onScuessData(Object o) {
        if (o instanceof FuliInfo) {
            List<FuliInfo.ResultsBean> results = ((FuliInfo) o).getResults();
            for (FuliInfo.ResultsBean resultsBean : results) {
                String url = resultsBean.getUrl();
                Log.e("TAG", url + "==========");
            }
        }
    }

    @Override
    public void onFaileData(String msg) {
        Log.e("Tag", msg);
    }
}
