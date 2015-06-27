package edu.weber.cs3270.scotthadzik.kidtrackapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by Scott
 */
public class KidTrackApp  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "APPLICATION_ID_GOES_HERE", "CLIENT_KEY_GOES_HERE");

        ParseACL defaultACL = new ParseACL();

        ParseACL.setDefaultACL(defaultACL, true);
        Parse.initialize(this, "tMlGtf3HRrw0U0EsSHz6J8PEDwFLRpX3S0ISb5lX", "biCFAGWm7ztYBC9paMF1tiuk74L6o6doGNtfUqo3");

    }

}
