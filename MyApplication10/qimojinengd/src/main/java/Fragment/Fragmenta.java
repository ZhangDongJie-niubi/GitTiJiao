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

import com.example.qimojinengd.R;

import java.util.ArrayList;
import java.util.List;

import Adpter.RecycleAdpter;
import Util.Utils;
import bean.Food;
import bean.Foods;
import paeasta.Paeasta;
import view.Homeview;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.DataBean.DatasBean> arr;
    private RecycleAdpter recycleAdpter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fore, container, false);
        init(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        Paeasta paeasta = new Paeasta(this);
        paeasta.getData();

    }

    private void init(View inflate) {
        arr = new ArrayList<>();
        recycleAdpter = new RecycleAdpter(getActivity());
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleAdpter.add(arr);
        rv.setAdapter(recycleAdpter);
        recycleAdpter.setOnLongClickListener(new RecycleAdpter.OnLongClickListener() {
            @Override
            public void onLongClickListener(int i) {
                Food.DataBean.DatasBean datasBean = arr.get(i);
                String chapterName = datasBean.getChapterName();
                String envelopePic = datasBean.getEnvelopePic();
                String desc = datasBean.getDesc();

                Foods foods = new Foods();
                foods.setId(1);
                foods.setChapterName(chapterName);
                foods.setDesc(desc);

                Utils.getutils().insert(foods);
                Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void getcheng(final List<Food.DataBean.DatasBean> list) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                arr.addAll(list);
                recycleAdpter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getshibai(String shibai) {
        Toast.makeText(getActivity(), shibai, Toast.LENGTH_SHORT).show();
    }
}
