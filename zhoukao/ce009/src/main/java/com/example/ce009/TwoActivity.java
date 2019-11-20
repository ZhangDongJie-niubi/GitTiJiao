package com.example.ce009;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jiehe.dao.Util;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Food food = new Food();
        for (int i = 0; i < 10; i++) {

            food.setName("张三");
            food.setDesc("Android高级");

        }
        food.setUrl("https://pic3.zhimg.com/v2-9d86658a561db2938adece187669ea42.jpg");
        food.setUrl("https://pic3.zhimg.com/v2-f1d5bc9f6ce17a0df85cfa4d595d9d86.jpg");
        food.setUrl(" https://pic2.zhimg.com/v2-ab7b9fe5bfad775aa9231abea1f1d53d.jpg");
        food.setUrl("https://pic3.zhimg.com/v2-f1d5bc9f6ce17a0df85cfa4d595d9d86.jpg");
        food.setUrl(" https://pic2.zhimg.com/v2-ab7b9fe5bfad775aa9231abea1f1d53d.jpg");
        food.setUrl("https://pic3.zhimg.com/v2-f1d5bc9f6ce17a0df85cfa4d595d9d86.jpg");
        food.setUrl("https://pic3.zhimg.com/v2-f1d5bc9f6ce17a0df85cfa4d595d9d86.jpg");
        food.setUrl("https://pic2.zhimg.com/v2-fddd768618d10492f73d7d460c7025c1.jpg");
        food.setUrl("https://pic3.zhimg.com/v2-f1d5bc9f6ce17a0df85cfa4d595d9d86.jpg");
        food.setUrl("https://pic2.zhimg.com/v2-fddd768618d10492f73d7d460c7025c1.jpg");
        Util.util().insert(food);




    }
}


//      https://pic3.zhimg.com/v2-f1d5bc9f6ce17a0df85cfa4d595d9d86.jpg
//      https://pic2.zhimg.com/v2-fddd768618d10492f73d7d460c7025c1.jpg
//      https://pic3.zhimg.com/v2-6d46fdeef22e28f1ac6e6d811bec9b22.jpg
//      https://pic2.zhimg.com/v2-ab7b9fe5bfad775aa9231abea1f1d53d.jpg
//      https://pic3.zhimg.com/v2-9d86658a561db2938adece187669ea42.jpg