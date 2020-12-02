package com.rylgroup.simplecomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PTBac1 extends AppCompatActivity {
    EditText editAx;
    EditText editB;
    TextView textKetQua;
    Button btnTinhQK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t_bac1);

    }

    @Override
    protected void onStart() {
        super.onStart();
        editAx = (EditText) findViewById(R.id.Ea);
        editB = (EditText) findViewById(R.id.Eb);
        textKetQua = (TextView) findViewById(R.id.TVKq);
        btnTinhQK = (Button) findViewById(R.id.btnTinhKQ);
        btnTinhQK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTinhKQ(v);
            }
        });
    }

    void onClickTinhKQ(View v) {
        String strA = editAx.getText().toString();
        String strB = editB.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        if (a == 0) {
            if (b == 0) {
                textKetQua.setText("Phương trình có vô số nghiệm");
                return;
            }

            else {
                textKetQua.setText("Phương trình vô nghiệm");
                return;
            }
        }

        float tinhKQ = tinhPTBacNhat(a, b);

        setKQ(textKetQua, tinhKQ);
    }

    void setKQ(TextView textView, float x) {
        textKetQua.setText(String.format("X = %f", x));

    }

    float tinhPTBacNhat(int a, int b) {
        float nghiem = 0;
        if (a != 0) {
            nghiem = (float) -b / a;
        }
        return nghiem;
    }
}