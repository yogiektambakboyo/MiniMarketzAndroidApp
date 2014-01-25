package com.yogi.MiniMarketz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Yogi
 * Date: 1/25/14
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewPegawaiActivity extends Activity {
    // JSON node keys
    private static final String TAG_ID = "_id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_JENIS_KELAMIN = "jenis_kelamin";
    private static final String TAG_AGAMA = "agama";
    private static final String TAG_TANGGAL_MASUK = "tanggal_masuk";
    private static final String TAG_STATUS = "status";
    private static final String TAG_NEGARA = "negara";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_TELEPON_RUMAH = "rumah";
    private static final String TAG_TELEPON_HANDPHONE = "handphone";
    private static final String TAG_ALAMAT_KELURAHAN = "kelurahan";
    private static final String TAG_ALAMAT_KECAMATAN = "kecamatan";
    private static final String TAG_ALAMAT_KOTA = "kota";
    private static final String TAG_ALAMAT_PROVINSI = "provinsi";
    private static final String TAG_ALAMAT_KODEPOS = "kodepos";
    private static final String TAG_TTL_TEMPAT = "tempat";
    private static final String TAG_TTL_TANGGAL = "tanggal";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pegawai);

        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        String nama = in.getStringExtra(TAG_NAMA);
        String jenis_kelamin =  in.getStringExtra(TAG_JENIS_KELAMIN);
        String agama =  in.getStringExtra(TAG_AGAMA);
        String tanggal_masuk =  in.getStringExtra(TAG_TANGGAL_MASUK);
        String status =  in.getStringExtra(TAG_STATUS);
        String negara =  in.getStringExtra(TAG_NEGARA);
        String email =  in.getStringExtra(TAG_EMAIL);
        String telepon_rumah =  in.getStringExtra(TAG_TELEPON_RUMAH);
        String telepon_handphone =  in.getStringExtra(TAG_TELEPON_HANDPHONE);
        String alamat_kelurahan =  in.getStringExtra(TAG_ALAMAT_KELURAHAN);
        String alamat_kecamatan =  in.getStringExtra(TAG_ALAMAT_KECAMATAN);
        String alamat_kota =  in.getStringExtra(TAG_ALAMAT_KOTA);
        String alamat_provinsi =  in.getStringExtra(TAG_ALAMAT_PROVINSI);
        String alamat_kodepos =  in.getStringExtra(TAG_ALAMAT_KODEPOS);
        String ttl_tanggal =  in.getStringExtra(TAG_TTL_TANGGAL);
        String ttl_tempat =  in.getStringExtra(TAG_TTL_TEMPAT);

        // Displaying all values on the screen
        TextView lblNama = (TextView) findViewById(R.id.view_nama_pegawai);
        TextView lblJenisKelamin = (TextView) findViewById(R.id.view_jenis_kelamin_pegawai);
        TextView lblAgama = (TextView) findViewById(R.id.view_agama_pegawai);
        TextView lblTanggalMasuk = (TextView) findViewById(R.id.view_tanggal_masuk_pegawai);
        TextView lblStatus = (TextView) findViewById(R.id.view_status_pegawai);
        TextView lblNegara = (TextView) findViewById(R.id.view_negara_pegawai);
        TextView lblEmail = (TextView) findViewById(R.id.view_email_pegawai);
        TextView lblTeleponRumah = (TextView) findViewById(R.id.view_telepon_rumah_pegawai);
        TextView lblHandphone = (TextView) findViewById(R.id.view_telepon_handphone_pegawai);
        TextView lblAlamatKelurahan = (TextView) findViewById(R.id.view_alamat_kelurahan_pegawai);
        TextView lblAlamatKecamatan  = (TextView) findViewById(R.id.view_alamat_kecamatan_pegawai);
        TextView lblAlamatKota  = (TextView) findViewById(R.id.view_alamat_kota_pegawai);
        TextView lblAlamatProvinsi  = (TextView) findViewById(R.id.view_alamat_provinsi_pegawai);
        TextView lblAlamatKodePos  = (TextView) findViewById(R.id.view_alamat_kodepos_pegawai);
        TextView lblTTLTanggal  = (TextView) findViewById(R.id.view_ttl_tanggal_pegawai);
        TextView lblTTLTempat  = (TextView) findViewById(R.id.view_ttl_tempat_pegawai);

        lblNama.setText(nama);
        lblJenisKelamin.setText(jenis_kelamin);
        lblAgama.setText(agama);
        lblTanggalMasuk.setText(tanggal_masuk);
        lblStatus.setText(status);
        lblNegara.setText(negara);
        lblEmail.setText(email);
        lblTeleponRumah.setText(telepon_rumah);
        lblHandphone.setText(telepon_handphone);
        lblAlamatKelurahan.setText(alamat_kelurahan);
        lblAlamatKecamatan.setText(alamat_kecamatan);
        lblAlamatKota.setText(alamat_kota);
        lblAlamatProvinsi.setText(alamat_provinsi);
        lblAlamatKodePos.setText(alamat_kodepos);
        lblTTLTanggal.setText(ttl_tanggal);
        lblTTLTempat.setText(ttl_tempat);
    }
}