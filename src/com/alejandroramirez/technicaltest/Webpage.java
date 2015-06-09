package com.alejandroramirez.technicaltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import utils.LinkAdapter;
import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract.Document;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Webpage extends Activity {
	
	private String TAG_URL = "http://www.visual-engin.com/Web/";
	
	private ArrayList<String> links;

	private ListView lstLinks;
	private LinkAdapter adapter;

	private ProgressBar pBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webpage);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		lstLinks = (ListView) findViewById(R.id.lstLinks);
		pBar = (ProgressBar) findViewById(R.id.pBar);
		
		new getSourceCode().execute();
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
	
	
	public class getSourceCode extends AsyncTask<String, Void, String> {

        
		@Override
        protected String doInBackground(String... urls) {
			pBar.setVisibility(View.VISIBLE);
            try {

                URL url;
                
                
                String response = "";
				try {

                    url = new URL(TAG_URL);
                    URLConnection conn = url.openConnection();

                    // open the stream and put it into BufferedReader
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));

                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        response += inputLine;
                    }
                    br.close();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                
                return response;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String feed) {

            Parser(feed);

        }
			
		
    }

	private void Parser(String feed) {
		if(feed != null){
			links = new ArrayList<>();
			
			
			Pattern regex = Pattern.compile("<a .*?href=\"(.*?)\"");
			Matcher matches = regex.matcher(feed);
			while (matches.find()) {
				System.out.println(matches.group(1));
				links.add(matches.group(1));
			}
			adapter = new LinkAdapter(this, links);
			lstLinks.setAdapter(adapter);
			
		}
		
		pBar.setVisibility(View.INVISIBLE);
		
	}
}
