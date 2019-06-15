package com.example.hablaespaol;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class adpter2 extends BaseAdapter {
    private static LayoutInflater layoutInflater=null;
    Context context;
    String data[][];
    int i;
    public adpter2(Context context,String statement[][],int i){
        this.context=context;
        this.data=statement;
        this.i=i;


        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;


    }

    @Override
    public int getCount() {

         return data[i].length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view=layoutInflater.inflate(R.layout.onestat,null);
        TextView titel=(TextView)view.findViewById(R.id.t1);
        titel.setText(data[i][position]);
        return view;
    }
}
