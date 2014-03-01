package com.yogi.MiniMarketz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Yogi
 * Date: 3/1/14
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewTransaksasiActivity extends Activity {

    // JSON Node names

    private static final String TAG_ID = "_id";
    private static final String TAG_ID_DISTRIBUTOR = "id_distributor";
    private static final String TAG_STATUS = "status";

    private static final String TAG_TANGGAL_TRANSAKSI = "tanggal_transaksi";
    private static final String TAG_NO_KWITANSI = "no_kwitansi";
    private static final String TAG_TOTAL_TRANSAKSI = "total_transaksi";
    private static final String TAG_PENERIMA = "penerima";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_transaksipembelian);
        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        String tanggal_transaksi = in.getStringExtra(TAG_TANGGAL_TRANSAKSI);
        String no_kwitansi = in.getStringExtra(TAG_NO_KWITANSI);
        String total_transaksi = in.getStringExtra(TAG_TOTAL_TRANSAKSI);
        String penerima = in.getStringExtra(TAG_PENERIMA);

        // Displaying all values on the screen
        TextView lblNama = (TextView) findViewById(R.id.view_tanggal_transaksi);
        TextView lblTanggalTransaksi = (TextView) findViewById(R.id.view_no_kwitansi);
        TextView lblTotalTransaksi = (TextView) findViewById(R.id.view_total_transaksi);
        TextView lblPenerima = (TextView) findViewById(R.id.view_penerima);

        lblNama.setText(tanggal_transaksi);
        lblTanggalTransaksi.setText(no_kwitansi);
        lblTotalTransaksi.setText("Rp. " + total_transaksi);
        lblPenerima.setText(penerima);

    }
}
