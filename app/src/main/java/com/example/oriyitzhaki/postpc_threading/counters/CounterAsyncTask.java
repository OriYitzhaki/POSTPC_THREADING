package com.example.oriyitzhaki.postpc_threading.counters;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class CounterAsyncTask extends BaseCounterTask {
    private InnerCounterTask asyncTask;

    @Override
    public void create() {
        asyncTask = new InnerCounterTask(listener);
    }

    @Override
    public void start() {
        asyncTask.execute();
    }

    @Override
    public void cancel() {
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
    }

    private static final class InnerCounterTask extends AsyncTask<Void, Integer, Void> {
        private final OnProgressUpdateListener listener;

        private InnerCounterTask(OnProgressUpdateListener listener) {
            this.listener = listener;
        }

        @Nullable
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= MAX_PROGRESS; ++i) {
                try {
                    Thread.sleep(SLEEP_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }

                publishProgress(i);
            }

            return null;
        }

        /**
         * Runs on main/UI thread - invokes listener with ongoing progress.
         * @param progress Progress published from doInBackground.
         */
        @Override
        protected void onProgressUpdate(@NonNull Integer... progress) {
            listener.onProgressUpdate(progress[0]);
        }
    }

}
