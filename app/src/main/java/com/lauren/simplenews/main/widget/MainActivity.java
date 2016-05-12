package com.lauren.simplenews.main.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lauren.simplenews.R;
import com.lauren.simplenews.news.widget.NewsFragment;

/**
 * Author : Harry
 * Github  : https://github.com/HarryXR
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
    }

}
