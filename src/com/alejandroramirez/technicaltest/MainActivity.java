package com.alejandroramirez.technicaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button btnProblem1;
	private Button btnProblem2;
	private Button btnProblem3;
	private Intent i;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		getViews();
	}

	
	
	private void getViews() {
		
		btnProblem1 = (Button) findViewById(R.id.btnProblem1);
		btnProblem1.setOnClickListener(this);
		btnProblem2 = (Button) findViewById(R.id.btnProblem2);
		btnProblem2.setOnClickListener(this);
		btnProblem3 = (Button) findViewById(R.id.btnProblem3);
		btnProblem3.setOnClickListener(this);
		
	}



	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnProblem1:
			i = new Intent(getApplicationContext(), Factorial.class);
			startActivity(i);
			break;

		case R.id.btnProblem2:
			i = new Intent(getApplicationContext(), Decode.class);
			startActivity(i);
			break;
			
		case R.id.btnProblem3:
			i = new Intent(getApplicationContext(), Webpage.class);
			startActivity(i);
			break;
		}
		
	}

	
}
