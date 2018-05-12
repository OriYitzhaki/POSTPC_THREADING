package com.example.oriyitzhaki.postpc_threading.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.oriyitzhaki.postpc_threading.TaskFragment;
import com.example.oriyitzhaki.postpc_threading.counters.CounterTask;
import com.example.oriyitzhaki.postpc_threading.R;

abstract class TaskActivity extends AppCompatActivity{

    private static final String TAG_TASK_FRAGMENT = "Task Fragment";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        final FragmentManager fm = getSupportFragmentManager();

        if (fm.findFragmentByTag(TAG_TASK_FRAGMENT) == null){
            final TaskFragment fragment = TaskFragment.newInstance(getCounterTask());
            fm.beginTransaction().add(R.id.fragment_placeholder, fragment, TAG_TASK_FRAGMENT).commit();
        }
    }

    abstract protected CounterTask getCounterTask();
}
