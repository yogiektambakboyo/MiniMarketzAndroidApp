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
    private static final String TAG_TELEPON_RUMAH = "rumah";
    private static final String TAG_TELEPON_HANDPHONE = "handphone";
    private static final String TAG_ALAMAT = "alamat";
    private static final String TAG_ALAMAT_KELURAHAN = "kelurahan";
    private static final String TAG_ALAMAT_KECAMATAN = "kecamatan";
    private static final String TAG_ALAMAT_KOTA = "kota";
    private static final String TAG_ALAMAT_PROVINSI = "provinsi";
    private static final String TAG_ALAMAT_KODEPOS = "kodepos";
    private static final String TAG_TTL = "ttl";
    private static final String TAG_TTL_TEMPAT = "tempat";
    private static final String TAG_TTL_TANGGAL = "tanggal";

    // contacts JSONArray
    JSONArray datapegawai = null;

    private Integer jumlahData = 0;

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

            jumlahData = datapegawai.length();
            String jumlahdata = jumlahData.toString();
            TextView jumlah_data = (TextView) findViewById(R.id.jumlah_pegawai);
            jumlah_data.setText("Menampilkan " + jumlahdata + " data");

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
                JSONObject telepon = c.getJSONObject(TAG_TELEPON);
                String telepon_rumah = telepon.getString(TAG_TELEPON_RUMAH);
                String telepon_handphone = telepon.getString(TAG_TELEPON_HANDPHONE);

                // Alamat is JSON Object
                JSONObject alamat = c.getJSONObject(TAG_ALAMAT);
                String alamat_kelurahan = alamat.getString(TAG_ALAMAT_KELURAHAN);
                String alamat_kecamatan = alamat.getString(TAG_ALAMAT_KECAMATAN);
                String alamat_kota = alamat.getString(TAG_ALAMAT_KOTA);
                String alamat_provinsi = alamat.getString(TAG_ALAMAT_PROVINSI);
                String alamat_kodepos = alamat.getString(TAG_ALAMAT_KODEPOS);

                //TTL is JSON Object
                JSONObject ttl = c.getJSONObject(TAG_TTL);
                String ttl_tempat = ttl.getString(TAG_TTL_TEMPAT);
                String ttl_tanggal = ttl.getString(TAG_TTL_TANGGAL);


                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value
                map.put(TAG_ID, id);
                map.put(TAG_NAMA, nama);
                map.put(TAG_JENIS_KELAMIN, jenis_kelamin);
                map.put(TAG_AGAMA, agama);
                map.put(TAG_TANGGAL_MASUK, tanggal_masuk);
                map.put(TAG_STATUS, status);
                map.put(TAG_NEGARA, negara);
                map.put(TAG_TELEPON_RUMAH, telepon_rumah);
                map.put(TAG_TELEPON_HANDPHONE, telepon_handphone);
                map.put(TAG_EMAIL, email);
                map.put(TAG_ALAMAT_KELURAHAN, alamat_kelurahan);
                map.put(TAG_ALAMAT_KECAMATAN, alamat_kecamatan);
                map.put(TAG_ALAMAT_KOTA, alamat_kota);
                map.put(TAG_ALAMAT_PROVINSI, alamat_provinsi);
                map.put(TAG_ALAMAT_KODEPOS, alamat_kodepos);
                map.put(TAG_TTL_TEMPAT, ttl_tempat);
                map.put(TAG_TTL_TANGGAL, ttl_tanggal);

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
                new String[] {
                        TAG_ID,
                        TAG_NAMA,
                        TAG_JENIS_KELAMIN,
                        TAG_AGAMA,
                        TAG_TANGGAL_MASUK,
                        TAG_STATUS,
                        TAG_NEGARA,
                        TAG_TELEPON_RUMAH,
                        TAG_TELEPON_HANDPHONE,
                        TAG_EMAIL,
                        TAG_ALAMAT_KELURAHAN,
                        TAG_ALAMAT_KECAMATAN,
                        TAG_ALAMAT_KOTA,
                        TAG_ALAMAT_PROVINSI,
                        TAG_ALAMAT_KODEPOS ,
                        TAG_TTL_TANGGAL,
                        TAG_TTL_TEMPAT
                },
                new int[] {
                        R.id._id,
                        R.id.nama,
                        R.id.jenis_kelamin,
                        R.id.agama,
                        R.id.tanggal_masuk,
                        R.id.status,
                        R.id.negara,
                        R.id.telepon_rumah,
                        R.id.telepon_handphone,
                        R.id.email,
                        R.id.alamat_kelurahan,
                        R.id.alamat_kecamatan,
                        R.id.alamat_kota,
                        R.id.alamat_provinsi,
                        R.id.alamat_kodepos,
                        R.id.ttl_tanggal,
                        R.id.ttl_tempat
                });

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
                String tanggal_masuk = ((TextView) view.findViewById(R.id.tanggal_masuk)).getText().toString();
                String status = ((TextView) view.findViewById(R.id.status)).getText().toString();
                String negara = ((TextView) view.findViewById(R.id.negara)).getText().toString();
                String email = ((TextView) view.findViewById(R.id.email)).getText().toString();
                String telepon_rumah = ((TextView) view.findViewById(R.id.telepon_rumah)).getText().toString();
                String telepon_handphone = ((TextView) view.findViewById(R.id.telepon_handphone)).getText().toString();
                String alamat_kelurahan = ((TextView) view.findViewById(R.id.alamat_kelurahan)).getText().toString();
                String alamat_kecamatan = ((TextView) view.findViewById(R.id.alamat_kecamatan)).getText().toString();
                String alamat_kota = ((TextView) view.findViewById(R.id.alamat_kota)).getText().toString();
                String alamat_provinsi = ((TextView) view.findViewById(R.id.alamat_provinsi)).getText().toString();
                String alamat_kodepos = ((TextView) view.findViewById(R.id.alamat_kodepos)).getText().toString();
                String ttl_tempat = ((TextView) view.findViewById(R.id.ttl_tempat)).getText().toString();
                String ttl_tanggal = ((TextView) view.findViewById(R.id.ttl_tanggal)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), ViewPegawaiActivity.class);
                in.putExtra(TAG_NAMA, nama);
                in.putExtra(TAG_JENIS_KELAMIN, jenis_kelamin);
                in.putExtra(TAG_AGAMA, agama);
                in.putExtra(TAG_TANGGAL_MASUK, tanggal_masuk);
                in.putExtra(TAG_STATUS, status);
                in.putExtra(TAG_NEGARA, negara);
                in.putExtra(TAG_EMAIL, email);
                in.putExtra(TAG_TELEPON_RUMAH, telepon_rumah);
                in.putExtra(TAG_TELEPON_HANDPHONE, telepon_handphone);
                in.putExtra(TAG_ALAMAT_KELURAHAN, alamat_kelurahan);
                in.putExtra(TAG_ALAMAT_KECAMATAN, alamat_kecamatan);
                in.putExtra(TAG_ALAMAT_KOTA, alamat_kota);
                in.putExtra(TAG_ALAMAT_PROVINSI, alamat_provinsi);
                in.putExtra(TAG_ALAMAT_KODEPOS, alamat_kodepos);
                in.putExtra(TAG_TTL_TANGGAL, ttl_tanggal);
                in.putExtra(TAG_TTL_TEMPAT, ttl_tempat);
                startActivity(in);

            }
        });



    }

}
