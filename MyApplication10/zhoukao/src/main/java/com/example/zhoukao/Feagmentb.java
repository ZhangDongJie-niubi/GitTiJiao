package com.example.zhoukao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Feagmentb extends Fragment {
    private int a;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fore, null);
        init(inflate);
        return inflate;

    }

    private void init(View inflate) {
//        ImageView iv1 = inflate.findViewById(R.id.iv1);
//        TextView tv2 = inflate.findViewById(R.id.tv2);
//        TextView tv3 = inflate.findViewById(R.id.tv3);
//        Shu shu = new Shu(getActivity(), "ku.db", null, 1);
//        List<ShuL> cha = shu.cha();
//        Shi shi = new Shi(getActivity());
//        shi.setOnLongClickListener(new Shi.OnLongClickListener() {
//            @Override
//            public void onLongClickListener(int i) {
//                a = i;
//            }
//        });
//        ShuL shuL = cha.get(a);
//        String title = shuL.getTitle();
//        String collect_num = shuL.getCollect_num();
//        String pic = shuL.getPic();
//        Glide.with(getActivity()).load(pic).into(iv1);
//        tv2.setText(title);
//        tv3.setText(collect_num);
    }

}
