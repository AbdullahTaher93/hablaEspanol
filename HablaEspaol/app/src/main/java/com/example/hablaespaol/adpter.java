package com.example.hablaespaol;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class adpter extends BaseAdapter {

    private static LayoutInflater layoutInflater=null;
    Context context;
    String data[];
    int imgs[];
    public adpter(Context context,String statement[],int img[]){
        this.context=context;
        this.data=statement;
        this.imgs=img;

        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;
        Log.d("", "adpter: constrant"+statement[0]);


    }
    @Override
    public int getCount() {
        return imgs.length;
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
        final View view=layoutInflater.inflate(R.layout.onestatement,null);
        TextView titel=(TextView)view.findViewById(R.id.t1);
        ImageView productphoto=(ImageView)view.findViewById(R.id.im1);
        titel.setText(data[position]);
        productphoto.setImageResource(imgs[position]);
        productphoto.setTag(position);
        Log.d("asdasdasd", "getView: stat");
        return view;
    }
}
