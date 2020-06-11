package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText principal, intrest, year;
Button calculate;
TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = (EditText) findViewById(R.id.principal);
        intrest = (EditText) findViewById(R.id.intrest);
        year = (EditText) findViewById(R.id.year);
        calculate = (Button) findViewById(R.id.calculate);
        result = (TextView) findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateEMI();
            }
        });
    }
    private void calculateEMI(){
     String principalStr = principal.getText().toString();
     String intrestStr = intrest.getText().toString();
     String yearStr = year.getText().toString();


        if (principalStr != null && !"".equals(principalStr) && intrestStr != null && !"".equals(intrestStr) &&yearStr != null && !"".equals(yearStr)){
            float principalValue = Float.parseFloat(principalStr) ;
            float intrestValue = Float.parseFloat(intrestStr)/12/100;
            float yearValue = Float.parseFloat(yearStr);


            float emi = principalValue * intrestValue * (1+intrestValue)*yearValue/((1+intrestValue)*yearValue-1);
            displayEMI(emi);
        }
    }
    private void displayEMI(float emi){
        String emiLable ="Your EMI is "+ emi;
     result.setText(emiLable);
    }
}