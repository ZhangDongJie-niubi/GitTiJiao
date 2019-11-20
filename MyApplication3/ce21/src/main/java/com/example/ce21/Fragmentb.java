package com.example.ce21;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
public class Fragmentb extends Fragment {
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what==1){
                List<Food.DataBean> data = (List<Food.DataBean>) msg.obj;
                shi2.initData(data);
            }
            return false;
        }
    });
    private RecyclerView recy;
    private Shi2 shi2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentb, null);
        initView(inflate);
        add();
        return inflate;
    }
    private void initView(View inflate) {
        recy = inflate.findViewById(R.id.recycler);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        shi2 = new Shi2(getActivity());
        recy.setAdapter(shi2);

    }
    public void add(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        int len=0;
                        byte[]bytes=new byte[1024*4];
                        while((len = is.read(bytes))!=-1){
                            bos.write(bytes,0,len);
                        }
                        String s = bos.toString();
                        Gson gson = new Gson();
                        Food food = gson.fromJson(s, Food.class);
                        List<Food.DataBean> data = food.getData();
                        Message msg = new Message();
                        msg.obj=data;
                        msg.what=1;
                        handler.sendMessage(msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
