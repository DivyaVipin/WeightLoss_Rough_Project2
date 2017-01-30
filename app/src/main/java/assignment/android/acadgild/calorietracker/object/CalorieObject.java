package assignment.android.acadgild.calorietracker.object;

/**
 * Created by DivyaVipin on 1/19/2017.
 */

public class CalorieObject {
   public  CalorieObject()
    {

    }
    public CalorieObject(int id, String activity, int calValue,String date) {
        this.id = id;
        this.activity = activity;
        this.calValue = calValue;
        this.date=date;
    }

    private int id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalValue() {
        return calValue;
    }

    public void setCalValue(int calValue) {
        this.calValue = calValue;
    }

    private String activity;
    private int calValue;

}
