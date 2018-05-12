package com.example.oriyitzhaki.postpc_threading.activities;

import com.example.oriyitzhaki.postpc_threading.counters.CounterAsyncTask;
import com.example.oriyitzhaki.postpc_threading.counters.CounterTask;

public class AsyncTaskActivity extends TaskActivity {
    @Override
    protected CounterTask getCounterTask() {
        return new CounterAsyncTask();
    }
}
