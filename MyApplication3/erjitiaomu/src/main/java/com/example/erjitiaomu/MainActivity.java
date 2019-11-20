package com.example.erjitiaomu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView elv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> teacher = new ArrayList<>();
        teacher.add("张东杰");
        teacher.add("泰山");
        teacher.add("王政");
        ArrayList<ArrayList<String>> student = new ArrayList<>();

        ArrayList<String> hao = new ArrayList<>();
        hao.add("潘可心");
        hao.add("李佩伟");
        ArrayList<String> zhong = new ArrayList<>();
        zhong.add("郑超");
        zhong.add("高佳");
        ArrayList<String> huai = new ArrayList<>();
        huai.add("李亚茹");
        huai.add("刘奇峰");

        student.add(hao);
        student.add(zhong);
        student.add(huai);
        initView();
        Shi shi = new Shi(this, teacher, student);
        elv.setAdapter(shi);

    }

    private void initView() {

        elv = findViewById(R.id.elv);
    }
}
