package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.appunity.util.Contexts;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textView);

        Log.d(TAG, "onClick() called with: v = []");
        Context context = Contexts.getContext();
        Log.d(TAG, "Contexts.getContext(): " + context);
        textView.setText(context.getClass().getName());
        /*Observable.just(1)
                .subscribeOn(Schedulers.io())
                .map(new Func1<Integer, Object>() {
                    @Override
                    public Object call(Integer integer) {
                        Log.d(TAG, "call() called with: o = []" + Thread.currentThread());
                        Log.d(TAG, "onClick() called with: v = []");
                        Context context = Contexts.getContext();
                        Log.d(TAG, "onCreate: " + context);
                        return context;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {

                        textView.setText(o.getClass().getName());
                        Log.d(TAG, "call() called with: o = [" + o + "]");
                    }
                });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                NetdiskApi netdiskApi = Retrofits.create(NetdiskApi.class);
//                Observable<ResponseBody> observable = netdiskApi.getBaidu();
//                observable.compose(DialogUtils.applySchedulers())
////                        .compose(DialogUtils.applyDialog(getContext()))
//                        .subscribe(inspect -> {
//                            System.out.println(inspect);
//                        });

                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .map(new Func1<Integer, Object>() {
                            @Override
                            public Object call(Integer integer) {
                                Log.d(TAG, "call() called with: o = []" + Thread.currentThread());
                                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                                Context context = Contexts.getContext();
                                Log.d(TAG, "onCreate: " + context);
                                return context;
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Object>() {
                            @Override
                            public void call(Object o) {

                                textView.setText(o.getClass().getName());
                            }
                        });

                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .map(new Func1<Integer, Object>() {
                            @Override
                            public Object call(Integer integer) {
                                Log.d(TAG, "call() called with: o = []" + Thread.currentThread());
                                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                                Context context = Contexts.getContext();
                                Context context2 = Contexts.getContext();
                                Log.d(TAG, "onCreate: " + context);
                                return context;
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Object>() {
                            @Override
                            public void call(Object o) {

                                textView.setText(o.getClass().getName());
                            }
                        });
            }
        });*/
    }

    private Activity getContext() {
        return this;
    }
}
