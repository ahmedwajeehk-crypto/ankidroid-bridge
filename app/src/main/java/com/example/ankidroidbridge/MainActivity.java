package com.example.ankidroidbridge;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final int REQ_ANKI_PERMISSION = 1001;
    private static final String ANKI_PERMISSION =
            "com.ichi2.anki.permission.READ_WRITE_DATABASE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkSelfPermission(ANKI_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[]{ANKI_PERMISSION},
                    REQ_ANKI_PERMISSION
            );
        }
    }
}
