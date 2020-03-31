package com.awak25.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput1, edtInput2;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput1 = findViewById(R.id.edt_input1);
        edtInput2 = findViewById(R.id.edt_input2);
        tvHasil = findViewById(R.id.tv_hasil);
    }

    public void aksiKali(View v){
        aksiHitung("*");
    }
    public void aksiBagi(View v){
        aksiHitung("/");
    }
    public void aksiTambah(View v){
        aksiHitung("+");
    }
    public void aksiKurang(View v){
        aksiHitung("-");
    }
    public void aksiHitung(String aritmatika){

        String angka1 = edtInput1.getText().toString();
        String angka2 = edtInput2.getText().toString();

        if (TextUtils.isEmpty(angka1)){
            edtInput1.setError("Silahkan Inputkan Angka");
        }else if (TextUtils.isEmpty(angka2)){
            edtInput2.setError("Silahkan Inputkan Angka");
        }else{
            double a1 = Double.parseDouble(angka1);
            double a2 = Double.parseDouble(angka2);
            double hasil = 0;

            switch (aritmatika){
                case "*":
                    hasil = a1 * a2;
                    break;
                case "/":
                    hasil = a1 / a2;
                    break;
                case "+":
                    hasil = a1 + a2;
                    break;
                case "-":
                    hasil = a1 - a2;
                    break;

                    default:
                        break;
            }
            DecimalFormat fr = new DecimalFormat("0.###");
            tvHasil.setText(fr.format(hasil));
        }

    }


}
