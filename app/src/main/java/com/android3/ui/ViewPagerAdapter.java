package com.android3.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.android3.App;
import com.android3.R;
import com.android3.ui.main.MainActivity;
import com.android3.ui.onboard.OnBoardActivity;


public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] name;
    private int[] picture;

    public ViewPagerAdapter(Context context, String[] name,  int[] picture) {
        this.context = context;
        this.name = name;
        this.picture = picture;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        TextView textView;
        ImageView avatarImageView;
        Button button;


        LayoutInflater inflater = LayoutInflater.from (context);

        ViewGroup layout =(ViewGroup) inflater.inflate(R.layout.item_view_pager, container,   ////
                false);


        avatarImageView = layout.findViewById(R.id.imageViewAvatar);
        avatarImageView.setImageResource(picture[position]);
        textView = layout.findViewById(R.id.textView1);
        textView.setText(name[position]);
        button = layout.findViewById(R.id.button_1);

        switch (position) {
            case 0:
                button.setText("Далее");
                break;
            case 1:
                button.setText("Далее ");
                break;
            case 2:
                button.setText("Далее  ");
                break;
            case 3:
                button.setText("Начинать");
                break;
           /* button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MainActivity.start(this);

                }});*/
        }



        container.addView(layout);
        return layout;

    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}


