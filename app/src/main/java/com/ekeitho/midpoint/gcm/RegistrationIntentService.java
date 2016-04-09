package com.ekeitho.midpoint.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.ekeitho.midpoint.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

/**
 * Created by ekeitho on 4/9/16.
 */
public class RegistrationIntentService extends IntentService {
    private static final String TAG = "RegIntentService";

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    public void getC(String token) {
         MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, "{'token': '" + token + "'}");
        Request request = new Request.Builder()
                .url("http://104.197.199.205:3456/register")
                .post(new FormEncodingBuilder().add("token", token).build())
                .build();

        try {
            // this stores it on firebase
            com.squareup.okhttp.Response response = client.newCall(request).execute();
        } catch (IOException e) {
            Log.e(TAG, "getC: " + e);
        }

        return;
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        String token = "";
        try {
            InstanceID instanceID = InstanceID.getInstance(this);
            token = instanceID.getToken(getString(R.string.sender_id),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            //curl 10.30.13:3000/create/events
            //send tokenid
            Log.e(TAG, "OMG");

            getC(token);

            Log.d(TAG, "onHandleIntent: " + token);
        } catch (Exception e) {

        }
    }
}
