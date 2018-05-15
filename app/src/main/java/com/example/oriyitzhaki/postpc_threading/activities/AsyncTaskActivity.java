package com.example.oriyitzhaki.postpc_threading.activities;

import com.example.oriyitzhaki.postpc_threading.counters.CounterAsyncTask;
import com.example.oriyitzhaki.postpc_threading.counters.BaseCounterTask;

public class AsyncTaskActivity extends TaskActivity {
    @Override
    protected BaseCounterTask getCounterTask() {
        return new CounterAsyncTask();
    }
}
