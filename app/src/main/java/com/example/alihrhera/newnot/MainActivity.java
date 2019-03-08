package com.example.alihrhera.newnot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView Show;
    private MyDataBas dataBas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Show=findViewById(R.id.Show);
        dataBas=new MyDataBas(MainActivity.this);

            findViewById(R.id.addnew).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,AddNewANot.class));
                }
            });


        ShowAllData();
    }

    private void ShowAllData(){
        RecyclerView show=findViewById(R.id.Show);
        show.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MyNot> list=dataBas.AllData();
        MyAdpter adapter=new MyAdpter(list,MainActivity.this);
        show.setAdapter(adapter);
    }




    @Override
    protected void onResume() {
        ShowAllData();
        super.onResume();
    }
}
