package com.alejandroramirez.technicaltest;

import java.math.BigInteger;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class Factorial extends Activity implements OnClickListener{

	private EditText txtNumber;
	private Button btnCalculate;
	private TextView lblCalculated;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factorial);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		getViews();
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

	private void getViews() {
		txtNumber = (EditText) findViewById(R.id.txtNumber);
		
		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		btnCalculate.setOnClickListener(this);
		
		lblCalculated = (TextView) findViewById(R.id.lblCalculated);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCalculate:
			calculateFactorial();
			break;

		default:
			break;
		}
		
	}

	private void calculateFactorial() {
		
		if(txtNumber.getText().length() != 0){
			
			if(Integer.parseInt(txtNumber.getText().toString()) < 10000){
				
				lblCalculated.setText(String.valueOf(factorial(BigInteger.valueOf(Long.parseLong(txtNumber.getText().toString())))));

				
			}else {
				
				Toast.makeText(getApplicationContext(), "This number is too big!", Toast.LENGTH_LONG).show();

				
			}
			
			
			
		}else{
			Toast.makeText(getApplicationContext(), "Introduce a number please", Toast.LENGTH_LONG).show();
		}
		
	}
	
	

	public BigInteger factorial (BigInteger numero) {
        if (BigInteger.ZERO.equals(numero))
          return BigInteger.ONE;
        else
          return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
      }

	
}
