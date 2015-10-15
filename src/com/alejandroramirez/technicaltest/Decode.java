package com.alejandroramirez.technicaltest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

			//le annado el "\n" para mostrar el mismo resultado que me sale en el servidor
			//utilizando Python
			while ((readLine = in.readLine()) != null) {
				buf.append(readLine+"\n");
			}


			if (null != in) {
				in.close();
			}
		    
			
			String string = buf.toString();
			
			if(nFile == R.raw.file1){
				
				
				 /*         Hecho en python en el servidor
				
				import base64
						
				print "VGhpcyB3YXMgc28gZWFzeSwgaXNuJ3QgaXQ/IFRoZSBuZXh0IG9uZSB3aWxsIGJlIHF1aXRlIG1v".decode("base64")
						
				print "cmUgZGlmZmljdWx0LgpPbmUgY2x1ZSwgaXMgb25lIG9mIHRoZSBzaW1wbGVzdHMgZW5jb2Rpbmdz".decode("base64")		
						
				print "LCBidXQgeW91IG11c3QgZmluZCB0aGUga2V5".decode("base64")
						
				Aplico 3 veces el metodo decode por los \n        */
		
				

				lblOriginal.setText(string);
				
				
				
			}else if(nFile == R.raw.file2){
				
				
				
			}
			
			
		   
		}
		catch (Exception ex)
		{
		    Log.e("Ficheros", "Error al leer fichero desde recurso raw");
		}
		
		
		
	}
	
}
