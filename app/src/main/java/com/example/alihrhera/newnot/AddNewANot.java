package com.example.alihrhera.newnot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddNewANot extends AppCompatActivity {

    private MyDataBas dataBas; //
    private EditText getNot;
    private int color;
    private RadioGroup colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_anot);

        dataBas=new MyDataBas(AddNewANot.this);
        getNot=findViewById(R.id.getNot);

         colors=findViewById(R.id.colors);
        colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int id=group.getCheckedRadioButtonId();
                    /* i will make for every color code
                    red =3
                    yellow=2
                    blue=1
                     */
                    switch (id){
                        case R.id.blue_btn :
                            color=1;
                            break;
                        case R.id. yellow_btn:
                            color=2;
                            break;
                        case R.id. red_btn:
                            color=3;
                            break;
                    }
            }
        });


        findViewById(R.id.Done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String not=getNot.getText().toString();
                Log.e("E",""+not);
                if (!not.isEmpty()&&not.length()>2){
                    int id=colors.getCheckedRadioButtonId();
                    /* i will make for every color code
                    red =3
                    yellow=2
                    blue=1
                     */
                    switch (id){
                        case R.id.blue_btn :
                            color=1;
                            break;
                        case R.id. yellow_btn:
                            color=2;
                            break;
                        case R.id. red_btn:
                            color=3;
                            break;
                    }


                    if(dataBas.Insert(not,color)){
                      finish();
                    }
                }
            }
        });


    }
}
