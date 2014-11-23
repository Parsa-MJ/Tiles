package com.helli5.test_tiles;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Manual extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manual);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manual, menu);
		return true;
	}

}
