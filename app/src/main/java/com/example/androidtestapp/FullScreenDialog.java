package com.example.androidtestapp;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.clover.sdk.v1.Intents;
import android.support.v4.app.FragmentTransaction;


public class FullScreenDialog extends DialogFragment {
    public static String TAG = "FullScreenDialog";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.layout_full_screen_dialog, container, false);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver,
                new IntentFilter(Intents.ACTION_V1_PAY_BUILD_START));

        Toolbar toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
//        toolbar.setNavigationOnClickListener(view1 -> cancelUpload());
        toolbar.setTitle("My Dialog");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();

            if(action.equals(Intents.ACTION_V1_PAY_BUILD_START)) {
                FullScreenDialog dialog = new FullScreenDialog();
                Toast.makeText(context, "Hello?", Toast.LENGTH_LONG);
//                FragmentTransaction ft = FragmentActivity..beginTransaction();
//                dialog.show(ft, FullScreenDialog.TAG);
            }
        }
    };

}
