package com.example.ankidroidbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnkiBridgeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String taxonomyId = intent.getStringExtra("taxonomy_id");

        Toast.makeText(
                context,
                "Bridge received taxonomy_id: " + taxonomyId,
                Toast.LENGTH_LONG
        ).show();
    }
}