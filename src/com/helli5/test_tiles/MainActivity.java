package com.helli5.test_tiles;

import java.util.Random;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	final String colorStr[] = {"#D2527F", "#52D3B9", "#2ECC71", "#913D88", "#F27935"};
	int rndColor;
	ProgressBar mprogress;
	int mProgressStatus = 100;
	TextView score;
	Button btns[] = new Button[25];
	final Random r = new Random();
	int score_int = 0;
	final int colorCounts[] = { 0, 0, 0, 0, 0};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		score = (TextView)findViewById(R.id.score);
		BtnListener Listener = new BtnListener();
		mprogress = (ProgressBar)findViewById(R.id.progressBar1);
		final Button want = (Button)findViewById(R.id.wanted);
//        txt.startAnimation(hyperspaceJumpAnimation);
		final GradientDrawable wShape = (GradientDrawable)want.getBackground();
		wShape.setColor(Color.parseColor(colorStr[r.nextInt(5)]));
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				int btnId = getResources().getIdentifier(
					"b" + Integer.toString(i+1) + Integer.toString(j+1),
					"id",
					getPackageName());
				btns[i*5+j] = (Button)findViewById(btnId);
				btns[i*5+j].setOnClickListener(Listener);
			}
		}
		for (int k = 0; k <= 24; k++)
		{
			while(true){					
				rndColor = r.nextInt(5);
				if(colorCounts[rndColor] < 5){
					colorCounts[rndColor] += 1;
					GradientDrawable shape = (GradientDrawable)btns[k].getBackground();
					btns[k].setTag(colorStr[rndColor]);
					shape.setColor(Color.parseColor(colorStr[rndColor]));
					break;
				}
			}
		}
		new CountDownTimer(50000, 1000) {     
			//final Random r = new Random();
			final GradientDrawable shape = (GradientDrawable)want.getBackground();
			   public void onTick(long millisUntilFinished) { 
				   mProgressStatus -= 100/50;
				   mprogress.setProgress(mProgressStatus);
//				   Toast.makeText(getApplicationContext(), Long.toString(millisUntilFinished/1000),
//						   Toast.LENGTH_SHORT).show();
			       if((millisUntilFinished/1000)%5==0){
			    	   int temp = wantColor();
			    	   shape.setColor(Color.parseColor(colorStr[temp]));
			    	   want.setTag(colorStr[temp]);
			        }
			   }

				public void onFinish() {
					mprogress.setProgress(0);
					new AlertDialog.Builder(MainActivity.this)
				    .setTitle("Game Over")
				    .setMessage("امتباز شما: " + Integer.toString(score_int) + "   مایلید دوباره بازی کنید؟")
				    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				        	Intent intent = new Intent(MainActivity.this,MainActivity.class);
				        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				        	startActivity(intent);
				        	finish();
				        }
				     })
				    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				        	Intent intent = new Intent(MainActivity.this,MainMenu.class);
				        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				        	startActivity(intent);
				        	finish();
				        }
				     })
				    .setIcon(android.R.drawable.ic_dialog_alert)
				     .show();
			}}.start();
	}
	
	public class BtnListener implements OnClickListener{
		public void onClick(View v) {
//			Log.d("MAINTAG","here");
			switch(v.getId()){
				case R.id.b11:if (check(1,1)){game(1,1);}
				break;
				case R.id.b12:if (check(1,2)){game(1,2);}
				break;
				case R.id.b13:if (check(1,3)){game(1,3);}
				break;
				case R.id.b14:if (check(1,4)){game(1,4);}
				break;
				case R.id.b15:if (check(1,5)){game(1,5);}
				break;
				case R.id.b21:if (check(2,1)){game(2,1);}
				break;
				case R.id.b22:if (check(2,2)){game(2,2);}
				break;
				case R.id.b23:if (check(2,3)){game(2,3);}
				break;
				case R.id.b24:if (check(2,4)){game(2,4);}
				break;
				case R.id.b25:if (check(2,5)){game(2,5);}
				break;
				case R.id.b31:if (check(3,1)){game(3,1);}
				break;
				case R.id.b32:if (check(3,2)){game(3,2);}
				break;
				case R.id.b33:if (check(3,3)){game(3,3);}
				break;
				case R.id.b34:if (check(3,4)){game(3,4);}
				break;
				case R.id.b35:if (check(3,5)){game(3,5);}
				break;
				case R.id.b41:if (check(4,1)){game(4,1);}
				break;
				case R.id.b42:if (check(4,2)){game(4,2);}
				break;
				case R.id.b43:if (check(4,3)){game(4,3);}
				break;
				case R.id.b44:if (check(4,4)){game(4,4);}
				break;
				case R.id.b45:if (check(4,5)){game(4,5);}
				break;
				case R.id.b51:if (check(5,1)){game(5,1);}
				break;
				case R.id.b52:if (check(5,2)){game(5,2);}
				break;
				case R.id.b53:if (check(5,3)){game(5,3);}
				break;
				case R.id.b54:if (check(5,4)){game(5,4);}
				break;
				case R.id.b55:if (check(5,5)){game(5,5);}
				break;
				
		 }
			
		}
		
	}
	public boolean check(int i, int j) {
		boolean x = false;
		i--;
		j--;
		Button want = (Button)findViewById(R.id.wanted);
		Log.d("MainTag","Check: ("+Integer.toString(i)+", "+Integer.toString(j)+")");
		String a = (String) btns[i*5+j].getTag();
		String b = (String) want.getTag();
		Log.d("MainTag","a: "+a);
		Log.d("MainTag","b: "+b);
		
		
		if (a==b){
			x = true;
			remcolor(a);
		}
		return x;
	}
	public void  remcolor(String s){
		for (int i = 0;i<5;i++)
		{
			if (s == colorStr[i]){
				colorCounts[i]--;
				break;
			}
		}
	}
	//************ game
	public void game (int i, int j) {
		i--;
		j--;
		Log.d("MainTag","Game: ("+Integer.toString(i)+", "+Integer.toString(j)+")");
		Animation scored = AnimationUtils.loadAnimation(this, R.anim.blup);
		final Button btn = btns[i*5+j];
		Random ran = new Random();
		int temp = ran.nextInt(5);
		final GradientDrawable shape = (GradientDrawable)btn.getBackground();
		if (i == 0){
//			btn.setVisibility(View.INVISIBLE);
			score_int++;
			score.setText(Integer.toString(score_int));
//			final Handler handler = new Handler();
//			handler.postDelayed(new Runnable() {
//			    @Override
//			    public void run() {
					btn.startAnimation(scored);
			    	shape.setColor(Color.parseColor(colorStr[temp]));
			    	btn.setTag(colorStr[temp]);
//			    	btn.setVisibility(View.VISIBLE);
//			    }
//			}, 50);
		}
		if (i == 1){
			//btn.setVisibility(View.INVISIBLE);
			score_int++;
			score.setText(Integer.toString(score_int));
//			final Handler handler = new Handler();
//			handler.postDelayed(new Runnable() {
//			    @Override
//			    public void run() {
					btn.startAnimation(scored);
			    	shape.setColor(Color.parseColor(colorStr[temp]));
			    	btn.setTag(colorStr[temp]);
//			    	btn.setVisibility(View.VISIBLE);
//			    }
//			}, 50);
		}
		if (i == 2){
//			btn.setVisibility(View.INVISIBLE);
			score_int++;
			score.setText(Integer.toString(score_int));
//			final Handler handler = new Handler();
//			handler.postDelayed(new Runnable() {
//			    @Override
//			    public void run() {
					btn.startAnimation(scored);
					shape.setColor(Color.parseColor(colorStr[temp]));
					btn.setTag(colorStr[temp]);
//			    	btn.setVisibility(View.VISIBLE);
//			    }
//			}, 50);
		}
		if (i == 3){
			//btn.setVisibility(View.INVISIBLE);
			score_int++;
			score.setText(Integer.toString(score_int));
			//final Handler handler = new Handler();
			//handler.postDelayed(new Runnable() {
//			    @Override
//			    public void run() {
					btn.startAnimation(scored);
			    	shape.setColor(Color.parseColor(colorStr[temp]));
			    	btn.setTag(colorStr[temp]);
//			    	btn.setVisibility(View.VISIBLE);
//			    }
//			}, 50);
		}
		if (i == 4){
			//btn.setVisibility(View.INVISIBLE);
			score_int++;
			score.setText(Integer.toString(score_int));
			//final Handler handler = new Handler();
			//handler.postDelayed(new Runnable() {
			   // @Override
			    //public void run() {
					btn.startAnimation(scored);    	
					shape.setColor(Color.parseColor(colorStr[temp]));
					btn.setTag(colorStr[temp]);
			    	//btn.setVisibility(View.VISIBLE);
			    //}
			//}, 50);
		}
	}		
/*XXX*/	public void animation(int i , int j){
	}
	public int wantColor(){
		Random r = new Random();
		int a;
		while(true){
		a = r.nextInt(5);
		if (colorCounts[a] != 0){
			break;}
		}
		return a;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
