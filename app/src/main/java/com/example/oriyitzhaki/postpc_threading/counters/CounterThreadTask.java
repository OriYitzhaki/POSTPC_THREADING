package com.example.oriyitzhaki.postpc_threading.counters;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class CounterThreadTask extends CounterTask  implements Runnable {
    private static final String HANDLER_PROGRESS_MSG_KEY = "message";

    private Handler handler;
    private Thread thread;

    @Override
    public void create() {
        thread = new Thread(this);
        handler = new android.os.Handler(Looper.getMainLooper()) {
            /**
             * Runs on main/UI thread - invokes listener with ongoing progress.
             * @param msg Message containing a progress update sent from the background thread at {@link Runnable#run()}.
             */
            @Override
            public void handleMessage(Message msg) {
                listener.onProgressUpdate(msg.getData().getInt(HANDLER_PROGRESS_MSG_KEY));
            }
        };
    }

    @Override
    public void start() {
        thread.start();
    }

    @Override
    public void cancel() {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_PROGRESS; ++i) {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

            final Message msg = handler.obtainMessage();
            final Bundle bundle = new Bundle();
            bundle.putInt(HANDLER_PROGRESS_MSG_KEY, i);
            msg.setData(bundle);
            handler.sendMessage(msg);
        }
    }
}
