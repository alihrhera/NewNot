package com.example.alihrhera.newnot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdpter extends RecyclerView.Adapter<MyViewHolder>  {
    Context context;
    private ArrayList<MyNot> datalist;
    public MyAdpter(ArrayList<MyNot> datalist,Context context){
        this.datalist=datalist;
        this.context=context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(viewGroup.getContext(),R.layout.my_row_design,null);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MyNot not=datalist.get(i);
        myViewHolder.content.setText(not.getContent());
        switch (not.getColor()){
            case 1:
                myViewHolder.content.setBackground(context.getResources().getDrawable(R.drawable.blue_bg));
                break;
            case 2:
                myViewHolder.content.setBackground(context.getResources().getDrawable(R.drawable.yellow_bg));
                break;

            case 3:
                myViewHolder.content.setBackground(context.getResources().getDrawable(R.drawable.red_bg));
                break;
        }
        if (i+1<datalist.size()){

            switch (datalist.get(i+1).getColor()){
                case 1:
                    myViewHolder.parnt.setBackgroundColor(context.getResources().getColor(R.color.blue));
                    break;
                case 2:
                    myViewHolder.parnt.setBackgroundColor(context.getResources().getColor(R.color.yellow));
                    break;
                case 3:
                    myViewHolder.parnt.setBackgroundColor(context.getResources().getColor(R.color.red));
                    break;
            }

        }


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
