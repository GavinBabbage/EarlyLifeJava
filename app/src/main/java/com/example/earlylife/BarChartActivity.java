package com.example.earlylife;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<String>labels = new ArrayList<>();
        labels.add("");
        labels.add("LOVE");
        labels.add("MISC");
        labels.add("NUMBERS");
        labels.add("SHAPES");

        //barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));



        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
        xAxis.setDrawLabels(true);
        xAxis.setGranularity(1f);
        //xAxis.setLabelRotationAngle(+90);

        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));





        ArrayList<BarEntry> activityTimes = new ArrayList<>();
        //activityTimes.add(new BarEntry(Float.parseFloat(barChart.getXAxis().getFormattedLabel(0)),420));
        activityTimes.add(new BarEntry(1,475));
        activityTimes.add(new BarEntry(2,475));
        activityTimes.add(new BarEntry( 3,508));
        activityTimes.add(new BarEntry(4,660));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            barChart.setBackground(getDrawable(R.drawable.elephantstars));
        }
        else{
            barChart.setBackgroundColor(Color.WHITE);
        }
        BarDataSet barDataSet = new BarDataSet(activityTimes,"TIME SPENT(MINUTES)");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Time spent on each activity illustrated as bar chart");
        barChart.getDescription().setTextSize(14f);
        barChart.animateY(2000);

    }
}