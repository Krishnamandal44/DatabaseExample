package com.example.krishna.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentShow extends AppCompatActivity {
    ApplicationConstant app;
    ListView lv;
    ArrayList<StudentSetGet>arrlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_show);
        app = (ApplicationConstant) getApplication();
        lv = (ListView) findViewById(R.id.lv);
        BaseEmp obj = new BaseEmp(app);
        arrlist = obj.GetAllRecords();
        if (arrlist.size()>0) {
            MyAdapter obj1 = new MyAdapter();
            lv.setAdapter(obj1);
        }
        else {
            Toast.makeText(StudentShow.this, "No Data Found", Toast.LENGTH_SHORT).show();
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(StudentShow.this,""+arrlist.get(position).getId(),Toast.LENGTH_SHORT).show();
                Intent i=(new Intent(StudentShow.this,UpdateDelete.class));
                i.putExtra("ID",arrlist.get(position).getId());
                i.putExtra("NAME",arrlist.get(position).getName());
                i.putExtra("PHNO",arrlist.get(position).getPhoneno());
                startActivity(i);
                //startActivity(new Intent(StudentShow.this,UpdateDelete.class).putExtra("ID",arrlist.get(position).getId()));
            }
        });

    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrlist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            v=getLayoutInflater().inflate(R.layout.row,parent,false);
            TextView tv_id=(TextView)v.findViewById(R.id.tv_id);
            TextView tv_name=(TextView)v.findViewById(R.id.tv_name);
            TextView tv_phoneno=(TextView)v.findViewById(R.id.tv_phoneno);
            tv_id.setText(arrlist.get(position).getId());
            tv_name.setText(arrlist.get(position).getName());
            tv_phoneno.setText(arrlist.get(position).getPhoneno());

            return v;
        }
    }
}
