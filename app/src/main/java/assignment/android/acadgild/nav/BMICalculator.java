package assignment.android.acadgild.nav;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import assignment.android.acadgild.R;
/**
 * Created by DivyaVipin on 1/16/2017.
 */

//Main activity class start here
public class BMICalculator extends AppCompatActivity {

    //Define layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

// Get the references to the widgets
        final EditText editTextHeight = (EditText) findViewById(R.id.etHeight);
        final EditText editTextWeight = (EditText) findViewById(R.id.etHeight);
        final TextView txtViewResult = (TextView) findViewById(R.id.tvResult);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = editTextHeight.getText().toString();
                String str2 = editTextWeight.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    editTextWeight.setError("Please enter your weight");
                    editTextWeight.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    editTextHeight.setError("Please enter your height");
                    editTextHeight.requestFocus();
                    return;
                }

//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                txtViewResult.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}