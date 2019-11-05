package com.android3.ui.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import com.android3.R;
import com.android3.data.entity.OnBoardEntity;
import com.android3.ui.main.MainActivity;

import java.util.ArrayList;


public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList <OnBoardEntity> resourse;



    public ViewPagerAdapter(ArrayList<OnBoardEntity> resourse) {
        this.resourse = resourse;

    }



    @Override
    public int getCount() {
        return resourse.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {

        TextView textView;
        ImageView avatarImageView;
        Button button;
        View view =  LayoutInflater.from (container.getContext()).inflate(R.layout.item_view_pager,null);


        avatarImageView = view.findViewById(R.id.imageViewAvatar);
        textView = view.findViewById(R.id.textView1);
        button = view.findViewById(R.id.button_1);

        avatarImageView.setImageDrawable(container.getContext().getResources().getDrawable(resourse.get(position).getImg()));
        textView.setText(resourse.get(position).getTitle());


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

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.start(container.getContext());
                    }
                });
                break;

        }



        container.addView(view);
        return view;

    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}


