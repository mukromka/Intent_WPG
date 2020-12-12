package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class thirdActivity extends AppCompatActivity implements View.OnClickListener{
    TextView addNama;
    Button btnPindaActivity1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        addNama = findViewById(R.id.add_nama);
        btnPindaActivity1 = findViewById(R.id.btn_pindah_activity1);
        btnPindaActivity1.setOnClickListener(this);
        String nama = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);

        if (TextUtils.isEmpty(nama)) {
            addNama.setText("Tidak ada nama yang diinputkan! ");
        } else {
            addNama.setText("Nama saya " + nama);
        }
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pindah_activity1:
                pindaActivity1TanpaData();
        }
    }
    private void pindaActivity1TanpaData(){
        String nama = getIntent().getStringExtra(MainActivity.EXTRA_NAMA);
        Intent moveIntent = new Intent( thirdActivity.this,MainActivity.class);
        moveIntent.putExtra(MainActivity.EXTRA_NAMA,nama);
        startActivity(moveIntent);
    }
}