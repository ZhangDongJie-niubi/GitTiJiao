package com.example.qimojineng03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout dl = findViewById(R.id.dl);
        Toolbar tl = findViewById(R.id.tl);
        tl.setTitle("ToolBar");
        setSupportActionBar(tl);

        rv = findViewById(R.id.rv);
        NavigationView nv = findViewById(R.id.nv);

        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(MainActivity.this, dl, tl, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();

        View headerView = nv.getHeaderView(0);
        iv = headerView.findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "綫性佈局");
        menu.add(1, 2, 1, "網格佈局");
        menu.add(1, 3, 1, "瀑布流");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Retrofit build = new Retrofit.Builder()
                        .client(getok())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(Apiserver.url)
                        .build();
                Apiserver apiserver = build.create(Apiserver.class);
                Observable<Food> foodObservable = apiserver.get();
                foodObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Food>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Food value) {
                                List<Food.ResultsBean> results = value.getResults();

                                for (int i = 0; i < results.size(); i++) {
                                    Foods foods = new Foods();
                                    Food.ResultsBean resultsBean = results.get(i);
                                    String url = resultsBean.getUrl();
                                    foods.setUrl(url);
                                    Util.getUtil().isHash(foods);
                                }

                                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                Recycleviewapter recycleviewapter = new Recycleviewapter(results, MainActivity.this);
                                rv.setAdapter(recycleviewapter);
                                recycleviewapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


                break;
            case 2:
                Retrofit build1 = new Retrofit.Builder()
                        .client(getok())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(Apiserver.url)
                        .build();
                Apiserver apiserver1 = build1.create(Apiserver.class);
                Observable<Food> foodObservable1 = apiserver1.get();
                foodObservable1.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Food>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Food value) {
                                rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                                Recycleviewapter recycleviewapter = new Recycleviewapter(value.getResults(), MainActivity.this);
                                rv.setAdapter(recycleviewapter);
                                recycleviewapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
            case 3:
                Retrofit build2 = new Retrofit.Builder()
                        .client(getok())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(Apiserver.url)
                        .build();
                Apiserver apiserver2 = build2.create(Apiserver.class);
                Observable<Food> foodObservable2 = apiserver2.get();
                foodObservable2.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Food>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Food value) {
                                rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                                Recycleviewapter recycleviewapter = new Recycleviewapter(value.getResults(), MainActivity.this);
                                rv.setAdapter(recycleviewapter);
                                recycleviewapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            Uri data1 = data.getData();
            iv.setImageURI(data1);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private OkHttpClient getok() {
        return new OkHttpClient.Builder()
                .cache(new Cache(new File(getCacheDir(), "Chche"), 1024 * 1024 * 10))
                .build();
    }
}
