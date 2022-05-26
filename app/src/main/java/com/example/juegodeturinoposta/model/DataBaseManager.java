package com.example.juegodeturinoposta.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.juegodeturinoposta.DataBaseHelper;

public class DataBaseManager {

    private Context context;
    private SQLiteDatabase database;
    private DataBaseHelper dbHelper;

    public DataBaseManager(Context context) {
        this.context = context;
    }

    public DataBaseManager open() throws SQLException {
        this.dbHelper = new DataBaseHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        this.dbHelper.close();
    }

    public void insert(PlayableCharacter playableCharacter){
        this.dbHelper = new DataBaseHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_CHARACTER_NAME, playableCharacter.getName());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_MAXHP, playableCharacter.getMaxHP());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_CURRHP, playableCharacter.getCurrentHP());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_LVL, playableCharacter.getLvl());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_XP, playableCharacter.getXp());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_ATKPTS, playableCharacter.getAtkPoints());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_DFDPTS, playableCharacter.getDfdPoints());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_AGLPTS, playableCharacter.getAgilityPoints());
        this.database.insert(DataBaseHelper.CHARACTER_TABLE,null, cv);
    }

    public Cursor fetch(){
        Cursor cursor = this.database.query(DataBaseHelper.CHARACTER_TABLE, new String[]{DataBaseHelper.COLUMN_CHARACTER_NAME, DataBaseHelper.COLUMN_CHARACTER_MAXHP, DataBaseHelper.COLUMN_CHARACTER_CURRHP, DataBaseHelper.COLUMN_CHARACTER_LVL, DataBaseHelper.COLUMN_CHARACTER_XP, DataBaseHelper.COLUMN_CHARACTER_ATKPTS, DataBaseHelper.COLUMN_CHARACTER_DFDPTS, DataBaseHelper.COLUMN_CHARACTER_AGLPTS}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, PlayableCharacter playableCharacter) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_CHARACTER_NAME, playableCharacter.getName());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_MAXHP, playableCharacter.getMaxHP());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_CURRHP, playableCharacter.getCurrentHP());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_LVL, playableCharacter.getLvl());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_XP, playableCharacter.getXp());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_ATKPTS, playableCharacter.getAtkPoints());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_DFDPTS, playableCharacter.getDfdPoints());
        cv.put(DataBaseHelper.COLUMN_CHARACTER_AGLPTS, playableCharacter.getAgilityPoints());
        return this.database.update(DataBaseHelper.CHARACTER_TABLE, cv, "_id = " + _id, null);
    }

    public void delete(long _id) {
        this.database.delete(DataBaseHelper.CHARACTER_TABLE, "_id=" + _id, null);
    }

}
