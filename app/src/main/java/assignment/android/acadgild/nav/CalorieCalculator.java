package assignment.android.acadgild.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import assignment.android.acadgild.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyaVipin on 1/17/2017.
 */

public class CalorieCalculator  extends AppCompatActivity{
    Spinner gender;
    EditText weight,height,age;
    Button count;
    int calorie_value;
    String finalCalorie;
TextView textResult;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_calculator);
        textResult=(TextView)findViewById(R.id.txtViewResult) ;
        gender=(Spinner)findViewById(R.id.spnGender);
        weight=(EditText) findViewById(R.id.editTextWeight);
        height=(EditText)findViewById(R.id.editTextHeight) ;
        age=(EditText)findViewById(R.id.editTextAge) ;
        count=(Button) findViewById(R.id.btnCount);
        gender = (Spinner)findViewById(R.id.spnGender);
        String[] items = new String[] { "Male","Female" };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        gender.setAdapter(adapter);


        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedSpinnerValue=gender.getSelectedItem().toString();
                String s_weight=weight.getText().toString();
                int weight_value=Integer.parseInt(s_weight);
                String s_height=height.getText().toString();
                int height_value=Integer.parseInt(s_weight);
                String s_age=age.getText().toString();
                int age_value=Integer.parseInt(s_age);
                if (selectedSpinnerValue.equals("Male"))
                {
                    calorie_value = (int) Math.round(1.2 * (66 + (13.7 * weight_value) + (5 * height_value) - (6.8 * age_value)));
                }
                else
                {
                    calorie_value = (int) Math.round(1.2*(655 + (9.6 * weight_value) + (1.8 * height_value) - (4.7 * age_value)));
                }
                finalCalorie=calorie_value+"kcal/day";
                textResult.setText(finalCalorie);
            }
        });

    }
}
