package com.example.qimojinengdd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qimojinengdd.dao.Util;

import java.util.List;

public class Fragmentb extends Fragment {

    private TextView tv3;
    private List<Foods> cha;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.six, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            tv3.setText(cha + "");
        } else {
            if (cha.size() > 0 && cha != null){
                cha.clear();
            }
        }
    }

    private void initView(View inflate) {
        tv3 = inflate.findViewById(R.id.tv3);
        cha = Util.util().cha();

    }
}
