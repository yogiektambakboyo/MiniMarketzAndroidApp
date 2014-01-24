package com.yogi.MiniMarketz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity  extends Activity {
	
	// JSON node keys
	private static final String TAG_NAMA = "nama";
	private static final String TAG_HARGA = "harga";
	private static final String TAG_STOCK = "stock";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String nama = in.getStringExtra(TAG_NAMA);
        String harga = in.getStringExtra(TAG_HARGA);
        String stock = in.getStringExtra(TAG_STOCK);
        
        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblCost = (TextView) findViewById(R.id.email_label);
        TextView lblDesc = (TextView) findViewById(R.id.mobile_label);
        
        lblName.setText(nama);
        lblCost.setText(harga);
        lblDesc.setText(stock);
    }
}
