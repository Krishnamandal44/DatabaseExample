package com.example.krishna.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmp extends AppCompatActivity {
    ApplicationConstant app;
    EditText et_sname,et_phno;
    Button bt_save,bt_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);
        et_sname=(EditText)findViewById(R.id.et_sname);
        et_phno=(EditText)findViewById(R.id.et_phno);
        bt_save=(Button)findViewById(R.id.bt_save);
        bt_show=(Button)findViewById(R.id.bt_show);
        app=(ApplicationConstant)getApplication();
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseEmp obj=new BaseEmp(app);
                boolean res=obj.SaveData(et_sname.getText().toString(),et_phno.getText().toString());
                if (res==true){
                    Toast.makeText(AddEmp.this,"success",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddEmp.this,"falior",Toast.LENGTH_SHORT).show();
                }

            }
        });

        bt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                startActivity(new Intent(AddEmp.this,StudentShow.class));

            }
        });

    }
}
