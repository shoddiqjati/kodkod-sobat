package com.studio.kodkod.sobat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

public class PreviewActivity extends AppCompatActivity {

    String allMessage;

    BluetoothSPP bluetoothSPP;
    Toolbar toolbar;

    Context context = this;
    ListView listView;
    TextView namaDokterTv, sipDokterTv, alamatDokterTv, tanggalTv, namaPasien, umurPasien, beratPasien;

    ArrayList<String> data;
    ArrayList<String> aturan;
    ArrayList<String> getData;

    Button printButton;

    Date date;

    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        bluetoothSPP = new BluetoothSPP(context);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("S-Obat");
        toolbar.setTitleTextColor(Color.WHITE);


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();
        String getDate = dateFormat.format(date);

        allMessage = Data.namaDokter + "_" + Data.sipDokter + "_" + Data.alamatDokter + "_";
        allMessage = allMessage + Data.namaPasien + "_" + Data.umur + "_" + Data.beratBadan + "_" + getDate + "_";
        getData = new ArrayList<>();
        length = Data.rNamaObat.size();
        for (int i = 0; i < length; i++) {
            getData.add(Data.rBentukSediaan.get(i) + " " + Data.rNamaObat.get(i) + " " + Data.rDosis.get(i) + " " + Data.rTotal + " ");
            allMessage = allMessage + Data.rBentukSediaan.get(i) + "_" + Data.rNamaObat.get(i) + "_" + Data.rDosis.get(i) + "_" + Data.rTotal + "_";
        }
        data = getData;
        aturan = Data.rAturanPakai;

        namaDokterTv = (TextView) findViewById(R.id.namaDokterTv);
        sipDokterTv = (TextView) findViewById(R.id.sipDokterTv);
        alamatDokterTv = (TextView) findViewById(R.id.alamatDokterTv);
        tanggalTv = (TextView) findViewById(R.id.tanggalTv);
        namaPasien = (TextView) findViewById(R.id.namaPasien);
        umurPasien = (TextView) findViewById(R.id.umurPasien);
        beratPasien = (TextView) findViewById(R.id.beratPasien);

        namaPasien.setText(Data.namaPasien);
        umurPasien.setText(Data.umur);
        beratPasien.setText(Data.beratBadan);

        namaDokterTv.setText(Data.namaDokter);
        sipDokterTv.setText(Data.sipDokter);
        alamatDokterTv.setText(Data.alamatDokter);
        tanggalTv.setText(getDate);

        CustomList adapter = new CustomList(PreviewActivity.this, data, aturan);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        printButton = (Button) findViewById(R.id.print_button);
        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (bluetoothSPP.isBluetoothAvailable()) {
                        if (bluetoothSPP.isBluetoothEnabled()) {
                            bluetoothSPP.startService(BluetoothState.DEVICE_OTHER);
                            int cek = BluetoothState.REQUEST_CONNECT_DEVICE;
                            int cekk = AppCompatActivity.RESULT_OK;
//                            Toast.makeText(context, String.valueOf(cekk), Toast.LENGTH_SHORT).show();
                            String connected = bluetoothSPP.getConnectedDeviceName();
                            if (connected != "") {
                                bluetoothSPP.send(allMessage, true);
                                Toast.makeText(context, "Resep sedang dicetak", Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                Toast.makeText(context, "Perangkata anda tidak didukung", Toast.LENGTH_LONG).show();
                            }
//                    Toast.makeText(context, allMessage, Toast.LENGTH_LONG).show();
//                    bluetoothSPP.send(allMessage, true);
                        } else {
                            bluetoothSPP.enable();
                        }
                    } else {
                        Toast.makeText(context, "Perangkat anda tidak memiliki bluetooth", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public class CustomList extends ArrayAdapter<String> {
        private final AppCompatActivity context;
        private final ArrayList<String> data;
        private final ArrayList<String> aturan;

        public CustomList(AppCompatActivity context, ArrayList<String> data, ArrayList<String> aturan) {
            super(context, R.layout.list_single, data);
            this.context = context;
            this.data = data;
            this.aturan = aturan;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            View rowView = layoutInflater.inflate(R.layout.list_single, null, true);
            TextView dataTv = (TextView) rowView.findViewById(R.id.nama_dsb);
            TextView aturanTv = (TextView) rowView.findViewById(R.id.aturan_tv);

            dataTv.setText(data.get(position));
            aturanTv.setText(aturan.get(position));

            return rowView;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if(resultCode == Activity.RESULT_OK)
                bluetoothSPP.connect(data);
        } else if(requestCode == BluetoothState.REQUEST_ENABLE_BT) {
            if(resultCode == Activity.RESULT_OK) {
                bluetoothSPP.setupService();
                bluetoothSPP.startService(BluetoothState.DEVICE_OTHER);
            } else {
                Toast.makeText(getApplicationContext()
                        , "Bluetooth was not enabled."
                        , Toast.LENGTH_SHORT).show();
                finish();
            }
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
