package com.example.ankidroidbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AnkiBridgeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String taxonomyId = intent.getStringExtra("taxonomy_id");

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

            String message =
                    "Anki access SUCCESS. Models found: " + count
                    + " | taxonomy_id=" + taxonomyId;

            Log.e("ANKI_BRIDGE", message);
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        } catch (Exception e) {

            String message = "ANKI ERROR: " + e.toString();

            Log.e("ANKI_BRIDGE", message);
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
