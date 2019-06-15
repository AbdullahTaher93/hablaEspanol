package com.example.hablaespaol;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class adpter3 extends BaseAdapter {
    private static LayoutInflater layoutInflater=null;
    Context context;
    String data[];

    public adpter3(Context context,String statement[]){
        this.context=context;
        this.data=statement;



        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;


    }

    @Override
    public int getCount() {

        return data.length;
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

        titel.setText(data[position]);



        return view;
    }
}
