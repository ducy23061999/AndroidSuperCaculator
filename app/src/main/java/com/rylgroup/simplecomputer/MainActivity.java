package com.rylgroup.simplecomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPTB1;
    Button btnPTB2;
    Button btnNguyenTo;
    Button btnGiaiThua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnPTB1 = (Button) findViewById(R.id.btnPTB1);
        btnPTB2 = (Button) findViewById(R.id.btnPTB2);
        btnNguyenTo = (Button) findViewById(R.id.btnNguyenTo);
        btnGiaiThua = (Button) findViewById(R.id.btnGiaiThua);


        btnPTB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPTB1(v);
            }
        });

        btnPTB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPTB2(v);
            }
        });

        btnNguyenTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSoNguyen(v);
            }
        });

        btnGiaiThua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGiaiThua(v);
            }
        });
    }

    private void onClickPTB1(View v) {
        Intent intent = new Intent(this, PTBac1.class);
        startActivity(intent);
    }

    private void onClickPTB2(View v) {
        Intent intent = new Intent(this, PTBac2.class);
        startActivity(intent);
    }

    private void onClickSoNguyen(View v) {
        Intent intent = new Intent(this, SoNguyenTo.class);
        startActivity(intent);
    }

    private void onClickGiaiThua(View v) {
        Intent intent = new Intent(this, GiaiThua.class);
        startActivity(intent);
    }
}