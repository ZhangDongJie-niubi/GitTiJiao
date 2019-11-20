package com.example.lianxi1234;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiehe.dao.Util;

import java.util.List;

public class Fragmentb extends Fragment {

    private List<Foods> cha;
    private LinearLayout lin;
    private Recycleadpter1 recycleadpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.five, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(final View inflate) {
        final RecyclerView rv = inflate.findViewById(R.id.rv2);
        rv.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        cha = Util.getutil().cha();
        recycleadpter = new Recycleadpter1(getContext());
        rv.setAdapter(recycleadpter);
        recycleadpter.jia(cha);


        recycleadpter.setOnLongClickListener(new Recycleadpter1.OnLongClickListener() {

            @Override
            public void onLongClickListener(final int position) {
                View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.six, null);
                lin = inflate1.findViewById(R.id.lin);
                Button but3 = inflate1.findViewById(R.id.but3);
                Button but4 = inflate1.findViewById(R.id.but4);
                final PopupWindow popupWindow = new PopupWindow(inflate1, ViewGroup.LayoutParams.MATCH_PARENT, 500);
                popupWindow.showAtLocation(lin, Gravity.CENTER, 0, 0);
                but3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        recycleadpter.shan(position);
                        popupWindow.dismiss();
                    }
                });
                but4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

            }
        });

    }
}
