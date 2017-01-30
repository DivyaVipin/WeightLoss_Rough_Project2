package assignment.android.acadgild.calorietracker;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import assignment.android.acadgild.R;
import assignment.android.acadgild.calorietracker.database.*;
import assignment.android.acadgild.calorietracker.database.Constants;
import assignment.android.acadgild.calorietracker.listView.CalorieAdapter;
import assignment.android.acadgild.calorietracker.object.CalorieObject;

/**
 * Created by DivyaVipin on 1/19/2017.
 */

public class CalorieTracker extends AppCompatActivity{

    FloatingActionButton btnAdd;
    Dialog d;
    EditText calValueDialog;
    Spinner spactivity;
    String c_Value=null;
    int cValue=0;
    String activityname="";
    Button btnSave;
    DBAdapter db;
    Constants c;
    String cal_val_dialog;
    DatePicker datePicker;
    CalorieAdapter caladapter;
    String new_Calorie;
    int new_Calorie_value;
    ArrayList<CalorieObject> caloriedetails=new ArrayList<>();
    ListView lv;
int day,month,year;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_tracker);
       // final TextView maxCalorieBurned = (TextView) findViewById(R.id.txtViewMCalValue);
        btnAdd=(FloatingActionButton)findViewById(R.id.addDetails);
        lv=(ListView)findViewById(R.id.listViewCalorie) ;

        db=new DBAdapter(CalorieTracker.this);
        db.openDB();

        caladapter=new CalorieAdapter(this,caloriedetails);
        lv.setAdapter(caladapter);
        registerForContextMenu(lv);

        getCalorieDetails();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d=new Dialog(CalorieTracker.this);
                d.setTitle("Add Calorie Details");
                d.setContentView(R.layout.cal_track_dialog);

    calValueDialog = (EditText) d.findViewById(R.id.editTextCalorie);


                datePicker=(DatePicker)d.findViewById(R.id.datePickerDate) ;
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        day=i2;
                        year=i;
                        month=(i1+1);

                    }
                });
                spactivity=(Spinner)d.findViewById(R.id.spnActivity);

                String[] activities = new String[] { "Swimming","Walking","Dancing","Hockey" };
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(CalorieTracker.this,android.R.layout.simple_spinner_item,activities);
                spactivity.setAdapter(adapter);
             btnSave=(Button)d.findViewById(R.id.btnCSave);
                d.show();

                btnSave.setOnClickListener(new View.OnClickListener() {

                    String datemonthyear="";

                        String dmy = (day + "/" + month + "/" + year).toString();

                    @Override
                    public void onClick(View view) {
                        try {
                            new_Calorie=calValueDialog.getText().toString();
                            new_Calorie_value = Integer.parseInt(new_Calorie);
                        }
                        catch(NumberFormatException e)
                        {
                            new_Calorie_value=0;
                        }




                       // db.add(spactivity.getSelectedItem().toString(),Integer.parseInt(calValueDialog.getText().toString()),dmy);
                        db.add(spactivity.getSelectedItem().toString(),new_Calorie_value,dmy);
                        d.dismiss();
                        getCalorieDetails();

                    }
                });




            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.listViewCalorie) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Select the Action");

            menu.add(0, v.getId(), 0, "Delete");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition=info.position;
        int id=caladapter.getCalDetails().get(listPosition).getId();
        if(item.getTitle()=="Delete")
        {
            deleteDetails(id);

        }



        return super.onContextItemSelected(item);

    }

    private void getCalorieDetails()
    {
        caloriedetails.clear();
        CalorieObject calorieObject=null;
        Cursor c=db.retrieve();
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String activity_name=c.getString(1);
            int cal_value=c.getInt(2);
            String date=c.getString(3);
            calorieObject=new CalorieObject();
            calorieObject.setId(id);
           calorieObject.setActivity(activity_name);
calorieObject.setCalValue(cal_value);
            calorieObject.setDate(" "+date);
            caloriedetails.add(calorieObject);
        }
        lv.setAdapter(caladapter);

    }
    private void deleteDetails(int id)
    {
        Toast.makeText(getApplicationContext(), "This is deleted.", Toast.LENGTH_SHORT).show();

        db.deleteRecords(Constants.TB_NAME, Constants.ROW_ID+ " = '" +id+
                "' ", null);
        finish();
        getCalorieDetails();
    }
}
