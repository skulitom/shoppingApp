package back.end;

/**
 * Created by skulitom on 18/03/2016.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "shopingLists.db";
    ///////////////////////////////////////////////////////////// - item values
    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ITEM_NAME = "name";
    public static final String COLUMN_ITEM_TOTAL_PRICE = "price";
    public static final String COLUMN_ITEM_POUNDS = "pounds";
    public static final String COLUMN_ITEM_PENNIES = "pennies";
    public static final String COLUMN_ITEM_QUANTITY = "quantity";
    ///////////////////////////////////////////////////////////// - list values
    public static final String TABLE_LISTS = "lists";
    public static final String COLUMN_LIST_NAME = "name";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create an item table
        String queryItem = "CREATE TABLE " + TABLE_ITEMS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + "," +
                COLUMN_ITEM_NAME + " TEXT " + "," +
                COLUMN_ITEM_TOTAL_PRICE + " REAL " + "," +
                COLUMN_ITEM_POUNDS + " INTEGER " + "," +
                COLUMN_ITEM_PENNIES + " INTEGER " + "," +
                COLUMN_ITEM_QUANTITY + " INTEGER " +
                ");";

        // create a list table
        String queryList = "CREATE TABLE " + TABLE_LISTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " + "," +
                COLUMN_LIST_NAME + " TEXT " +
                ");";

        db.execSQL(queryItem);
        db.execSQL(queryList);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LISTS);
        onCreate(db);
    }
    // add an item to database
    public void addItem(item item){
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COLUMN_ITEM_NAME, item.getName());
        values.put(COLUMN_ITEM_QUANTITY, item.getQuantity());
        values.put(COLUMN_ITEM_TOTAL_PRICE, item.getTotalPrice());
        values.put(COLUMN_ITEM_POUNDS, item.getPounds());
        values.put(COLUMN_ITEM_PENNIES, item.getPennies());
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }
    // add a list to databse
    public void addList(itemList itemList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_LIST_NAME, itemList.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LISTS, null, values);
        db.close();
    }
    // delete item by name
    public void deleteItem(String itemName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ITEM_NAME + "=\"" + itemName + "\";");
    }
    // delete item by id
    public void deleteItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ID + "=\"" + id + "\";");
    }
    // delete list by name
    public void deleteList(String listName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LISTS + " WHERE " + COLUMN_LIST_NAME + "=\"" + listName + "\";");
    }
    // delete list by id
    public void deleteList(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LISTS + " WHERE " + COLUMN_ID + "=\"" + id + "\";");
    }
    public item getItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ID + "=\"" +id + "\";";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        item item = new item();
        if(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_ITEM_NAME))!=null) {
                item.setName(c.getString(c.getColumnIndex(COLUMN_ITEM_NAME)));
                item.setQuantity(c.getInt(2));
                item.setTotalPrice(c.getDouble(3));
                item.setPounds(c.getInt(4));
                item.setPennies(c.getInt(5));
            }
        }
        return item;
    }

    public item getItem(String name){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ITEM_NAME + "=\"" + name + "\";";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        item item = new item();
        if(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_ITEM_NAME))!=null) {
                item.setName(c.getString(c.getColumnIndex("COLUMN_ITEM_NAME")));
                item.setQuantity(c.getInt(c.getColumnIndex("COLUMN_ITEM_QUANTITY")));
                item.setTotalPrice(c.getDouble(c.getColumnIndex("COLUMN_ITEM_TOTAL_PRICE")));
                item.setPounds(c.getInt(c.getColumnIndex("COLUMN_ITEM_POUNDS")));
                item.setPennies(c.getInt(c.getColumnIndex("COLUMN_item_PENNIES")));
            }
        }
        return item;
    }
    public itemList getList(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_LISTS + " WHERE "+ COLUMN_ID + "=\"" + id + "\";";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        itemList list = new itemList();
        if(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_LIST_NAME))!=null) {
                list.setName(c.getString(c.getColumnIndex(COLUMN_LIST_NAME)));
            }
        }
        return list;
    }

    public itemList getList(String name){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_LISTS + " WHERE " + COLUMN_LIST_NAME + "=\"" + name + "\";";
        Cursor c = db.rawQuery(query,null);
        itemList list = new itemList();
        list.setName(c.getString(c.getColumnIndex("COLUMN_LIST_NAME")));
        return list;
    }

    public boolean checkListNull(itemList list){

        if(list.getName()==""||list.getName()==null){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkListNull(item item){

        if(item.getName()==""||item.getName()==null){
            return false;
        }else{
            return true;
        }
    }
    // print out the database
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";
        // cursor points to location in results
        Cursor c = db.rawQuery(query,null);
        // move cursor to first location
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("name"))!=null){
                dbString += c.getString(c.getColumnIndex("name"));
                dbString += "\n";
            }
        }
        c.moveToNext();
        db.close();

        return dbString;
    }
}
