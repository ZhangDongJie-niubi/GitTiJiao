package com.example.ce23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class TwoActivity extends AppCompatActivity {
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Food food = new Food();
        List<Food> querry = Util.getUtil().querry(food);
        Log.e("TAG", querry.get(a).getSex());
        Shi shi = new Shi(TwoActivity.this, querry);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(TwoActivity.this));
        rv.setAdapter(shi);
    }
}
