package com.example.alihrhera.newnot;

import android.content.Intent;
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
        show();

            findViewById(R.id.addnew).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,AddNewANot.class));
                }
            });

    }





    public void show(){

        ArrayList <String> list=dataBas.AllData();
        if(list.size()>0) {
            Show.setText("");
            for (int i = 0; i < list.size(); i++) {
                Show.append(list.get(i)+"\n");

            }
        }else {
            Show.setText("No Not's yet");


        }
    }

}
