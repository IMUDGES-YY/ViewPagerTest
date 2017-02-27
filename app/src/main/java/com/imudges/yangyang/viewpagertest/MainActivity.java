package com.imudges.yangyang.viewpagertest;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> list = new ArrayList<View>();
    //TAB
    private LinearLayout tabMain;
    private LinearLayout tabFriend;
    private LinearLayout tabConnect;
    private LinearLayout tabSetting;

    private ImageButton imgBtnMain;
    private ImageButton imgBtnFriend;
    private ImageButton imgBtnConnect;
    private ImageButton imgBtnSetting;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
