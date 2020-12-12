package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvNama, tvInstitusi;
    Button btnPindaActivity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvNama = findViewById(R.id.tv_nama);
        tvInstitusi = findViewById(R.id.tv_institusi);

        btnPindaActivity3 = findViewById(R.id.btn_pindah_activity3);
        btnPindaActivity3.setOnClickListener(this);

        String nama = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);
        String institusi = getIntent().getStringExtra(MainActivity.EXTRA_INSTITUSI);

        if (TextUtils.isEmpty(institusi)) {
            tvInstitusi.setText("Asal Institusi : ");
        } else {
            tvInstitusi.setText("Asal Institusi : " + institusi);
            if (TextUtils.isEmpty(nama)) {
                tvNama.setText("Nama : ");
            } else {
                tvNama.setText("Nama : " + nama);
            }
        }
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pindah_activity3:
            pindaActivity3Data();
        }
    }

    private void pindaActivity3Data() {
        String nama = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);
        Intent moveIntentActivity3 = new Intent( SecondActivity.this,thirdActivity.class);
        moveIntentActivity3.putExtra(MainActivity.EXTRA_NAMA,nama);

        startActivity(moveIntentActivity3);
    }
}