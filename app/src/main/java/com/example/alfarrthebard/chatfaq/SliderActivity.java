package com.example.alfarrthebard.chatfaq;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderActivity extends AppCompatActivity {
    private Button btnSkip, btnNext;
    private ViewPager sViewPager;
    private LinearLayout dotsLayout;
    private TextView dots[];

    SlideAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slider1);

        initView();

        sliderAdapter = new SlideAdapter(this);
        sViewPager.setAdapter(sliderAdapter);
        sViewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        addBottomDots(0);

    }


    // btnSkipClick
    public void btnSkipClick(View v) {
        launchHomeScreen();
    }

    //btnNextClick
    public void btnNextClick(View v) {
        int current = getItem(1);
        if (current < sliderAdapter.image_slide.length) {
            sViewPager.setCurrentItem(current);
        } else {
            launchHomeScreen();
        }
    }

    private void launchHomeScreen() {
        startActivity(new Intent(this, login.class));
        finish();
    }

    private int getItem(int i) {
        return sViewPager.getCurrentItem() + i;
    }

    private void initView() {
        sViewPager = (ViewPager) findViewById(R.id.sViewPager);
        sViewPager.setBackgroundColor(Color.rgb(184,49,31));
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        dotsLayout.setBackgroundColor(Color.rgb(184,49,31));
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnSkip.setBackgroundColor(Color.rgb(184,49,31));
        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setBackgroundColor(Color.rgb(184,49,31));
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            if (position == sliderAdapter.image_slide.length - 1) {
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    // add dot indicator
    public void addDotIndicator() {
        dots = new TextView[2];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8266;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colortWhite));

            dotsLayout.addView(dots[i]);
        }
    }

    // set of Dots points
    private void addBottomDots(int currentPage) {
        dots = new TextView[2];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colortWhite));  // dot_inactive
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.colorAccent)); // dot_active
    }


}


