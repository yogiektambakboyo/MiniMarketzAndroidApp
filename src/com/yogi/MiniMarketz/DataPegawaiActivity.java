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
 * Date: 1/11/14
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataPegawaiActivity extends ListActivity {

    // url to make request

    private static String url = "http://mini-marketz.herokuapp.com/api/android/datapegawai/";

    // JSON Node names
    private static final String TAG_PEGAWAI = "datapegawai";
    private static final String TAG_ID = "_id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_JENIS_KELAMIN = "jenis_kelamin";
    private static final String TAG_AGAMA = "agama";
    private static final String TAG_TANGGAL_MASUK = "tanggal_masuk";
    private static final String TAG_STATUS = "status";
    private static final String TAG_NEGARA = "negara";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_TELEPON = "telepon";
    private static final String TAG_TELEPON_RUMAH = "telepon_rumah";
    private static final String TAG_TELEPON_HANDPHONE = "telepon_handphone";

    // contacts JSONArray
    JSONArray datapegawai = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pegawai);

        // Hashmap for ListView
        ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();

        // Creating JSON Parser instance
        JSONParser jParser = new JSONParser();

        // getting JSON string from URL
        JSONObject json = jParser.getJSONFromUrl(url);

        try {
            // Getting Array of Pegawai
            datapegawai = json.getJSONArray(TAG_PEGAWAI);

            // looping through All Pegawai
            for(int i = 0; i < datapegawai.length(); i++){
                JSONObject c = datapegawai.getJSONObject(i);

                // Storing each json item in variable
                String id = c.getString(TAG_ID);
                String nama = c.getString(TAG_NAMA);
                String jenis_kelamin = c.getString(TAG_JENIS_KELAMIN);
                String agama = c.getString(TAG_AGAMA);
                String tanggal_masuk = c.getString(TAG_TANGGAL_MASUK);
                String status = c.getString(TAG_STATUS);
                String negara = c.getString(TAG_NEGARA);
                String email = c.getString(TAG_EMAIL);

                // Phone number is again JSON Object
                //JSONObject telepon = c.getJSONObject(TAG_TELEPON);
                //String telepon_rumah = telepon.getString(TAG_TELEPON_RUMAH);
                //String telepon_handphone = telepon.getString(TAG_TELEPON_HANDPHONE);


                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map.put(TAG_ID, id);
                map.put(TAG_NAMA, nama);
                map.put(TAG_JENIS_KELAMIN, jenis_kelamin);
                map.put(TAG_AGAMA, agama);
                /*map.put(TAG_TELEPON_RUMAH, telepon_rumah);
                map.put(TAG_TELEPON_HANDPHONE, telepon_handphone);*/
                map.put(TAG_EMAIL, email);

                // adding HashList to ArrayList
                contactList.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        /**
         * Updating parsed JSON data into ListView
         * */
        ListAdapter adapter = new SimpleAdapter(this, contactList,
                R.layout.list_pegawai,
                new String[] { TAG_ID, TAG_NAMA, TAG_JENIS_KELAMIN, TAG_AGAMA }, new int[] {
                R.id._id, R.id.nama, R.id.jenis_kelamin, R.id.agama });

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
                String jenis_kelamin= ((TextView) view.findViewById(R.id.jenis_kelamin)).getText().toString();
                String agama = ((TextView) view.findViewById(R.id.agama)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                in.putExtra(TAG_NAMA, nama);
                in.putExtra(TAG_JENIS_KELAMIN, jenis_kelamin);
                in.putExtra(TAG_AGAMA, agama);
                startActivity(in);

            }
        });



    }

}
