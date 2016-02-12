package cs.nizam.funeralrites;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by nizamcs on 5/2/16.
 * Initalize global objects here
 */
public class FuneralApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        AnalyticsTrackers.initialize(this);
    }
}
