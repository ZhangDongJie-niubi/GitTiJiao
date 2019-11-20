package com.example.ce21_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragmenta extends Fragment {
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment, null, false);
        add(inflate);
        return inflate;
    }

    public void add(View inflate) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add("张东杰" + i);

        }
        ListView lv = inflate.findViewById(R.id.lv);
        Shi shi = new Shi(getActivity());
        lv.setAdapter(shi);
        shi.add(arr);

    }
}
