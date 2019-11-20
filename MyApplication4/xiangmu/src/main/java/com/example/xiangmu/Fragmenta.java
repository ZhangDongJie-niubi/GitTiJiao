package com.example.xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Fragmenta extends Fragment {
    private XRecyclerView rv;
    private Shi shi;
    private  String lun="https://www.wanandroid.com/banner/json";
    private  String string1="https://wanandroid.com/article/listproject/0/json";
    private int string2=0;
    private String string3="/json";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case 1:
                   List<Food.DataBean.DatasBean> lll= (List<Food.DataBean.DatasBean>) msg.obj;
                   if (string2==0){
                   shi.add(lll);
                   rv.refreshComplete();
                   }else{
                    shi.add1(lll);
                    rv.loadMoreComplete();
                   }
                   break;
               case 2:
                   List<BannerBean.DataBean> bannerlist= (List<BannerBean.DataBean>) msg.obj;
                   shi.lun(bannerlist);
                   break;
           }
            super.handleMessage(msg);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.three, null);
        initView(inflate);
        initData();

        return inflate;
    }



    private void initView(final View inflate) {
        rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        shi = new Shi(getActivity());
        rv.setAdapter(shi);
        rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                string2=0;
                initData();
            }

            @Override
            public void onLoadMore() {
                string2++;
                initData();
            }
        });
                shi.setOnHomeItemClik(new Shi.OnHomeItemClik() {
            @Override
            public void clickItem(Food.DataBean.DatasBean datasBean) {
                String url = datasBean.getLink();
                Intent intent = new Intent(getActivity(),TwoActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }
    public String initurl(String ss) {

        try {
            URL url = new URL(ss);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024 * 4];
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            String s = bos.toString();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String initurl = initurl(string1 + string2 + string3);
                Gson gson = new Gson();
                Food food = gson.fromJson(initurl, Food.class);
                List<Food.DataBean.DatasBean> datas = food.getData().getDatas();
                Message msg = new Message();
                msg.obj=datas;
                msg.what=1;
                handler.sendMessage(msg);



                String initurl1 = initurl(lun);
                Gson gson1 = new Gson();
                BannerBean bannerBean = gson1.fromJson(initurl1, BannerBean.class);
                List<BannerBean.DataBean> data = bannerBean.getData();
                Message msg1 = new Message();
                msg1.obj=data;
                msg1.what=2;
                handler.sendMessage(msg1);
            }
        }).start();
    }


}
