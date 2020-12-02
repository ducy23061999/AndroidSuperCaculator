package com.rylgroup.simplecomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GiaiThua extends AppCompatActivity {
    EditText editGiaiThua;
    TextView textKQ;
    Button btnTinhKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_thua);
    }

    @Override
    protected void onStart() {
        super.onStart();

        editGiaiThua = (EditText) findViewById(R.id.eTinhGiaThua);
        textKQ = (TextView) findViewById(R.id.textKQ);
        btnTinhKQ = (Button) findViewById(R.id.btnTinhKQ);

        btnTinhKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCLickTinhGiaThua(v);
            }
        });
    }

    void onCLickTinhGiaThua(View v) {
        int n = getIntFromEditText(editGiaiThua);
        if (n > 20) {
            long giaiThua = tinhGiaiThua(n);
            setKQ(textKQ, giaiThua);
        } else {
            textKQ.setText("Input quá lớn để tính giai thừa");
        }

    }

    int getIntFromEditText(EditText editText) {
        String str = editText.getText().toString();
        return Integer.parseInt(str);
    }
    long tinhGiaiThua(int n) {
       long giaiThua = 1;

       for (int i = 2; i <= n; i++) {
           giaiThua = giaiThua * i;
       }
       return giaiThua;
    }

    void setKQ(TextView textView, long giaiThua) {
        textView.setText(String.format("X = %d", giaiThua));
    }
}