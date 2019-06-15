package com.example.hablaespaol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ListView listView,listView2,listView3;
    DataBaseConnection dataBaseConnection;
    String categories[]={"Alphabet","Numbers","Time","Restaurant"};
    int sound[]={R.raw.a,R.raw.b,R.raw.c,R.raw.d,R.raw.e,R.raw.f};
    int sound2[]={R.raw.one,R.raw.two,R.raw.three,R.raw.foure,R.raw.five};
    int sound4[]={R.raw.r1,R.raw.r2,R.raw.r3,R.raw.r4,R.raw.r5};
    int sound3[]={R.raw.t1,R.raw.t2,R.raw.t3,R.raw.t4,R.raw.t5};
    String statments[][]={{"A","B","C","D","E","F"},{"Uno","Dos","tres","Cuatro","Cinco"},{"Tomorrow","Night","Midnight","Now","Month"

    },{"I have a reserved table","how long to wait?","Do you accept credit cards?","We have not booked","Do you have a table for four persons?"}};
    String descriptions[][]={{"Mañana","Noche","Medianoche","Hora","Mes"},{"Tengo una mesa reservada","cuánto hay que esperar?",

            "aceptan tarjetas de crédito ?","no hemos reservado","tiene una mesa para cuatro?"}};
   public static boolean descrfav[]={false,false,false,false,false,false,false,false,false,false};

    public static String fav[]=new String[10];
    public static String fav2[]=new String[10];
    public static int soun[]=new int[10];

    public static String recently1[]=new String[10];
    public static String recently2[]=new String[10];
    public static int soun1[]=new int[10];


    int img[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
    DataBaseConnection db=new DataBaseConnection(this);
    adpter adpter1;
     adpter2 adpter22;
     int pos=0;
     int falge=0;

    final Context context=this;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:


                    listView.setAdapter(adpter1);
                    listView.setEnabled(true);
                    listView2.setVisibility(View.VISIBLE);
                    listView3.setVisibility(View.INVISIBLE);





                    return true;

                case R.id.navigation_notifications:

                    listView.setEnabled(false);
                    listView2.setVisibility(View.INVISIBLE);
                    listView3.setVisibility(View.VISIBLE);
                    listView3.setAdapter(adp3(context,recently1));
                    falge=1;
                    return true;
                case R.id.fav:

                    listView.setEnabled(false);
                    listView2.setVisibility(View.INVISIBLE);
                    listView3.setVisibility(View.VISIBLE);
                    listView3.setAdapter(adp3(context,fav));
                    falge=0;
                    return true;
            }
            return false;
        }
    };
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //SetData(db);

        listView=(ListView)findViewById(R.id.list_View);
        listView2=(ListView)findViewById(R.id.list_View2);
        listView3=(ListView)findViewById(R.id.list_View3);
       adpter1 =new adpter(this,categories,img);
        listView.setAdapter(adpter1);
        listView3.setVisibility(View.INVISIBLE);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                setadpter(position);

                pos=position;


            }
        });


        final Context context=this;
       listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {


           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               check(context,position);

           }
       });
listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        check1(context,position);

    }
});


    }










 public void setadpter(int i){
        adpter22=new adpter2(this,statments,i);
        listView2.setAdapter(adpter22);
 }


 public void check(Context context,int position){
     final Intent intent=new Intent(this,trans.class);

     if(pos==0){
         mediaPlayer =MediaPlayer.create(context,sound[position]);
         mediaPlayer.start();
     }
     if(pos==1){
         mediaPlayer =MediaPlayer.create(context,sound2[position]);
         mediaPlayer.start();
     }
     if(pos==2){

         trans.stat=statments[2][position];
         trans.sound=sound3[position];

         trans.desc=descriptions[0][position];
         Log.d("list2", "onItemClick: "+trans.stat+" "+trans.desc);
         trans.row=position;
         recently1[position]=statments[2][position];
         recently2[position]=descriptions[0][position];
         soun1[position]=sound3[position];
         startActivity(intent);

     }else if (pos==3){
         trans.stat=statments[3][position];
         trans.sound=sound4[position];
         trans.row=position+5;

         trans.desc=descriptions[1][position];
         Log.d("list2", "onItemClick: "+trans.stat+" "+trans.desc);
         recently1[position]=statments[3][position];
         recently2[position]=descriptions[1][position];
         soun1[position]=sound4[position];
         startActivity(intent);


     }

 }


    public void check1(Context context,int position){
        final Intent intent=new Intent(this,trans.class);


        if(falge==0){

            trans.stat=fav[position];
            trans.sound=soun[position];

            trans.desc=fav2[position];
            Log.d("list2", "onItemClick: "+trans.stat+" "+trans.desc);
            trans.row=position;


            startActivity(intent);

        }else if (falge==1){
            trans.stat=recently1[position];
            trans.sound=soun1[position];


            trans.desc=recently2[position];
            Log.d("list2", "onItemClick: "+trans.stat+" "+trans.desc);

            startActivity(intent);


        }

    }



public void setarray(Context context,String stat1[],String des1[],int s[] ){

        int j=0;
        for(int i=0;i<stat1.length;i++){
            if(stat1[i]!=null)
            {
                j++;

            }
        }
    String[] f1=new String[j];
    String[] f2=new String[j];

    int[] s1=new int[j];


    for(int i=0,k=0;i<stat1.length;i++){
        if(stat1[i]!=null)
        {
            f1[k]=stat1[i];
            f2[k]=stat1[i];
            s1[k]=s1[i];


        k++;
        }


    }

    adpter3 adpter3=new adpter3(context,f1);



}

public adpter3 adp3(Context context,String[] array){

       return (new adpter3(context,array));
}

}
