//1. creas la clase que va a manejar todas las operaciones en la DB


package com.example.juegodeturinoposta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.juegodeturinoposta.model.PlayableCharacter;

//2. extendes SQLiteOpenHelper y traes a los metodos

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CHARACTER_TABLE = "CHARACTER_TABLE";
    public static final String COLUMN_CHARACTER_NAME = "CHARACTER_NAME";
    public static final String COLUMN_CHARACTER_MAXHP = "CHARACTER_MAXHP";
    public static final String COLUMN_CHARACTER_CURRHP = "CHARACTER_CURRHP";
    public static final String COLUMN_CHARACTER_LVL = "CHARACTER_LVL";
    public static final String COLUMN_CHARACTER_XP = "CHARACTER_XP";
    public static final String COLUMN_CHARACTER_ATKPTS = "CHARACTER_ATKPTS";
    public static final String COLUMN_CHARACTER_DFDPTS = "CHARACTER_DFDPTS";
    public static final String COLUMN_CHARACTER_AGLPTS = "CHARACTER_AGLPTS";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "character.db", null, 1);
    }

    //primera vez que accedes a la db
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CHARACTER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CHARACTER_NAME + " TEXT, " + COLUMN_CHARACTER_MAXHP + " INT, " + COLUMN_CHARACTER_CURRHP + " INT, " + COLUMN_CHARACTER_LVL + " INT, " + COLUMN_CHARACTER_XP + " INT, " + COLUMN_CHARACTER_ATKPTS + " INT, " + COLUMN_CHARACTER_DFDPTS + " INT, " + COLUMN_CHARACTER_AGLPTS + " INT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CHARACTER_TABLE");
        onCreate(db);

    }

//    public boolean addOne(PlayableCharacter character) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_CHARACTER_NAME, character.getName());
//        cv.put(COLUMN_CHARACTER_MAXHP, character.getMaxHP());
//        cv.put(COLUMN_CHARACTER_CURRHP, character.getCurrentHP());
//        cv.put(COLUMN_CHARACTER_LVL, character.getLvl());
//        cv.put(COLUMN_CHARACTER_XP, character.getXp());
//        cv.put(COLUMN_CHARACTER_ATKPTS, character.getAtkPoints());
//        cv.put(COLUMN_CHARACTER_DFDPTS, character.getDfdPoints());
//        cv.put(COLUMN_CHARACTER_AGLPTS, character.getAgilityPoints());
//
//        long insert = db.insert(CHARACTER_TABLE, null, cv);
//        if (insert == -1){
//            return false;
//        }
//        else {
//            return true;
//        }


    }


