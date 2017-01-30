package assignment.android.acadgild.weighttips;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import assignment.android.acadgild.R;
import assignment.android.acadgild.weighttips.listView.WeightTipAdapter;

/**
 * Created by DivyaVipin on 1/20/2017.
 */

public class WeightLossTips  extends AppCompatActivity{

    private RecyclerView recyclerView;
    private WeightTipAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weightip_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // weightLossTips();
        mAdapter = new WeightTipAdapter();
        recyclerView.setAdapter(mAdapter);

    }

}
