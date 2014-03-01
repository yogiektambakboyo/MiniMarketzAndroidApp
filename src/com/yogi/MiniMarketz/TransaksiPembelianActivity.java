package com.yogi.MiniMarketz;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Yogi
 * Date: 3/1/14
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransaksiPembelianActivity extends ListActivity {
    // url to make request
    private static String url = "http://mini-marketz.herokuapp.com/api/android/datatransaksipembelian/";

    // JSON Node names
    private static final String TAG_TRPEMBELIAN = "datatransaksipembelian";
    private static final String TAG_ID = "_id";
    private static final String TAG_TANGGAL_TRANSAKSI = "tanggal_transaksi";
    private static final String TAG_NO_KWITANSI = "no_kwitansi";
    private static final String TAG_TOTAL_TRANSAKSI = "total_transaksi";
    private static final String TAG_ID_DISTRIBUTOR = "id_distributor";
    private static final String TAG_PENERIMA = "penerima";
    private static final String TAG_STATUS = "status";
    private Integer jumlahData = 0;

    // contacts JSONArray
    JSONArray datatransaksipembelian = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaksipembelian);

        // Hashmap for ListView
        ArrayList<HashMap<String, String>> transaksipembelianList = new ArrayList<HashMap<String, String>>();

        // Creating JSON Parser instance
        JSONParser jParser = new JSONParser();

        // getting JSON string from URL
        JSONObject json = jParser.getJSONFromUrl(url);

        try {
            // Getting Array of Barang
            datatransaksipembelian = json.getJSONArray(TAG_TRPEMBELIAN);
            jumlahData = datatransaksipembelian.length();
            String jumlahdata = jumlahData.toString();
            TextView jumlah_data = (TextView) findViewById(R.id.jumlah_data);
            jumlah_data.setText("Menampilkan " + jumlahdata + " data");

            // looping through All Barang
            for(int i = 0; i < datatransaksipembelian.length(); i++){
                JSONObject c = datatransaksipembelian.getJSONObject(i);

                // Storing each json item in variable
                String id = c.getString(TAG_ID);
                String tanggal_transaksi = c.getString(TAG_TANGGAL_TRANSAKSI);
                String no_kwitansi = c.getString(TAG_NO_KWITANSI);
                String total_transaksi = c.getString(TAG_TOTAL_TRANSAKSI);
                String penerima = c.getString(TAG_PENERIMA);

                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map.put(TAG_ID, id);
                map.put(TAG_TANGGAL_TRANSAKSI, tanggal_transaksi);
                map.put(TAG_NO_KWITANSI, no_kwitansi);
                map.put(TAG_TOTAL_TRANSAKSI, total_transaksi);
                map.put(TAG_PENERIMA, penerima);

                // adding HashList to ArrayList
                transaksipembelianList.add(map);
            }
        } catch (JSONException e) {

            e.printStackTrace();
        }


        /**
         * Updating parsed JSON data into ListView
         * */
        ListAdapter adapter = new SimpleAdapter(this, transaksipembelianList,
                R.layout.list_transaksipembelian,
                new String[] { TAG_ID, TAG_TANGGAL_TRANSAKSI, TAG_NO_KWITANSI, TAG_TOTAL_TRANSAKSI, TAG_PENERIMA }, new int[] {
                R.id._id, R.id.tanggal_transaksi, R.id.no_kwitansi, R.id.total_transaksi, R.id.penerima });

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();

        // Launching new screen on Selecting Single ListItem
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String tanggal_transaksi = ((TextView) view.findViewById(R.id.tanggal_transaksi)).getText().toString();
                String no_kwitansi = ((TextView) view.findViewById(R.id.no_kwitansi)).getText().toString();
                String total_transaksi = ((TextView) view.findViewById(R.id.total_transaksi)).getText().toString();
                String penerima = ((TextView) view.findViewById(R.id.penerima)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), ViewTransaksasiActivity.class);
                in.putExtra(TAG_TANGGAL_TRANSAKSI, tanggal_transaksi);
                in.putExtra(TAG_NO_KWITANSI, no_kwitansi);
                in.putExtra(TAG_TOTAL_TRANSAKSI, total_transaksi);
                in.putExtra(TAG_PENERIMA, penerima);
                startActivity(in);

            }
        });



    }

}