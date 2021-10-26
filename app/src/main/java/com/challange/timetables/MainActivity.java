package com.challange.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timeTablesSeekbar = findViewById(R.id.seekBar);
        timesTablesListView = findViewById(R.id.listView);

        int max = 20;
        int startingPosition = 1;

        timeTablesSeekbar.setMax(max);
        timeTablesSeekbar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        timeTablesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if (i < min){
                    timesTableNumber = min;
                    timeTablesSeekbar.setProgress(min);
                }else{
                    timesTableNumber = i;
                }

                Log.i("Seekbar Value", Integer.toString(timesTableNumber));

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
    public void generateTimesTable(int timeTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 100; j++){
            timesTableContent.add(Integer.toString(j * timeTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTablesListView.setAdapter(arrayAdapter);

    }

}