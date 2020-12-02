package com.rylgroup.simplecomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PTBac2 extends AppCompatActivity {
    EditText editAx2;
    EditText editBx;
    EditText editC;
    TextView textKetQua;
    Button btnTinhQK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t_bac2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editAx2 = (EditText) findViewById(R.id.Ea2);
        editBx = (EditText) findViewById(R.id.Eb);
        editC = (EditText) findViewById(R.id.Ec);
        textKetQua = (TextView) findViewById(R.id.textKQ);
        btnTinhQK = (Button) findViewById(R.id.btnTinhKQ);

        btnTinhQK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTinhKetQua(v);
            }
        });
    }

    void onClickTinhKetQua(View v) {
        int ax2 = getIntFromEditText(editAx2);
        int bx = getIntFromEditText(editBx);
        int c = getIntFromEditText(editC);

        if (ax2 == 0) {
            if (bx == 0) {
                if (c == 0) {
                    textKetQua.setText("Phương trình có vô số nghiệm");
                } else {
                    textKetQua.setText("Phương trình vô nghiệm");
                }
            } else {
                // PT bac Nhat
                float nghiem = tinhPTBacNhat(bx, c);
                textKetQua.setText(String.format("X = %f", nghiem));
            }
        } else {
            ArrayList<Float> result = tinhPTBac2(ax2, bx, c);

            setKQ(textKetQua, result);
        }

    }

    void setKQ(TextView textView, ArrayList<Float> resuFloats) {
        if (resuFloats.size() == 2) {
            textKetQua.setText(String.format("X1 = %f, X2 = %f", resuFloats.get(0), resuFloats.get(1)));
            return;
        }

        if (resuFloats.size() == 1) {
            textKetQua.setText(String.format("X = %f", resuFloats.get(0)));
            return;
        }

        textKetQua.setText("Phương trình vô nghiệm");


    }

    ArrayList<Float> tinhPTBac2(int a, int b, int c) {
        ArrayList<Float> result = new ArrayList<Float>();
        // tính delta
        float delta = b*b - 4*a*c;
        Log.d("APP", String.format("%f", delta));
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            result.add(x1);
            result.add(x2);

        } else if (delta == 0) {
            x1 = -b / (2 * a);
            result.add(x1);
        }

        return result;
    }

    float tinhPTBacNhat(int a, int b) {
        float nghiem = 0;
        if (a != 0) {
            nghiem = (float) -b / a;
        }
        return nghiem;
    }

    int getIntFromEditText(EditText editText) {
        String str = editText.getText().toString();
        return Integer.parseInt(str);
    }
}