package com.example.ce3_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fragmenta extends Fragment {
    private int a;
    private View inflate;

    private Shi1 shi1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.five, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv);
        shi1 = new Shi1(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        shi1.setOnClickListener(new Shi1.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                a = i;
            }
        });
        rv.setAdapter(shi1);
        add();
    }

    private void add() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> responseBodyCall = apiServer.get(arr);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    List<Food.DataBean> data = food.getData();
                    shi1.add(data);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
