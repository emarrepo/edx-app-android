package org.edx.mobile.shadows;

import android.os.AsyncTask;

import org.robolectric.android.util.concurrent.RoboExecutorService;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

/**
 * Shadow for {@link AsyncTask} to ensure that it runs on
 * the Robolectric background @{link org.robolectric.util.Scheduler}
 * to enable instrumentation.
 */
@Implements(AsyncTask.class)
@SuppressWarnings({"unused", "deprecation"})
public class ShadowAsyncTask<ResultT> {
    @RealObject
    private AsyncTask<Void, Void, ResultT> realSafeAsyncTask;

    public void __constructor__() {
        realSafeAsyncTask.executeOnExecutor(new RoboExecutorService());
    }
}
