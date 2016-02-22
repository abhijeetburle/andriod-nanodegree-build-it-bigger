import android.content.Context;
import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.udacity.gradle.builditbigger.service.GecBackendEndpointAsynTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by abhijeet.burle on 2016/02/22.
 */
public class GecBackendEndpointAsynTaskTest extends InstrumentationTestCase {
    private final String LOG_TAG = GecBackendEndpointAsynTaskTest.class.getSimpleName();

    public final void testDoInBackground() throws Throwable {
        Log.v(LOG_TAG, "testDoInBackground: Start");

        // Variable to hold the result data
        final String[] jokeTold = {""};
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);
        final Context context = getInstrumentation().getTargetContext();

        final AsyncTask<Context, Void, String> myTask = new GecBackendEndpointAsynTask() {
            @Override
            protected void onPostExecute(String result) {
                jokeTold[0] = result;
                signal.countDown();

            }
        };

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                myTask.execute(context);
            }
        });
        signal.await(30, TimeUnit.SECONDS);

        assertTrue(
                " Failed to fetch joke using GecBackendEndpointAsynTask",
                jokeTold[0] != null && jokeTold[0].length() > 0);

        Log.v(LOG_TAG, "testDoInBackground: End");
    }
}
