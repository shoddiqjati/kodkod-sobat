package com.studio.kodkod.sobat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WriteReceiptActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton addReceiptBtn;
    Dialog dialog;
    Context context = this;
    Button viewBtn;
    ArrayAdapter<String> adapter;

    Spinner namaObatSpn;
    EditText sediaanEt, dosisEt, totalEt, aturanEt;
    Button doneBtn, sediaanNav, dosisNav, peresepanNav, kontraNav;
    TextView ketTv;

    int spinnerPosition = 0;
    String recordObat, recordSediaan, recordDosis, recordTotal, recordAturan;
    String infoSediaan, infoDosis, infoPeresepan, infoKontra;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_receipt);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("S-Obat");
        toolbar.setTitleTextColor(Color.WHITE);

        addReceiptBtn = (FloatingActionButton) findViewById(R.id.addReceiptBtn);
        viewBtn = (Button) findViewById(R.id.view_button);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteReceiptActivity.this, PreviewActivity.class);
                startActivity(intent);
            }
        });

        Data.rNamaObat.clear();
        Data.rBentukSediaan.clear();
        Data.rDosis.clear();
        Data.rTotal.clear();
        Data.rAturanPakai.clear();
        addReceiptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_receipt);
                dialog.setTitle("Resep Obat");
                namaObatSpn = (Spinner) dialog.findViewById(R.id.nama_obat_spinner);
                ArrayAdapter<String> arrayAdapter = new  ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, Data.namaObat);
                namaObatSpn.setAdapter(arrayAdapter);
                dialog.show();
                namaObatSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String post = String.valueOf(position);
                        recordObat = namaObatSpn.getItemAtPosition(position).toString();

                        spinnerPosition = Integer.parseInt(post);
                        infoSediaan = Data.bentukSediaan[spinnerPosition];
                        infoDosis = Data.dosis[spinnerPosition];
                        infoPeresepan = Data.peresepan[spinnerPosition];
                        infoKontra = Data.kontraIndikasi[spinnerPosition];

                        sediaanEt = (EditText) dialog.findViewById(R.id.edit_sediaan);
                        dosisEt = (EditText) dialog.findViewById(R.id.edit_dosis);
                        totalEt = (EditText) dialog.findViewById(R.id.edit_total);
                        aturanEt = (EditText) dialog.findViewById(R.id.edit_aturan);
                        doneBtn = (Button) dialog.findViewById(R.id.done_button);
                        sediaanNav = (Button) dialog.findViewById(R.id.sediaan_nav);
                        dosisNav = (Button) dialog.findViewById(R.id.dosis_nav);
                        peresepanNav = (Button) dialog.findViewById(R.id.peresepan_nav);
                        kontraNav = (Button) dialog.findViewById(R.id.kontra_nav);
                        ketTv = (TextView) dialog.findViewById(R.id.keterangan);

                        doneBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                recordSediaan = sediaanEt.getText().toString();
                                recordDosis = dosisEt.getText().toString();
                                recordTotal = totalEt.getText().toString();
                                recordAturan = aturanEt.getText().toString();

                                Data.rNamaObat.add(recordObat);
                                Data.rBentukSediaan.add(recordSediaan);
                                Data.rDosis.add(recordDosis);
                                Data.rTotal.add(recordTotal);
                                Data.rAturanPakai.add(recordAturan);

                                dialog.dismiss();
                                updateUI();
                            }
                        });
                        sediaanNav.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ketTv.setText(Data.bentukSediaan[spinnerPosition]);
                                ketTv.setVisibility(View.VISIBLE);
                                sediaanNav.setBackgroundResource(R.color.colorPrimaryDark);
                                dosisNav.setBackgroundResource(R.color.colorPrimary);
                                peresepanNav.setBackgroundResource(R.color.colorPrimary);
                                kontraNav.setBackgroundResource(R.color.colorPrimary);
                            }
                        });
                        dosisNav.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ketTv.setText(Data.dosis[spinnerPosition]);
                                ketTv.setVisibility(View.VISIBLE);
                                sediaanNav.setBackgroundResource(R.color.colorPrimary);
                                dosisNav.setBackgroundResource(R.color.colorPrimaryDark);
                                peresepanNav.setBackgroundResource(R.color.colorPrimary);
                                kontraNav.setBackgroundResource(R.color.colorPrimary);
                            }
                        });
                        peresepanNav.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ketTv.setText(Data.peresepan[spinnerPosition]);
                                ketTv.setVisibility(View.VISIBLE);
                                sediaanNav.setBackgroundResource(R.color.colorPrimary);
                                dosisNav.setBackgroundResource(R.color.colorPrimary);
                                peresepanNav.setBackgroundResource(R.color.colorPrimaryDark);
                                kontraNav.setBackgroundResource(R.color.colorPrimary);
                            }
                        });
                        kontraNav.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ketTv.setText(Data.kontraIndikasi[spinnerPosition]);
                                ketTv.setVisibility(View.VISIBLE);
                                sediaanNav.setBackgroundResource(R.color.colorPrimary);
                                dosisNav.setBackgroundResource(R.color.colorPrimary);
                                peresepanNav.setBackgroundResource(R.color.colorPrimary);
                                kontraNav.setBackgroundResource(R.color.colorPrimaryDark);
                            }
                        });
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        updateUI();
    }

    public void updateUI() {
        if (adapter != null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, Data.rNamaObat);
            listView.setAdapter(adapter);
            listView.setVisibility(View.VISIBLE);
            viewBtn.setVisibility(View.VISIBLE);
        } else {
            viewBtn.setVisibility(View.INVISIBLE);
            ArrayList<String> obatString = new ArrayList<>();
            obatString.add("");
            listView = (ListView) findViewById(R.id.list);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, obatString);
            listView.setAdapter(adapter);
            listView.setVisibility(View.INVISIBLE);
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
