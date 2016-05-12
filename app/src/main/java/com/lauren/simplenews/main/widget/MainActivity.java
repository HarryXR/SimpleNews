package com.lauren.simplenews.main.widget;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.lauren.simplenews.R;
import com.lauren.simplenews.about.widget.AboutFragment;
import com.lauren.simplenews.adapter.BaseFragmentAdapter;
import com.lauren.simplenews.images.widget.ImageFragment;
import com.lauren.simplenews.news.widget.NewsFragment;
import com.lauren.simplenews.view.MainBottomTab;
import com.lauren.simplenews.weather.widget.WeatherFragment;

/**
 * Author : Harry
 * Github  : https://github.com/HarryXR
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private FrameLayout mBottom;
    private MainBottomTab mBottomTab;
    private BaseFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp);
        mBottom = (FrameLayout) findViewById(R.id.bottom);
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();

        initBottomView();
        mAdapter = new BaseFragmentAdapter(getFragmentManager());
        mAdapter.setFragments(new NewsFragment(), new ImageFragment(), new WeatherFragment(),new AboutFragment());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void initBottomView() {
        mBottomTab = (MainBottomTab) View.inflate(this, R.layout.main_bottom_tab, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottom.addView(mBottomTab, params);
        mBottomTab.setViewPager(mViewPager);
    }
}
