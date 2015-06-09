package utils;

import java.util.ArrayList;

import com.alejandroramirez.technicaltest.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LinkAdapter extends ArrayAdapter<String>{
	
	private ArrayList<String> links;
	private Activity activity;
	private TextView lblLink;

	public LinkAdapter(Activity activity, ArrayList<String> links) {
		super(activity, R.layout.activity_webpage_item, links);
		this.activity = activity;
		this.links = links;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        
        if(v == null){
    		LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        	v = inf.inflate(R.layout.activity_webpage_item, null);
        	
        }
        
        lblLink = (TextView) v.findViewById(R.id.lblLink);
        
        lblLink.setText(links.get(position).toString());
        
        return v;
	}
	
	

}
