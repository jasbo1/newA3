package com.android3.ui.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.android3.R;
import com.android3.data.entity.OnBoardEntity;
import com.android3.ui.main.MainActivity;

import java.util.ArrayList;

public class OnBoardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ViewPager viewPager;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        initViews();
        setupViewPager();
        setupClickListener();

    }

    private void setupClickListener() {

    }

    private void initViews() {


        toolbar = findViewById(R.id.toolbarTransparent);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewPager);
        button = findViewById(R.id.button_1);
       /* String[] name = new String[]{"Первая страница", "Вторая", "Третья", "Четвертая "};
        int[] picture = new int[]{R.drawable.hi, R.drawable.update, R.drawable.delete, R.drawable.thank_you};*/


    }


     private void setupViewPager(){
         PagerAdapter adapter = new ViewPagerAdapter(getResourse());
         viewPager.setAdapter(adapter);

             }

     private ArrayList<OnBoardEntity> getResourse(){
        ArrayList<OnBoardEntity> list = new ArrayList<>();

        list.add(new OnBoardEntity( "Here you are may learn",R.drawable.hi));
        list.add(new OnBoardEntity( "Keep going ,keep moving",R.drawable.update));
        list.add(new OnBoardEntity( "And delete the tresh from your mind",R.drawable.delete));
        list.add(new OnBoardEntity( "Thank you go just ahead",R.drawable.thank_you));
        return list;
     }

    public static void start(Context context) {
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
        int id = item.getItemId();{
            if(id==R.id.skip);

        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(MenuItem item)
    {
      MainActivity.start(this);
    }

    public void jumpToPage(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

    }
}


