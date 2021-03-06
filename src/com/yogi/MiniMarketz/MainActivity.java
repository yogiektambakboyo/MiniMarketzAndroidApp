package com.yogi.MiniMarketz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[] { "Pegawai", "Barang", "Transaksi Pembelian", "Transaksi Penjualan", "Quit"};
        // use your own layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.main, R.id.label, values);
        setListAdapter(adapter);
    }

   @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();

       if(item == "Pegawai"){
            Intent pegawai = new Intent(MainActivity.this, DataPegawaiActivity.class);
            startActivity(pegawai);
       }

       if(item == "Barang"){
           Intent barang = new Intent(MainActivity.this, DataBarangActivity.class);
           startActivity(barang);
       }

       if(item == "Transaksi Pembelian"){
           Intent transaksipembelian = new Intent(MainActivity.this, TransaksiPembelianActivity.class);
           startActivity(transaksipembelian);
       }

       if(item == "Quit"){
           this.finish();
       }
    }
}
