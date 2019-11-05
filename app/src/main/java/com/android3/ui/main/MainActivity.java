package com.android3.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android3.R;
import com.android3.data.entity.weather.CurrentWeatherEntity;
import com.android3.data.network.RetrofitBuilder;
import com.android3.ui.onboard.ViewPagerAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.android3.BuildConfig.WEATHER_KEY;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPagerPogoda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      viewPagerPogoda = findViewById(R.id.viewPagerPogoda);
        initViewPager();


        RetrofitBuilder.getInstance().getCurrentWeather("Bishkek" , WEATHER_KEY)
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("asasdsd","bbbbb");
                        CurrentWeatherEntity data = response.body();
                        data.getWeather();
                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {
                        Log.d("asasdsd","bbbbb");

                    }
                });
    }

    private void initViewPager() {
        ViewPager viewPager=findViewById(R.id.viewPagerPogoda);
        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(),0));
    }


    public static void start(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }

}
