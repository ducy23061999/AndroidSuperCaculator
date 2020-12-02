package com.rylgroup.simplecomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SoNguyenTo extends AppCompatActivity {
    EditText editNguyenTo;
    TextView textKQ;
    Button btnTinhKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_nguyen_to);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editNguyenTo = (EditText) findViewById(R.id.eSoNguyenTo);
        textKQ = (TextView) findViewById(R.id.textKQ);
        btnTinhKQ = (Button) findViewById(R.id.btnTinhKQ);

        btnTinhKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickTinhKQ(v);
            }
        });
    }

    void onClickTinhKQ(View v) {
        try {
            int n = getIntFromEditText(editNguyenTo);
            boolean laSoNT = isSoNguyenTo(n);

            setKQ(textKQ, laSoNT);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Lỗi", "Dữ liệu đầu vào không hợp lệ");
        }
    }

    int getIntFromEditText(EditText editText) {
        String str = editText.getText().toString();
        return Integer.parseInt(str);
    }
    boolean isSoNguyenTo(int n) {
        int dem = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                dem++;
            }
        }

        if (dem == 1) {
            return true;
        } else {
            return false;
        }
    }
    void setKQ(TextView textView, boolean isSoNT) {
        if (isSoNT) {
            textView.setText("Là số nguyên tố");
        } else {
            textView.setText("Không phải là số nguyên tố");
        }
    }
    void showAlert(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(SoNguyenTo.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}