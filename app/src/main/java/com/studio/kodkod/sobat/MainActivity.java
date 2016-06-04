package com.studio.kodkod.sobat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout createReceiptRL, drugDataRL;

    Data data;
//    Firebase rootRef;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("S-Obat");
        toolbar.setTitleTextColor(Color.WHITE);

        data = new Data();
//        Firebase.setAndroidContext(this);
        //readDatabase();
        initObject();
    }

    private void initObject() {
        createReceiptRL = (RelativeLayout) findViewById(R.id.create_receipt);
        drugDataRL = (RelativeLayout) findViewById(R.id.data_collection);

        createReceiptRL.setOnClickListener(this);
        drugDataRL.setOnClickListener(this);
    }

    /*private void readDatabase() {
        createArray();
        rootRef = new Firebase("https://sobat.firebaseio.com/");
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int i = 0; i < 4; i++) {
                    String a = String.valueOf(i);
                    data.namaObat[i] = dataSnapshot.child(a).child("namaObat").getValue().toString();
                    data.golongan[i] = dataSnapshot.child(a).child("golongan").getValue().toString();
                    data.bentukSediaan[i] = dataSnapshot.child(a).child("bentukSediaan").getValue().toString();
                    data.indikasi[i] = dataSnapshot.child(a).child("indikasi").getValue().toString();
                    data.kontraIndikasi[i] = dataSnapshot.child(a).child("kontraIndikasi").getValue().toString();
                    data.perhatian[i] = dataSnapshot.child(a).child("perhatian").getValue().toString();
                    data.efekSamping[i] = dataSnapshot.child(a).child("efekSamping").getValue().toString();
                    data.dosis[i] = dataSnapshot.child(a).child("dosis").getValue().toString();
                    data.interaksiObat[i] = dataSnapshot.child(a).child("interaksiObat").getValue().toString();
                    data.kemasan[i] = dataSnapshot.child(a).child("kemasan").getValue().toString();
                    data.peresepan[i] = dataSnapshot.child(a).child("peresepan").getValue().toString();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }*/

    /*private void createArray() {
        data.namaObat = new String[4];
        data.golongan = new String[4];
        data.bentukSediaan = new String[4];
        data.indikasi = new String[4];
        data.kontraIndikasi = new String[4];
        data.perhatian = new String[4];
        data.efekSamping = new String[4];
        data.dosis = new String[4];
        data.interaksiObat = new String[4];
        data.kemasan = new String[4];
        data.peresepan = new String[4];
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_receipt:
                Intent intent = new Intent(this, InputPatientActivity.class);
                startActivity(intent);
                break;

            case R.id.data_collection:
                Intent intent1 = new Intent(this, DataCollectionActivity.class);
                startActivity(intent1);
        }
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
