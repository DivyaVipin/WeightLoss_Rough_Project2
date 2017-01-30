package assignment.android.acadgild.calorietracker.database;

/**
 * Created by DivyaVipin on 1/19/2017.
 */

public class Constants {

    //COLUMNS
  public  static final String ROW_ID="id";
    static final String ACTIVITY_NAME="activityname";
    static final String CALORIES ="calories";
    static final String ACTIVITY_DATE="activity_date";
    //DB
   public static final String DB_NAME="CALORIE_DB";
     public static final String TB_NAME="CALORIE_TB";
    static final int DB_VERSION=1;

    //CREATE TB
    static final String CREATE_TB="CREATE TABLE CALORIE_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "activityname TEXT NOT NULL ,"+"calories INTEGER NOT NULL,"+"activity_date TEXT NOT NULL);";

    //DROP TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;
}
