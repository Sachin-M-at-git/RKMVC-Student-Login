package com.example.rkmvcstudentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity {

    EditText su1,su2,su3,su4,su5,su6;

    Button cal,k1,k2,k3,k4,k5,k6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        su1=findViewById(R.id.sub1);
        su2=findViewById(R.id.sub2);
        su3 =findViewById(R.id.sub3);
        su4 =findViewById(R.id.sub4);
        su5 =findViewById(R.id.sub5);
        su6 =findViewById(R.id.sub6);
        cal=findViewById(R.id.calbutton);
        k1 =findViewById(R.id.keep1);
        k2 =findViewById(R.id.keep2);
        k3 =findViewById(R.id.keep3);
        k4 =findViewById(R.id.keep4);
        k5 =findViewById(R.id.keep5);
        k6 =findViewById(R.id.keep6);

        cal.setEnabled(false);
        su1.addTextChangedListener(textWatcher);
        su2.addTextChangedListener(textWatcher);
        su3.addTextChangedListener(textWatcher);
        su4.addTextChangedListener(textWatcher);
        su5.addTextChangedListener(textWatcher);
        su6.addTextChangedListener(textWatcher);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        su1.setText(prefs.getString("s1",""));
        su2.setText(prefs.getString("s2",""));
        su3.setText(prefs.getString("s3",""));
        su4.setText(prefs.getString("s4",""));
        su5.setText(prefs.getString("s5",""));
        su6.setText(prefs.getString("s6",""));

        k1.setOnClickListener(view -> {
            commonPrefm(su1.getText().toString(),"1");
        });

        k2.setOnClickListener(view -> {
            commonPrefm(su2.getText().toString(),"2");
        });

        k3.setOnClickListener(view -> {
            commonPrefm(su3.getText().toString(),"3");
        });

        k4.setOnClickListener(view -> {
            commonPrefm(su4.getText().toString(),"4");
        });

        k5.setOnClickListener(view -> {
            commonPrefm(su5.getText().toString(),"5");
        });

        k6.setOnClickListener(view -> {
            commonPrefm(su6.getText().toString(),"6");
        });

    }

    private void commonPrefm(String s, String i) {
        //to save data
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(CalculatorActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("s"+i, s);
        editor.apply();
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String s1 = su1.getText().toString();
            String s2 = su2.getText().toString();
            String s3 = su3.getText().toString();
            String s4 = su4.getText().toString();
            String s5 = su5.getText().toString();
            String s6 = su6.getText().toString();

            cal.setEnabled(!(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty()));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void calculate(View view) {
        double s1 = Double.parseDouble(su1.getText().toString());
        double s2 = Double.parseDouble(su2.getText().toString());
        double s3 = Double.parseDouble(su3.getText().toString());
        double s4 = Double.parseDouble(su4.getText().toString());
        double s5 = Double.parseDouble(su5.getText().toString());
        double s6 = Double.parseDouble(su6.getText().toString());

        double r = (s1+s2+s3+s4+s5+s6)/6;

        TextView v=findViewById(R.id.result);
        String result;
        if((String.valueOf(r)).length()<=4) {
            result = String.valueOf(r)+"%";
        } else{
            result = (String.valueOf(r)).substring(0,5)+"%";
        }

        v.setText(result);
    }
}