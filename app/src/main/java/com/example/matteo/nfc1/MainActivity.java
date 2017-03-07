package com.example.matteo.nfc1;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected NfcAdapter nfcAdapter;

    PendingIntent pendingIntent;
    IntentFilter[] intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        /**
         * Check if nfc is setted on and return a toast with the antenna status
         */

        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            Toast.makeText(this, "NFC availble", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "NFC not availble", Toast.LENGTH_LONG).show();
            finish();
        }


    }


    /**
     * When the tag is near to the NFC antenna a new intent is created and the app catch it.
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        Toast.makeText(this, "NFC intent received", Toast.LENGTH_LONG).show();
        super.onNewIntent(intent);
    }

    /**
     * Thanks to this method when the app is resumed is not created again but we use the last
     * "istance"
     */

    @Override
    protected void onResume() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        intentFilter = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter , null);

        super.onResume();
    }

    
    @Override
    protected void onPause() {
        nfcAdapter.disableForegroundDispatch(this);


        super.onPause();
    }
}
