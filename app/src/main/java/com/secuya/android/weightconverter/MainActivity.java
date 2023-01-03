package com.secuya.android.weightconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversion_rate = 2.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Set up the custom logo
         */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /**
         * Instantiate the Views components
         */
        EditText weight = (EditText) findViewById(R.id.txtWeight);      // Number is an input
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton lbToKilo = (RadioButton) findViewById(R.id.radLbToKilo);
        RadioButton kiloToLb = (RadioButton) findViewById(R.id.radKiloToLb);
        TextView result = (TextView) findViewById(R.id.txtResult);
        Button btnConvert = (Button) findViewById(R.id.btnConvert);

        /**
         * @Todo Add event handling to the convert button
         */
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch the weight entered by the user as an input
                double tmp_weight = Double.parseDouble(weight.getText().toString());

                // Formatting the precision values (decimal values)
                DecimalFormat df = new DecimalFormat("#.#");

                // Check if any of the buttons inside the radio group is checked (selected)
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are selected
                }

                else {
                    if (lbToKilo.isChecked()) {
                        if (tmp_weight <= 500) {
                            // @todo Pounds to Kilograms convert
                            double conv_weight = tmp_weight/conversion_rate;
                            result.setText("Kilograms: "+ df.format(conv_weight));
                        }
                        else {
                            // Display a Toast message when input validation is false
                            Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                        }
                    }

                    else if (kiloToLb.isChecked()) {
                        if (tmp_weight <= 225) {
                            // @todo Kilograms to Pounds convert
                            double conv_weight = tmp_weight*conversion_rate;
                            result.setText("Pounds: "+ df.format(conv_weight));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Kilograms must be less than 225", Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }
        });

    }
}