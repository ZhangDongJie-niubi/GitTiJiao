package com.example.ce21_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragmenta extends Fragment {

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragmenta, container, false);
        con(inflate);
        return inflate;
    }

    public void con( View inflate) {

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add("張東傑" + i);
        }
        //Shi shi = new Shi(getActivity());

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, arr);
        ListView lv = inflate.findViewById(R.id.lv);
        lv.setAdapter(stringArrayAdapter);
      //  shi.add(arr);
    }

}
