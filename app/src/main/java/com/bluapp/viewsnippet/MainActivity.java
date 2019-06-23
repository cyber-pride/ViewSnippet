package com.bluapp.viewsnippet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setClipChildren(false);
        viewPager.setClipToPadding(false);
        viewPager.setOverScrollMode(2);
        displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int paddingToSet = width/10;
        viewPager.setPageMargin(20);
        viewPager.setPadding(paddingToSet, 0, paddingToSet, 0);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}
