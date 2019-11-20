package com.example.ce21;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragmenta extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmenta, null, false);
        add(inflate);
        return inflate;


    }
    public void add(final View inflate){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i <20 ; i++) {
                    list.add("标题标题标题标题");
                }
                Shi shi = new Shi(list, getActivity());
                View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragmenta, null);
                ListView lv = inflate.findViewById(R.id.lv);
                lv.setAdapter(shi);
            }
        }).start();

    }

}
