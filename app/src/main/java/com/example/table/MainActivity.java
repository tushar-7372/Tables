package com.example.table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;
    public void generateTimesTable(int timesTableNumber)
    {
        ArrayList<String> timesTableContent=new ArrayList<String>();
        for(int j=1;j<200;j++)
            timesTableContent.add(Integer.toString(j*timesTableNumber));

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar=(SeekBar)findViewById(R.id.timesTableSeekBar);
         timesTableListView=findViewById(R.id.timesTableListView);

        //for setting max value to seek bar
        timesTableSeekBar.setMax(200);
        //for setting the launching value of progess
        timesTableSeekBar.setProgress(10);

        generateTimesTable(10);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Value",Integer.toString(progress));
                int min=1;
                int timesTableNumber;
                if(progress<min)
                    timesTableNumber=min;
                else
                    timesTableNumber=progress;

//                ListView timesTableListView=findViewById(R.id.timesTableListView);
               /* ArrayList<String> timesTableContent=new ArrayList<String>();
                for(int j=1;j<20;j++)
                    timesTableContent.add(Integer.toString(j*timesTableNumber));

                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);

                timesTableListView.setAdapter(arrayAdapter);*/
               generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}