package com.example.krishna.databaseexample;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by KRISHNA on 11-05-2017.
 */

public class BaseEmp {
    ApplicationConstant app;
    public  BaseEmp(ApplicationConstant app){
        this.app=app;
    }
        public boolean SaveData(String name,String phoneno){
            ContentValues cv=new ContentValues();
            cv.put("name",name);
            cv.put("phoneno",phoneno);

            long success=-1;
            try {
                success=app.myDbHelper.MyDB().insert("EmployeeId",null,cv);
            }
            catch (Exception ex){
                success=-1;
            }
            if(success>-1){
                return true;
            }
            else {
                return false;
            }
        }
    public ArrayList<StudentSetGet> GetAllRecords(){
        if (app.myDbHelper.MyDB()==null)
            app.myDbHelper.openDataBase();
        ArrayList<StudentSetGet>arremplist=null;
        String sql="Select * from EmployeeId";
        Cursor cus=null;
        try{
            cus=app.myDbHelper.MyDB().rawQuery(sql,null);
            if (cus.getCount()>0){
                arremplist=new ArrayList<StudentSetGet>();
                while (cus.moveToNext()){
                    StudentSetGet objset=new StudentSetGet();
                    String id=cus.getString(cus.getColumnIndex("id"));
                    String name=cus.getString(cus.getColumnIndex("name"));
                    String phoneno=cus.getString(cus.getColumnIndex("phoneno"));
                    objset.setId(id);
                    objset.setName(name);
                    objset.setPhoneno(phoneno);
                    arremplist.add(objset);

                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if (cus!=null && !cus.isClosed()){
            cus.close();
        }
        return arremplist;

    }
    public boolean UpdateData(String id,String name,String phoneno){
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("phoneno",phoneno);
        long success=-1;
        try {
            success=app.myDbHelper.MyDB().update("EmployeeId",cv,"id=?",new String[]{id});
        }catch (Exception e){
            success=-1;
            e.printStackTrace();
        }
        if (success>-1){
            return true;
        }
        else
            return false;
    }
    public boolean DeleteData(String id){
        if(app.myDbHelper.MyDB()==null){
            app.myDbHelper.openDataBase();
        }
        Cursor cursor=null;
        String sql="DELETE FROM EmployeeId where id='"+id+"'";
        try {
            cursor=app.myDbHelper.MyDB().rawQuery(sql,null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (cursor!=null&&cursor.getCount()==0)
            return true;
        else
            return  false;
    }
}
