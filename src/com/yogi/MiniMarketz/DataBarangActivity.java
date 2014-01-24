package com.yogi.MiniMarketz;

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
 * Date: 1/13/14
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataBarangActivity extends ListActivity {
    // url to make request
    private static String url = "http://mini-marketz.herokuapp.com/api/android/databarang/";

    // JSON Node names
    private static final String TAG_BARANG = "databarang";
    private static final String TAG_ID = "_id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_TIPE = "tipe";
    private static final String TAG_HARGA = "harga";
    private static final String TAG_STOCK = "stock";

    // contacts JSONArray
    JSONArray databarang = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barang);

        // Hashmap for ListView
        ArrayList<HashMap<String, String>> barangList = new ArrayList<HashMap<String, String>>();

        // Creating JSON Parser instance
        JSONParser jParser = new JSONParser();

        // getting JSON string from URL
        JSONObject json = jParser.getJSONFromUrl(url);

        try {
            // Getting Array of Barang
            databarang = json.getJSONArray(TAG_BARANG);

            // looping through All Barang
            for(int i = 0; i < databarang.length(); i++){
                JSONObject c = databarang.getJSONObject(i);

                // Storing each json item in variable
                String id = c.getString(TAG_ID);
                String nama = c.getString(TAG_NAMA);
                String tipe = c.getString(TAG_TIPE);
                String harga = c.getString(TAG_HARGA);
                String stock = c.getString(TAG_STOCK);

                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map.put(TAG_ID, id);
                map.put(TAG_NAMA, nama);
                map.put(TAG_TIPE, tipe);
                map.put(TAG_HARGA, harga);
                map.put(TAG_STOCK, stock);

                // adding HashList to ArrayList
                barangList.add(map);
            }
        } catch (JSONException e) {

            e.printStackTrace();
        }


        /**
         * Updating parsed JSON data into ListView
         * */
        ListAdapter adapter = new SimpleAdapter(this, barangList,
                R.layout.list_barang,
                new String[] { TAG_ID, TAG_NAMA, TAG_TIPE, TAG_HARGA, TAG_STOCK }, new int[] {
                R.id._id, R.id.nama,R.id.tipe, R.id.harga, R.id.stock });

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();

        // Launching new screen on Selecting Single ListItem
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String nama = ((TextView) view.findViewById(R.id.nama)).getText().toString();
                String harga = ((TextView) view.findViewById(R.id.harga)).getText().toString();
                String stock = ((TextView) view.findViewById(R.id.stock)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                in.putExtra(TAG_NAMA, nama);
                in.putExtra(TAG_HARGA, harga);
                in.putExtra(TAG_STOCK, stock);
                startActivity(in);

            }
        });



    }

}
