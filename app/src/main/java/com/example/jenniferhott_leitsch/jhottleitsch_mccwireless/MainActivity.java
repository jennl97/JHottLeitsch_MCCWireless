package com.example.jenniferhott_leitsch.jhottleitsch_mccwireless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double discountRate = .10;
    int numberOfPhone;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText phones = (EditText)findViewById(R.id.hint);
        final CheckBox radOne = (CheckBox) findViewById(R.id.radOne);
        final CheckBox radTwo = (CheckBox)findViewById(R.id.radTwo);
        final CheckBox radThree = (CheckBox)findViewById(R.id.radThree);
        final TextView results = (TextView)findViewById(R.id.txtDisplay);
        Button convert = (Button)findViewById(R.id.btnCalc);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int offersSelected = 0;
                double planPrice = 0;
                DecimalFormat tenth = new DecimalFormat("$###,###.00");
                if (radThree.isChecked()){
                    offersSelected++;
                    planPrice += 25;
                }
                if (radTwo.isChecked()){
                    offersSelected++;
                    planPrice += 15;
                }
                if (radOne.isChecked()){
                    offersSelected++;
                    try {
                        numberOfPhone = Integer.parseInt(phones.getText().toString());
                        planPrice += 40 * numberOfPhone;
                    }
                    catch (Exception ex){
                        Toast.makeText(MainActivity.this, "Please enter a valid number of phones",Toast.LENGTH_LONG).show();
                    }
                }
                if(offersSelected>1){
                    planPrice = planPrice - (planPrice*discountRate);
                }
                results.setText("Total plan is " + tenth.format(planPrice));

            }
        });

     }
}
