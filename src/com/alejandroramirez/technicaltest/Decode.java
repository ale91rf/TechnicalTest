package com.alejandroramirez.technicaltest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Decode extends Activity implements OnClickListener{
	
	private String file;
	private Button btnFile1;
	private TextView lblOriginal;
	private Button btnFile2;
	private Button btnFile3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decode);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		getViews();
	
	}

	private void getViews() {
		btnFile1 = (Button) findViewById(R.id.btnFile1);
		btnFile1.setOnClickListener(this);
		
		btnFile2 = (Button) findViewById(R.id.btnFile2);
		btnFile2.setOnClickListener(this);
		
		btnFile3 = (Button) findViewById(R.id.btnFile3);
		btnFile3.setOnClickListener(this);
		
		lblOriginal = (TextView) findViewById(R.id.lblOriginal);
		
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			
			this.finish();
			
			break;
	
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnFile1:
			decodeFile(R.raw.file1);
			break;

		case R.id.btnFile2:
			decodeFile(R.raw.file2);
			break;
			
		case R.id.btnFile3:
			decodeFile(R.raw.file3);
			break;
		}
		
	}

	private void decodeFile(int nFile) {
		
		try
		{
			InputStream inputStream = getResources().openRawResource(
					nFile);
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

			String readLine;
			StringBuffer buf = new StringBuffer();

			while ((readLine = in.readLine()) != null) {
				buf.append(readLine);
			}


			if (null != in) {
				in.close();
			}
		    
			
			lblOriginal.setText(buf.toString());
		   
		}
		catch (Exception ex)
		{
		    Log.e("Ficheros", "Error al leer fichero desde recurso raw");
		}
		
		
		
	}
}
