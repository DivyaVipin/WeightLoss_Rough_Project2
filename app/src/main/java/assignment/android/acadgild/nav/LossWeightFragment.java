package assignment.android.acadgild.nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import assignment.android.acadgild.R;
import assignment.android.acadgild.losskgs.FifthDay;
import assignment.android.acadgild.losskgs.FirstDay;
import assignment.android.acadgild.losskgs.FourthDay;
import assignment.android.acadgild.losskgs.SecondDay;
import assignment.android.acadgild.losskgs.SeventhDay;
import assignment.android.acadgild.losskgs.SixthDay;
import assignment.android.acadgild.losskgs.ThirdDay;

/**
 * Created by DivyaVipin on 1/16/2017.
 */

public class LossWeightFragment  extends AppCompatActivity implements View.OnClickListener{
    Button btnFirst;
    Button btnSecond;
    Button btnThird;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lossweight_fragment);
        btnFirst = (Button) findViewById(R.id.btnDay1);
        btnSecond = (Button) findViewById(R.id.btnDay2);
        btnThird = (Button) findViewById(R.id.btnDay3);
        btnFour = (Button) findViewById(R.id.btnDay4);
        btnFive = (Button) findViewById(R.id.btnDay5);
        btnSix = (Button) findViewById(R.id.btnDay6);
        btnSeven = (Button) findViewById(R.id.btnDay7);
        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnThird.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        //return myView;
    }



    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnDay1:
            {
                Intent i=new Intent(this,FirstDay.class);
                startActivity(i);
                break;
            }
            case R.id.btnDay2:
            {
                Intent i=new Intent(this,SecondDay.class);
                startActivity(i);
                break;
            }
            case R.id.btnDay3:
            {
                Intent i=new Intent(this,ThirdDay.class);
                startActivity(i);
                break;
            }
            case R.id.btnDay4:
            {
                Intent i=new Intent(this,FourthDay.class);
                startActivity(i);
                break;
            }
            case R.id.btnDay5:
            {
                Intent i=new Intent(this, FifthDay.class);
                startActivity(i);
                break;
            }
            case R.id.btnDay6:
            {
                Intent i=new Intent(this,SixthDay.class);
                startActivity(i);
                break;
            }
            case R.id.btnDay7:
            {
                Intent i=new Intent(this,SeventhDay.class);
                startActivity(i);
                break;
            }
            default:
                break;
        }

    }
}
