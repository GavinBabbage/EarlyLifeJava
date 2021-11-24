package com.example.earlylife;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivitiesFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivitiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivitiesFragment newInstance(String param1, String param2) {
        ActivitiesFragment fragment = new ActivitiesFragment();
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
        View v = inflater.inflate(R.layout.fragment_activities, container, false);

        ImageButton shapesActivityGenerator = (ImageButton) v.findViewById(R.id.shapes_button);
        ImageButton numbersActivityGenerator = (ImageButton)v.findViewById(R.id.numbers_button);
        ImageButton loveActivityGenerator = (ImageButton) v.findViewById(R.id.love_button);
        ImageButton miscActivityGenerator = (ImageButton) v.findViewById(R.id.misc_button);

        shapesActivityGenerator.setOnClickListener(this);
        numbersActivityGenerator.setOnClickListener(this);
        loveActivityGenerator.setOnClickListener(this);
        miscActivityGenerator.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.shapes_button:
                //generate pie button clicked
                Intent shapesIntent = new Intent(getActivity(),ShapesActivity.class);
                startActivity(shapesIntent);
                break;
            case R.id.numbers_button:
                // generate bar button clicked
                Intent numbersIntent = new Intent(getActivity(),NumbersActivity.class);
                startActivity(numbersIntent);
                break;
            case R.id.love_button:
                // generate radar button clicked
                Intent loveIntent = new Intent(getActivity(),LoveActivity.class);
                startActivity(loveIntent);
                break;
            case R.id.misc_button:
                // generate radar button clicked
                Intent miscIntent = new Intent(getActivity(),MiscActivity.class);
                startActivity(miscIntent);
                break;


        }

    }
}