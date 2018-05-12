package com.example.oriyitzhaki.postpc_threading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.oriyitzhaki.postpc_threading.activities.AsyncTaskActivity;
import com.example.oriyitzhaki.postpc_threading.activities.ThreadsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openAsyncTaskActivity(View view){
        startActivity(new Intent(this,AsyncTaskActivity.class));
    }

    public void openThreadsActivity(View view) {
        startActivity(new Intent(this,ThreadsActivity.class));
    }
}
