package com.example.zongheti;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

public class Fragmentb extends Fragment {
    private int a;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.ten, null);
        init(inflater);
        return inflate;
    }

    private void init(LayoutInflater inflater) {
        ListView lv = inflate.findViewById(R.id.lv);
        Shu shu = new Shu(getActivity(), "ku.db", null, 1);
        List<ShuL> cha = shu.cha();
        Shi2 shi2 = new Shi2(getActivity());
        shi2.setOnClickListener(new Shi2.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                a = i;
            }
        });
        Shi3 shi3 = new Shi3(getActivity(), cha);
        lv.setAdapter(shi3);
    }
}
