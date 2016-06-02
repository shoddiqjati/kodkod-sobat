package com.studio.kodkod.sobat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView namaObat, golongan, bentukSediaan, indikasi, kontraIndikasi, perhatian, efekSamping, dosis, interaksiObat, kemasan, peresepan;
    String index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initObject();
    }

    public void initObject() {
        Intent intent = getIntent();
        index = intent.getStringExtra("POSITION");
        int position = Integer.parseInt(index);

        namaObat = (TextView) findViewById(R.id.medDetail_namaObat);
        golongan = (TextView) findViewById(R.id.medDetail_golongan);
        bentukSediaan = (TextView) findViewById(R.id.medDetail_bentukSediaan);
        indikasi = (TextView) findViewById(R.id.medDetail_indikasi);
        kontraIndikasi = (TextView) findViewById(R.id.medDetail_kontraIndikasi);
        perhatian = (TextView) findViewById(R.id.medDetail_perhatian);
        efekSamping = (TextView) findViewById(R.id.medDetail_efekSamping);
        dosis = (TextView) findViewById(R.id.medDetail_dosis);
        interaksiObat = (TextView) findViewById(R.id.medDetail_interaksiObat);
        kemasan = (TextView) findViewById(R.id.medDetail_Kemasan);
        peresepan = (TextView) findViewById(R.id.medDetail_peresepan);

        namaObat.setText(Data.namaObat[position]);
        golongan.setText(Data.golongan[position]);
        bentukSediaan.setText(Data.bentukSediaan[position]);
        indikasi.setText(Data.indikasi[position]);
        kontraIndikasi.setText(Data.kontraIndikasi[position]);
        perhatian.setText(Data.perhatian[position]);
        efekSamping.setText(Data.efekSamping[position]);
        dosis.setText(Data.dosis[position]);
        interaksiObat.setText(Data.interaksiObat[position]);
        kemasan.setText(Data.kemasan[position]);
        peresepan.setText(Data.peresepan[position]);
    }
}
