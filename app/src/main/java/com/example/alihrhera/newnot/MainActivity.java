package com.example.alihrhera.newnot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView Show;
    private MyDataBas dataBas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Show=findViewById(R.id.Show);
        dataBas=new MyDataBas(MainActivity.this);


    }
    public void show(View v){

        ArrayList <String> list=dataBas.AllData();
        if(list.size()>0) {
            Show.setText("");
            for (int i = 0; i < list.size(); i++) {
                Show.append(list.get(i)+"\n");

            }
        }
    }
    public void Delete(View v){
        boolean delete= dataBas.deleterow();
        Show.setText(delete+"");
    }
    public void Insert(View v){
       boolean insert= dataBas.Insert();
        Show.setText(insert+"");
    }
    public void Update(View v){
        boolean update =dataBas.UpdateRow();
        Show.setText(update+"");
    }
}
