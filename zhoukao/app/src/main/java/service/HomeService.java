package service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.zhoukao.R;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import api.Apiserver;
import bean.EvenMeg;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeService extends Service {
    private String url = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";
    private long a;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        View inflate = LayoutInflater.from(HomeService.this).inflate(R.layout.activity_main, null);
        //獲取控件
        EditText et = inflate.findViewById(R.id.et);


   //  用Retrofit+RxJava的方式请求
        Retrofit build2 = new Retrofit.Builder()
                .baseUrl(Apiserver.string)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<ResponseBody> requestBodyObservable = build2.create(Apiserver.class).get();

        requestBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(ResponseBody value) {
                        //获取数据
                        InputStream inputStrea = value.byteStream();
                        long ll = value.contentLength();
                        //构造方法
//                        saveFile(inputStream, l, Environment.getExternalStorageDirectory() + "/d.apk");
                }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        OkHttpClient build = new OkHttpClient.Builder().build();
        Request build1 = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = build.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                InputStream inputStream = body.byteStream();
                long l = body.contentLength();
                saveFile(inputStream, l, Environment.getExternalStorageDirectory() + "/d.apk");
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    private void saveFile(InputStream inputStream, long l, String s) {

        try {
            //定义
            int len = -1;
            byte[] bytes = new byte[1024 * 20];
            a = 0;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(s));
            //循环发送数据
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                a += len;
                EventBus.getDefault().postSticky(new EvenMeg(l, a));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
