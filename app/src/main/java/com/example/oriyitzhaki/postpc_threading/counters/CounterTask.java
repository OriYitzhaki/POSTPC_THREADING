package com.example.oriyitzhaki.postpc_threading.counters;

import com.example.oriyitzhaki.postpc_threading.TaskFragment;

abstract public class CounterTask {

    public static final int MAX_PROGRESS = 10;
    static final int SLEEP_DURATION = 500;

    OnProgressUpdateListener listener;

    public void setOnProgressUpdateListener(OnProgressUpdateListener onProgressUpdateListener){
        this.listener = onProgressUpdateListener;
    }

    public abstract void cancel();

    public abstract void start();

    public abstract void create();

    public interface OnProgressUpdateListener {
        void onProgressUpdate(int progress);
    }
}
