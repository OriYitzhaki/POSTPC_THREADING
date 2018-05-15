package com.example.oriyitzhaki.postpc_threading.activities;

import com.example.oriyitzhaki.postpc_threading.counters.BaseCounterTask;
import com.example.oriyitzhaki.postpc_threading.counters.CounterThreadTask;

public class ThreadsActivity extends TaskActivity{
    @Override
    protected BaseCounterTask getCounterTask() {
        return new CounterThreadTask();
    }
}
