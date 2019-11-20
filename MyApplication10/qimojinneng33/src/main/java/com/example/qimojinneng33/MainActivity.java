package com.example.qimojinneng33;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

    private RecyclerView rv;
    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout dl = findViewById(R.id.dl);
        final LinearLayout ll = findViewById(R.id.ll);
        final NavigationView nv = findViewById(R.id.nv);
        rv = findViewById(R.id.rv);
        Toolbar tb = findViewById(R.id.tb);

        tb.setTitle("Toolbar");
        setSupportActionBar(tb);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        View headerView = nv.getHeaderView(0);
        iv2 = headerView.findViewById(R.id.iv2);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                int right = nv.getRight();
                ll.setX(right);
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "线性布局");
        menu.add(1, 2, 1, "网格布局");
        menu.add(1, 3, 1, "瀑布流");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Retrofit build = new Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(ApiServer.url)
                        .build();
                ApiServer apiServer = build.create(ApiServer.class);
                Observable<Food> foodObservable = apiServer.get();
                foodObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Food>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Food value) {
                                List<Food.ResultsBean> results = value.getResults();
                                Shi shi = new Shi(results, MainActivity.this);
                                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                rv.setAdapter(shi);
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
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(ApiServer.url)
                        .build();
                ApiServer apiServer1 = build1.create(ApiServer.class);
                Observable<Food> foodObservable1 = apiServer1.get();
                foodObservable1.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Food>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Food value) {
                                List<Food.ResultsBean> results = value.getResults();
                                Shi shi = new Shi(results, MainActivity.this);
                                rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                                rv.setAdapter(shi);
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
                        .baseUrl(ApiServer.url)
                        .build();
                ApiServer apiServer2 = build2.create(ApiServer.class);
                Observable<Food> foodObservable2 = apiServer2.get();
                foodObservable2.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Food>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Food value) {
                                List<Food.ResultsBean> results = value.getResults();
                                Shi shi = new Shi(results, MainActivity.this);
                                rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                                rv.setAdapter(shi);
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

    private OkHttpClient getok() {
        return new OkHttpClient.Builder()
                .cache(new Cache(new File(getCacheDir(), "Cache"), 1024 * 1024 * 10))
                .build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            Uri data1 = data.getData();
            iv2.setImageURI(data1);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}