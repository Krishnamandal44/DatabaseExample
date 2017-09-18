package com.example.krishna.databaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDelete extends AppCompatActivity {
    ApplicationConstant app;
    EditText et_name,et_phoneno;
    Button bt_update,bt_delete;
    String s_id="",s_name="",s_phno="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        et_name=(EditText)findViewById(R.id.et_name);
        et_phoneno=(EditText)findViewById(R.id.et_phoneno);
        bt_update=(Button)findViewById(R.id.bt_update);
        bt_delete=(Button)findViewById(R.id.bt_delete);
        app=(ApplicationConstant)getApplication();
        s_id=getIntent().getExtras().getString("ID");
        et_name.setText(getIntent().getExtras().getString("NAME"));
        et_phoneno.setText(getIntent().getExtras().getString("PHNO"));
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseEmp obj=new BaseEmp(app);
                boolean res=obj.UpdateData(s_id,et_name.getText().toString(),et_phoneno.getText().toString());
                if (res==true){
                    Toast.makeText(UpdateDelete.this,"success",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(UpdateDelete.this,"falior",Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(UpdateDelete.this,StudentShow.class));
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseEmp obj1=new BaseEmp(app);
                boolean res=obj1.DeleteData(s_id);
                if (res==true){
                    Toast.makeText(UpdateDelete.this,"success",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(UpdateDelete.this,"falior",Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(UpdateDelete.this,StudentShow.class));
            }
        });

    }
}
