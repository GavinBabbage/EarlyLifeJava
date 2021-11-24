package com.example.earlylife;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> activityTimes = new ArrayList();
        activityTimes.add(new PieEntry(600,"LOVE"));
        activityTimes.add(new PieEntry(508,"MISC"));
        activityTimes.add(new PieEntry(750,"NUMBERS"));
        activityTimes.add(new PieEntry(400,"SHAPES"));

        PieDataSet pieDataSet = new PieDataSet(activityTimes, "TIME SPENT(MINUTES)");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pieChart.setBackground(getDrawable(R.drawable.elephantstars));
        }
        else{
            pieChart.setBackgroundColor(Color.WHITE);
        }

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setText("Time spent on each activity illustrated as pie chart");
        pieChart.getDescription().setTextSize(14f);
        pieChart.setCenterText("TIME SPENT(MINUTES)");
        pieChart.animateXY(2000,2000);
    }
}