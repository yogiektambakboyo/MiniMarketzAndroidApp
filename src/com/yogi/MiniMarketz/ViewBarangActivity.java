package com.yogi.MiniMarketz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Yogi
 * Date: 1/25/14
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewBarangActivity extends Activity {

    // JSON Node names
    private static final String TAG_ID = "_id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_TIPE = "tipe";
    private static final String TAG_HARGA = "harga";
    private static final String TAG_STOCK = "stock";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_barang);

        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        String nama = in.getStringExtra(TAG_NAMA);
        String tipe = in.getStringExtra(TAG_TIPE);
        String harga = in.getStringExtra(TAG_HARGA);
        String stock = in.getStringExtra(TAG_STOCK);

        // Displaying all values on the screen
        TextView lblNama = (TextView) findViewById(R.id.view_nama_barang);
        TextView lblTipe = (TextView) findViewById(R.id.view_tipe_barang);
        TextView lblHarga = (TextView) findViewById(R.id.view_harga_barang);
        TextView lblStock = (TextView) findViewById(R.id.view_stock_barang);

        lblNama.setText(nama);
        lblTipe.setText(tipe);
        lblHarga.setText("Rp. " + harga);
        lblStock.setText(stock + " Ml");

    }
}