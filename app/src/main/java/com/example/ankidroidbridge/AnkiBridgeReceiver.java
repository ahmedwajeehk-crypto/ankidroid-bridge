package com.example.ankidroidbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

public class AnkiBridgeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String taxonomyId = intent.getStringExtra("taxonomy_id");

        String status;
        String details;

        try {
            Uri modelsUri =
                    Uri.parse("content://com.ichi2.anki.flashcards/models");

            Cursor cursor = context.getContentResolver().query(
                    modelsUri,
                    null,
                    null,
                    null,
                    null
            );

            int count = 0;

            if (cursor != null) {
                count = cursor.getCount();
                cursor.close();
            }

            status = "success";
            details = "Models found: " + count;

        } catch (Exception e) {
            status = "error";
            details = e.toString();
        }

        Intent reply = new Intent(
                "com.example.ankidroidbridge.ANKI_RESULT"
        );

        reply.setPackage("com.arlosoft.macrodroid");

        reply.putExtra("taxonomy_id", taxonomyId);
        reply.putExtra("status", status);
        reply.putExtra("details", details);

        context.sendBroadcast(reply);
    }
}
