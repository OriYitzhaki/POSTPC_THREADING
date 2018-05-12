package com.example.oriyitzhaki.postpc_threading.activities;

import com.example.oriyitzhaki.postpc_threading.counters.CounterTask;
import com.example.oriyitzhaki.postpc_threading.counters.CounterThreadTask;

public class ThreadsActivity extends TaskActivity{
    @Override
    protected CounterTask getCounterTask() {
        return new CounterThreadTask();
    }
}
