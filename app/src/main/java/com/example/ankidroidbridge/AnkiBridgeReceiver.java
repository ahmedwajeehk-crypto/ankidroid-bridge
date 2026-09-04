package com.example.ankidroidbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ichi2.anki.api.AddContentApi;

import java.util.Map;

public class AnkiBridgeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            String front = intent.getStringExtra("front");
            String back = intent.getStringExtra("back");

            AddContentApi api = new AddContentApi(context);

            Map<Long, String> decks = api.getDeckList();
            Map<Long, String> models = api.getModelList();

            Long deckId = null;
            Long modelId = null;

            for (Map.Entry<Long, String> entry : decks.entrySet()) {
                if (entry.getValue().equalsIgnoreCase("Default")) {
                    deckId = entry.getKey();
                    break;
                }
            }

            for (Map.Entry<Long, String> entry : models.entrySet()) {
                if (entry.getValue().equalsIgnoreCase("Basic")) {
                    modelId = entry.getKey();
                    break;
                }
            }

            if (deckId == null || modelId == null) {
                return;
            }

            String[] fields = new String[]{
                    front,
                    back
            };

            api.addNote(
                    deckId,
                    modelId,
                    fields,
                    null
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
