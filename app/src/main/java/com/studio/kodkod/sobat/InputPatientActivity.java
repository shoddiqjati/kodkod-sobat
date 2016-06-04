package com.studio.kodkod.sobat;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputPatientActivity extends AppCompatActivity {

    EditText namaPasien, umurPasien, beratPasien;
    Button nextBtn;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_patient);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("S-Obat");
        toolbar.setTitleTextColor(Color.WHITE);

        initObject();
    }

    private void initObject() {
        namaPasien = (EditText) findViewById(R.id.nama_pasien);
        umurPasien = (EditText) findViewById(R.id.umur_pasien);
        beratPasien = (EditText) findViewById(R.id.berat_pasien);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mPasien = namaPasien.getText().toString();
                String mUmur = umurPasien.getText().toString();
                String mBerat = beratPasien.getText().toString();

                Data.namaPasien = mPasien;
                Data.umur = mUmur;
                Data.beratBadan = mBerat;

                String newAct = "new";

                Intent intent = new Intent(InputPatientActivity.this, WriteReceiptActivity.class);
                intent.putExtra("EXTRA", newAct);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
