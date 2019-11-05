package com.android3.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android3.R;

public class MainViewPagerFragment extends Fragment {


    public MainViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_activity_fragment, container, false);
      //  RelativeLayout relativeLayout = view.findViewById(R.id.liner);
        ImageView imageView = view.findViewById(R.id.imageView1);

        TextView textTitle = view.findViewById(R.id.weatherText);

      //  int pos = getArguments().getInt("pos");
        imageView.setImageResource(R.drawable.camera);
        textTitle.setText(" Привет");







        return view;
    }


}

