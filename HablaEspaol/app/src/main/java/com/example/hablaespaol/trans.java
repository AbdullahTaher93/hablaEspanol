package com.example.hablaespaol;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class trans extends AppCompatActivity {
    public static String stat="";
    public static String desc="";
    TextView t1,t2;
    ImageView imageView;

    public  static  int row=0;
    public  static int sound=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trans);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        imageView=(ImageView) findViewById(R.id.imageView);
        Button button=(Button)findViewById(R.id.button);
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,sound);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

            }
        });

        t1.setText(stat);
        t2.setText(desc);
        if(ch())
        {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.f2));
        }else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.f1));
        }


    }
    public void fav(View view){


            if(ch()) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.f1));
                MainActivity.descrfav[row]=false;
                MainActivity.fav[row]=null;
                MainActivity.fav2[row]=null;

            }
            else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.f2));
                MainActivity.descrfav[row]=true;
                MainActivity.fav[row]=stat;
                MainActivity.fav2[row]=desc;
                MainActivity.soun[row]=sound;

            }



    }
public boolean ch(){
        if(MainActivity.descrfav[row]==false)
            return false;
        else
        return true;
}

}
