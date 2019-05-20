package kylec.me.g2048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Created by KYLE on 2019/5/3 - 21:07
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GameActivity.start(this);
        finish();
    }
}
