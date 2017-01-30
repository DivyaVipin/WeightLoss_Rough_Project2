package assignment.android.acadgild.calorietracker.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import assignment.android.acadgild.R;
import java.util.ArrayList;

import assignment.android.acadgild.calorietracker.object.CalorieObject;

/**
 * Created by DivyaVipin on 1/19/2017.
 */

public class CalorieAdapter extends BaseAdapter{
    Context c;

    public ArrayList<CalorieObject> getCalDetails() {
        return calDetails;
    }

    public void setCalDetails(ArrayList<CalorieObject> calDetails) {
        this.calDetails = calDetails;
    }

    ArrayList<CalorieObject> calDetails;
    LayoutInflater inflater;
    public CalorieAdapter(Context c, ArrayList<CalorieObject> calDetails) {
        this.c = c;
        this.calDetails = calDetails;

    }


    @Override
    public int getCount() {
        return calDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return calDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { if(inflater==null)
    {
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
        if(view==null)
        {
            view=inflater.inflate(R.layout.calorie_tracker_listitem,viewGroup,false);
        }
        TextView cal_Txt= (TextView)view.findViewById(R.id.calText);
        Integer id=calDetails.get(i).getId();
        Integer a=calDetails.get(i).getCalValue();
        String cal_Val=a.toString();
        String date=calDetails.get(i).getDate();
        String activity_name=calDetails.get(i).getActivity();
        cal_Txt.setText("Id:"+id+"\n"+"Activity name: "+activity_name+"\n"+"Calories burned: "+cal_Val+"\n"+"Date: "+date);

        return view;

    }
}
