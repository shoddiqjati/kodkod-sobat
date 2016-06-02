package com.studio.kodkod.sobat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputPatientActivity extends AppCompatActivity {

    EditText namaPasien, umurPasien, beratPasien;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_patient);

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
}
