package assignment.android.acadgild.weightlossfoods;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import assignment.android.acadgild.R;


/**
 * Created by DivyaVipin on 1/16/2017.
 */

public class ChiaSeeds extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.chiaseeds_fragment,container,false);
        return rootView;
    }
}
