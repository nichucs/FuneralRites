package cs.nizam.funeralrites;

import android.app.Application;

/**
 * Created by nizamcs on 5/2/16.
 */
public class FuneralApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AnalyticsTrackers.initialize(this);
    }
}
