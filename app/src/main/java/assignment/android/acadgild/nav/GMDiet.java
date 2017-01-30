package assignment.android.acadgild.nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import assignment.android.acadgild.R;
/**
 * Created by DivyaVipin on 1/16/2017.
 */

public class GMDiet  extends AppCompatActivity{
    FloatingActionButton fab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gm_diet);
        fab=(FloatingActionButton)findViewById(R.id.btnAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lossweight=new Intent(GMDiet.this,LossWeightFragment.class);
                startActivity(lossweight);

            }
        });
    }

}
