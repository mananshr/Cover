package com.binjcover.test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CreateTable extends Activity {

	private ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_table);
		progress = new ProgressDialog(this);
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		onLoad_complete();
	}
	
	private void onLoad_complete() {
		try {
			startActivity(new Intent(this, TableCreated.class));
			Thread.sleep(1); //
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.finish();		
	}

	public void open(View view) {

		progress.setMessage("Creating Table :) ");
		progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progress.setIndeterminate(true);
		progress.show();

		final Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				for (int jump = 0; jump < 100; jump += 5) {
					progress.setProgress(jump);
					try {
						Thread.sleep((long) 10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						Log.e("ERR", e.getMessage().toString());
					}
				}
			}
		});
		
		thread.setPriority(1);
//		thread.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_table, menu);
		return true;
	}

	// public void open(View view){
	// progress.setMessage("Downloading Music :) ");
	// progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	// progress.setIndeterminate(true);
	// progress.show();
	//
	// final int totalProgressTime = 100;
	//
	// final Thread t = new Thread(){
	//
	// @Override
	// public void run(){
	//
	// int jumpTime = 0;
	// while(jumpTime < totalProgressTime){
	// try {
	// sleep(200);
	// jumpTime += 5;
	// progress.setProgress(jumpTime);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	// }
	// }

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
