package com.helli5.test_tiles;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;

public class MainMenu extends Activity {
	final String colorStr[] = {"#D2527F", "#52D3B9", "#2ECC71", "#913D88", "#F27935"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		Random r = new Random();
		Button Start = (Button)findViewById(R.id.Play);
		Button Ins = (Button)findViewById(R.id.ins);
		Button Quit = (Button)findViewById(R.id.leave);
		Button About = (Button)findViewById(R.id.about);
		Start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this,MainActivity.class);
	        	startActivity(intent);
			}
		});
		Ins.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this,Manual.class);
	        	startActivity(intent);
	        	finish();
			}
		});
		About.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Intent intent = new Intent(MainMenu.this,Aboutus.class);
	        	//startActivity(intent);
	        	finish();
			}
		});
		Quit.setOnClickListener(new OnClickListener() {
			
			@Override
		public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
