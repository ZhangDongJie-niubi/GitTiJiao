package com.example.mvp.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.adapter.RiBaoRvAdater;
import com.example.mvp.base.BaseApp;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.model.bean.RiBaoInfo;
import com.example.mvp.presenter.RiBaoPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

public class RiBaoSubFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {
    @Nullable
    @BindView(R.id.processbar12)
    ProgressBar processbar;
    @Nullable
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @Nullable
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    private int mType;
    private RiBaoPresenter mPresenter;
    private RiBaoRvAdater mAdater;


    public RiBaoSubFragment(int type) {
        this.mType = type;
    }

    @Override
    protected void init() {
        switch (mType) {
            //日报Fragment
            case 0:
                recyclerView.setLayoutManager(new LinearLayoutManager(BaseApp.getContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.addItemDecoration(new DividerItemDecoration(BaseApp.getContext(), LinearLayoutManager.VERTICAL));
                break;

            //主题
            case 1:

                break;

            //專欄
            case 2:

                break;
            //熱門
            case 3:

                break;

        }

    }

    @Override
    protected void initData() {
        //V层需要更新Ui的话需要向P层发送请求数据的通知(指令)
        mPresenter.requestData(mType);
    }

    @Override
    protected BasePresenter createPresenter() {
        mPresenter = new RiBaoPresenter(this);
        return mPresenter;
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
    protected void release() {
        if (mAdater != null)
            mAdater.unBind();
    }

    @Override
    public void showLoading() {
        processbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dimisLoading() {
        processbar.setVisibility(View.GONE);
    }

    @Override
    public void onScuessData(Object o) {
        if (o instanceof RiBaoInfo) {
            List<RiBaoInfo.TopStoriesBean> top_stories =
                    ((RiBaoInfo) o).getTop_stories();
            List<RiBaoInfo.StoriesBean> stories =
                    ((RiBaoInfo) o).getStories();

            Log.e("TAG", top_stories.size() + "=========" + stories.size());
            mAdater = new RiBaoRvAdater(getActivity(), top_stories, stories);
            recyclerView.setAdapter(mAdater);
            smartRefreshLayout.setOnRefreshListener(this);
            smartRefreshLayout.setOnLoadMoreListener(this);
        }
    }

    @Override
    public void onFaileData(String msg) {
        Log.e("TAG", msg);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.requestData(0);
        refreshLayout.finishRefresh(2000, true);

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        //页码加1 再网络请求
      /*  Constant.PAGE++;
        mPresenter.requestData(0);*/
        refreshLayout.finishLoadMore(2000, true, false);
    }
}
