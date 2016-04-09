package com.ekeitho.midpoint.gcm;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by ekeitho on 4/9/16.
 */
public class MyGcmListenerService extends GcmListenerService {

    @Override
    public void onMessageReceived(String from, Bundle data) {
        Log.e("HAHA", "RECEIVED!!!!");
        super.onMessageReceived(from, data);
    }
}
