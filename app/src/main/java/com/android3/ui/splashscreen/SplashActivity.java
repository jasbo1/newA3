package com.android3.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.android3.App;
import com.android3.R;
import com.android3.ui.main.MainActivity;
import com.android3.ui.onboard.OnBoardActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activitySelectorWithTimer ();
    }


    private void activitySelectorWithTimer() {
        int DELAY = 1000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selectActivity();

            }
        }, DELAY); // handler для  на секунду посмотреть на сплеш скрин при входе
    }


        private void selectActivity(){

       if (App.getPreference().getFirstLaunch()){
           App.getPreference().setFirstLaunch();
           OnBoardActivity.start(this);

       }else {
           OnBoardActivity.start(this);

          // MainActivity.start(this);

       }
       finish();
}

}
