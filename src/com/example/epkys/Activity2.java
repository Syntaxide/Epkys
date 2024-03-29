package com.example.epkys;

import android.support.v7.app.ActionBarActivity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Activity2 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		NfcAdapter nfc = NfcAdapter.getDefaultAdapter(this);
    	if(nfc == null)
    		Log.i("main", "unable to use nfc");
    	NdefRecord record = NdefRecord.createExternal(NFC_SERVICE, KEYGUARD_SERVICE, "hello".getBytes());
    	NdefMessage message = new NdefMessage(new NdefRecord[]{record});
    	nfc.setNdefPushMessage(message, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
