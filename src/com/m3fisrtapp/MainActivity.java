package com.m3fisrtapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	Button button2;
	Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	private void addListenerOnButton() {
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);

		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setContentView(R.layout.login);
			    Toast.makeText(MainActivity.this,
				"Welcome to the login screen!", Toast.LENGTH_SHORT).show();
			}
		});
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setContentView(R.layout.register);
			   Toast.makeText(MainActivity.this,
			"Welcome to the register screen!", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
