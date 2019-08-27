package com.bluapp.viewsnippet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_viewactivity2:
                startActivity(new Intent(MainActivity.this, ViewActivity2.class));
                return true;

            case R.id.action_viewactivity3:
                startActivity(new Intent(MainActivity.this, ExpansionPanelActivity3.class));
                return true;

            case R.id.action_viewactivity4:
                startActivity(new Intent(MainActivity.this, DocProfileActivity.class));
                return true;

            case R.id.action_viewactivity5:
                startActivity(new Intent(MainActivity.this, StartConsultationActivity.class));
                return true;

            case R.id.action_viewactivity6:
                startActivity(new Intent(MainActivity.this, OnBoardingUiActivity.class));
                return true;
        }

        return true;
    }
}
