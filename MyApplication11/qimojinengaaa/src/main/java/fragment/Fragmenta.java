package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimojinengaaa.R;

import java.util.ArrayList;
import java.util.List;

import adpter.Recycleadpter;
import bean.Food;
import paesta.Paesta;
import view.Homeview;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.DataBean.DatasBean> arr;
    private Recycleadpter recycleadpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        arr = new ArrayList<>();
        recycleadpter = new Recycleadpter(arr, getContext());
        Paesta paesta = new Paesta(this);
        paesta.getData();
        rv.setAdapter(recycleadpter);

    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleadpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
