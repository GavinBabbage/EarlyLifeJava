package com.example.earlylife;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatisticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_statistics, container, false);
        View v = inflater.inflate(R.layout.fragment_statistics, container, false);

        Button pieGenerator = (Button)v.findViewById(R.id.Generate_Pie_button);
        Button barGenerator = (Button)v.findViewById(R.id.Generate_Bar_button);
        Button radarGenerator = (Button)v.findViewById(R.id.Generate_Radar_button);

        pieGenerator.setOnClickListener(this);
        barGenerator.setOnClickListener(this);
        radarGenerator.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(),PieChartActivity.class);
//        startActivity(intent);

        switch(v.getId())
        {
            case R.id.Generate_Pie_button:
                //generate pie button clicked
                Intent pieIntent = new Intent(getActivity(),PieChartActivity.class);
                startActivity(pieIntent);
                break;
            case R.id.Generate_Bar_button:
                // generate bar button clicked
                Intent barIntent = new Intent(getActivity(),BarChartActivity.class);
                startActivity(barIntent);
                break;
            case R.id.Generate_Radar_button:
                // generate radar button clicked
                Intent radarIntent = new Intent(getActivity(),RadarChartActivity.class);
                startActivity(radarIntent);
                break;

        }


    }


}