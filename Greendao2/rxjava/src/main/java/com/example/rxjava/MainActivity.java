package com.example.rxjava;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Disposable subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button jiben = findViewById(R.id.jiben);
        Button lianshi = findViewById(R.id.lianshi);
        Button jiandan = findViewById(R.id.jiandan);
        Button shuzu = findViewById(R.id.shuzu);
        Button hebing = findViewById(R.id.hebing);
        Button fanwei = findViewById(R.id.fanwei);
        Button dingshi = findViewById(R.id.dingshi);
        Button shanping = findViewById(R.id.shanping);
        Button guolv = findViewById(R.id.guolv);
        Button map = findViewById(R.id.map);
        Button flatmap = findViewById(R.id.flatmap);
        Button zip = findViewById(R.id.zip);
        Button zhong = findViewById(R.id.zhong);
        zip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] a = {1, 2, 3, 4, 5};
                Integer[] b = {6, 7, 8, 9, 10};
                Observable<Integer> observable = Observable.fromArray(a);
                Observable<Integer> observable1 = Observable.fromArray(b);
                Observable.zip(observable, observable1, new BiFunction<Integer, Integer, String>() {
                    @Override
                    public String apply(Integer integer, Integer integer2) throws Exception {
                        return integer + "-" + integer2;
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("TAG", "收到观察者发送的事件" + s);
                    }
                });
            }
        });

        flatmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] a = {1, 2, 3, 4, 5};
                Observable.fromArray(a).flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        String[] strings = new String[3];
                        strings[0] = "s";
                        for (int i = 0; i < strings.length; i++) {
                            strings[i] = integer + strings[i];
                        }
                        return Observable.fromArray(strings);
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("TAG", "接收到观察者发送的事件" + s);
                    }
                });
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] a = {1, 2, 3, 4, 5};
                Observable.fromArray(a).map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return integer * 1000 + "1223";
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + s);
                    }
                });
            }
        });

        guolv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.fromArray(1, 2, 3, 4, 5, 6)
                        .filter(new Predicate<Integer>() {
                            @Override
                            public boolean test(Integer integer) throws Exception {
                                if (integer > 5) {
                                    return true;
                                }
                                return false;
                            }
                        }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + integer);
                    }
                });
            }
        });
        dingshi.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                subscribe = Observable.interval(1, 1, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + aLong);
                    }
                });
            }
        });

        fanwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.range(1, 4).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + integer);
                    }
                });
            }
        });
        hebing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] a = {1, 2, 3, 4, 5};
                Integer[] b = {6, 7, 8, 9, 10};
                Observable.just(a, b).subscribe(new Consumer<Integer[]>() {
                    @Override
                    public void accept(Integer[] integers) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + integers);
                    }
                });
            }
        });

        shuzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] a = {1, 2, 3, 4, 5};
                Observable.fromArray(a).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + integer);
                    }
                });
            }
        });
        jiandan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.just("a", "b", "b").subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("TAG", "收到被观察者发送的事件" + s);
                    }
                });
            }
        });

        lianshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("a");
                        emitter.onNext("b");
                        emitter.onNext("c");
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "订阅成功");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("TAG", "收到被观察者发送的事件" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "事件序列发生的异常" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "事件队列完结");
                    }
                });

            }
        });
        jiben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("a");
                        emitter.onNext("b");
                        emitter.onNext("c");
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "订阅成功");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("TAG", "收到被观察者发送的事件" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "事件序列发生的异常" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "事件队列完结");
                    }
                });
            }
        });
        zhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
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
                                Toast.makeText(MainActivity.this, value.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("TAG", e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
