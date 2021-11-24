package com.example.earlylife;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class RadarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_chart);

        RadarChart radarChart = findViewById(R.id.radarChart);

        ArrayList<RadarEntry> times = new ArrayList<>();
        times.add(new RadarEntry(10101));
        times.add(new RadarEntry(7198));
        times.add(new RadarEntry(9871));
        times.add(new RadarEntry(8087));


//        ArrayList<RadarEntry> numbersTimes = new ArrayList<>();
//        numbersTimes.add(new RadarEntry(4321));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//        numbersTimes.add(new RadarEntry(0));
//
//        ArrayList<RadarEntry> shapesTimes = new ArrayList<>();
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(6543));
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(0));
//        shapesTimes.add(new RadarEntry(730));
//        shapesTimes.add(new RadarEntry(200));
//
//        ArrayList<RadarEntry> loveTimes = new ArrayList<>();
//        loveTimes.add(new RadarEntry(0));
//        loveTimes.add(new RadarEntry(0));
//        loveTimes.add(new RadarEntry(10987));
//        loveTimes.add(new RadarEntry(0));
//        loveTimes.add(new RadarEntry(160));
//        loveTimes.add(new RadarEntry(30));
//        loveTimes.add(new RadarEntry(365));
//
//        ArrayList<RadarEntry> miscTimes = new ArrayList<>();
//        miscTimes.add(new RadarEntry(0));
//        miscTimes.add(new RadarEntry(0));
//        miscTimes.add(new RadarEntry(0));
//        miscTimes.add(new RadarEntry(5678));
//        miscTimes.add(new RadarEntry(660));
//        miscTimes.add(new RadarEntry(20));
//        miscTimes.add(new RadarEntry(0));


        RadarDataSet radarDataSetForTimes = new RadarDataSet(times,"TIME(MINUTES)");
        radarDataSetForTimes.setColor(Color.BLUE);
        radarDataSetForTimes.setLineWidth(2f);
        radarDataSetForTimes.setValueTextColor(Color.BLUE);
        radarDataSetForTimes.setValueTextSize(14f);


//
//
//
//        RadarDataSet radarDataSetForNumbers = new RadarDataSet(numbersTimes,"LOVE");
//        radarDataSetForNumbers.setColor(Color.RED);
//        radarDataSetForNumbers.setLineWidth(2f);
//        radarDataSetForNumbers.setValueTextColor(Color.RED);
//        radarDataSetForNumbers.setValueTextSize(14f);
//
//        RadarDataSet radarDataSetForShapes = new RadarDataSet(shapesTimes,"MISCELLANEOUS");
//        radarDataSetForShapes.setColor(Color.BLUE);
//        radarDataSetForShapes.setLineWidth(2f);
//        radarDataSetForShapes.setValueTextColor(Color.BLUE);
//        radarDataSetForShapes.setValueTextSize(14f);
//
//        RadarDataSet radarDataSetForLove = new RadarDataSet(loveTimes,"NUMBERS");
//        radarDataSetForLove.setColor(Color.MAGENTA);
//        radarDataSetForLove.setLineWidth(2f);
//        radarDataSetForLove.setValueTextColor(Color.MAGENTA);
//        radarDataSetForLove.setValueTextSize(14f);
//
//        RadarDataSet radarDataSetForMisc = new RadarDataSet(miscTimes,"SHAPES");
//        radarDataSetForMisc.setColor(Color.GREEN);
//        radarDataSetForMisc.setLineWidth(2f);
//        radarDataSetForMisc.setValueTextColor(Color.GREEN);
//        radarDataSetForMisc.setValueTextSize(14f);


        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSetForTimes);
//        radarData.addDataSet(radarDataSetForNumbers);
//        radarData.addDataSet(radarDataSetForShapes);
//        radarData.addDataSet(radarDataSetForLove);
//        radarData.addDataSet(radarDataSetForMisc);

        String[] labels = {"LOVE","MISC","NUMBERS","SHAPES"};

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setAxisLineColor(Color.BLACK);
        xAxis.setGridColor(Color.BLACK);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            radarChart.setBackground(getDrawable(R.drawable.elephantstars));
        }
        else{
            radarChart.setBackgroundColor(Color.WHITE);
        }
        radarChart.getDescription().setText("Time spent on each activity illustrated as radar chart");
        radarChart.getDescription().setTextColor(Color.BLUE);
        radarChart.getDescription().setTextSize(14f);
        //radarChart.getDescription().setPosition(900,50);
        radarChart.setData(radarData);
        radarChart.animateXY(2000,2000);
    }
}