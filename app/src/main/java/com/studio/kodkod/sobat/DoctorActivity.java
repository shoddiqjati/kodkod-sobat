package com.studio.kodkod.sobat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoctorActivity extends AppCompatActivity {

    EditText namaDokter, sipDokter, alamatDokter;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

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
            }
        });
    }
}
