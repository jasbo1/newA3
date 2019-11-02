package com.android3.ui.onboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.android3.R;
import com.android3.ui.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OnBoardActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 5 ;
    private Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);



        initViews();

    }

    private void initViews() {


        toolbar = findViewById(R.id.toolbarTransparent);
        String[] name = new String[]{"Первая страница", "Вторая", "Третья", "Четвертая "};
        int[] picture = new int[]{R.drawable.hi, R.drawable.update, R.drawable.delete, R.drawable.thank_you};
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab_layout);



        PagerAdapter adapter = new ViewPagerAdapter(OnBoardActivity.this, name, picture);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(adapter);

    }




    public static void start(Context context){
        context.startActivity(new Intent(context, OnBoardActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.skip) {
            

        }
        return super.onOptionsItemSelected(item);
    }
}


