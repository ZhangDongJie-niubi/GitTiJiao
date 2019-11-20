package Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qimojinenge.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import Adpter.RecycleAdpter;
import bean.Food;
import paeasta.Paeasta;
import view.Homeview;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.DataBean.DatasBean> arr;
    private RecycleAdpter recycleAdpter;
    private RecyclerView rv;
    private SmartRefreshLayout sl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.three, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        Paeasta paeasta = new Paeasta(this);
        paeasta.getData();
    }

    private void initView(View inflate) {
        arr = new ArrayList<>();
        recycleAdpter = new RecycleAdpter(arr, getActivity());
        rv = inflate.findViewById(R.id.rv);
        sl = inflate.findViewById(R.id.sl);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(recycleAdpter);
        sl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                initDate();
                sl.finishLoadMore();
                recycleAdpter.notifyDataSetChanged();
            }
        });
        sl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                arr.clear();
                initDate();
                sl.finishRefresh();
                recycleAdpter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleAdpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {
        Toast.makeText(getActivity(), shibai, Toast.LENGTH_SHORT).show();
    }
}
