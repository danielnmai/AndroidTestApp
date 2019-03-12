package com.example.androidtestapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.clover.sdk.v1.Intents;


public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(Intents.ACTION_V1_PAY_BUILD_START)) {
            Intent newIntent = new Intent(context, DisplayMessageActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(newIntent);

            Toast.makeText(context, "Hello?", Toast.LENGTH_LONG);

//            FullScreenDialog dialog = new FullScreenDialog();
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            dialog.show(ft, FullScreenDialog.TAG);
        }
    }

}
