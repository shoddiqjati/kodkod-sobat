package com.studio.kodkod.sobat;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoctorActivity extends AppCompatActivity {

    EditText namaDokter, sipDokter, alamatDokter;
    Button nextButton;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("S-Obat");
        toolbar.setTitleTextColor(Color.WHITE);
        
        initObject();
    }

    private void initObject() {
        namaDokter = (EditText) findViewById(R.id.nama_dokter);
        sipDokter = (EditText) findViewById(R.id.sip_dokter);
        alamatDokter = (EditText) findViewById(R.id.alamat_dokter);
        nextButton = (Button) findViewById(R.id.nextBtn);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nDok = namaDokter.getText().toString();
                String nSip = sipDokter.getText().toString();
                String nAlamat = alamatDokter.getText().toString();

                Data.namaDokter = nDok;
                Data.sipDokter = nSip;
                Data.alamatDokter = nAlamat;

                Intent intent = new Intent(DoctorActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
