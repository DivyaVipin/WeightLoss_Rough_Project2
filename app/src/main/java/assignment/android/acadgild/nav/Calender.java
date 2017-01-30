package assignment.android.acadgild.nav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import java.util.Calendar;

import assignment.android.acadgild.R;

/**
 * Created by DivyaVipin on 1/27/2017.
 */

public class Calender  extends AppCompatActivity{
    CalendarView calenderView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_view);
        calenderView=(CalendarView) findViewById(R.id.calendar);
    }
}
