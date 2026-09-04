package com.example.ankidroidbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AnkiBridgeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String taxonomyId = intent.getStringExtra("taxonomy_id");

        Log.e(
            "ANKI_BRIDGE",
            "RECEIVED taxonomy_id=" + taxonomyId
        );

        Intent reply = new Intent("com.example.ankidroidbridge.REPLY");
        reply.setPackage("com.arlosoft.macrodroid");
        reply.putExtra("taxonomy_id", taxonomyId);
        context.sendBroadcast(reply);
    }
}
