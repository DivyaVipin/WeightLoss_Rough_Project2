package assignment.android.acadgild.calorietracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DivyaVipin on 1/19/2017.
 */

public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;
    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DB
    public void openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //INSERT DATA
    public boolean add(String activity,int calories,String date)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.ACTIVITY_NAME,activity);
            cv.put(Constants.CALORIES,calories);
            cv.put(Constants.ACTIVITY_DATE,date);
            db.insert(Constants.TB_NAME,null, cv);//If inserted return long value

            return true;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //RETRIEVE DATA AND FILTER
    public Cursor retrieve()
    {
        String[] columns={Constants.ROW_ID,Constants.ACTIVITY_NAME,Constants.CALORIES,Constants.ACTIVITY_DATE
        };
        Cursor c=null;
        c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);
        return c;
    }
    public int updateRecords(String table, ContentValues values,
                             String whereClause, String[] whereArgs) {
        int a = db.update(table, values, whereClause, whereArgs);
        return a;
    }




    public void deleteRecords(String table, String whereClause, String[] whereArgs){
        db.delete(table, whereClause, whereArgs);
    }

    public void delete(SQLiteDatabase db)
    {
        db.execSQL(Constants.DROP_TB);
    }
}
