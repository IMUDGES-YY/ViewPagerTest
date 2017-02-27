package com.imudges.yangyang.viewpagertest;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        tabMain = (LinearLayout) findViewById(R.id.linear_layout_main);
        tabFriend = (LinearLayout) findViewById(R.id.linear_layout_friend);
        tabConnect = (LinearLayout) findViewById(R.id.linear_layout_connect);
        tabSetting = (LinearLayout) findViewById(R.id.linear_layout_setting);

        imgBtnMain = (ImageButton) findViewById(R.id.img_btn_main_page);
        imgBtnConnect = (ImageButton) findViewById(R.id.img_btn_connect_page);
        imgBtnFriend = (ImageButton) findViewById(R.id.img_btn_friend_page);
        imgBtnSetting = (ImageButton) findViewById(R.id.img_btn_setting_page);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view01 = layoutInflater.inflate(R.layout.tab01, null);
        View view02 = layoutInflater.inflate(R.layout.tab02, null);
        View view03 = layoutInflater.inflate(R.layout.tab03, null);
        View view04 = layoutInflater.inflate(R.layout.tab04, null);

        list.add(view01);
        list.add(view02);
        list.add(view03);
        list.add(view04);
        pagerAdapter = new PagerAdapter() {
            /**
             * 这个方法，return一个对象，这个对象表明了PagerAdapter适配器选择哪个对象,放在当前的ViewPager中
             * 使用此方法实例化页面卡
             * */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = list.get(position);
                container.addView(view);
                return view;
            }

            /**
             * 获取当前窗体界面的数量
             * */
            @Override
            public int getCount() {
                return list.size();
            }

            /**
             * 用于判断是否由对象生成界面
             * */
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;//官方提示这样写
            }

            /**
             * 从ViewGroup中移出当前View
             * */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }
        };
        viewPager.setAdapter(pagerAdapter);

    }

    private void initEvents() {
        imgBtnMain.setOnClickListener(this);
        imgBtnFriend.setOnClickListener(this);
        imgBtnSetting.setOnClickListener(this);
        imgBtnConnect.setOnClickListener(this);

        viewPager.setCurrentItem(0);
        imgBtnMain.setImageResource(R.drawable.tab_weixin_pressed);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 页面滚动时侯代码：
             * */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 页面跳转完后得到调用
             * */
            @Override
            public void onPageSelected(int position) {
                int currentItem = viewPager.getCurrentItem();//获取当前页面
                resetImg();
                switch (currentItem) {
                    case 0:
                        viewPager.setCurrentItem(0);//设置当前页面
                        imgBtnMain.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        imgBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        imgBtnConnect.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        viewPager.setCurrentItem(3);
                        imgBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                    default:
                        break;
                }

            }

            /**
             * 当viewPager状态改变时候
             * */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void resetImg() {
        imgBtnFriend.setImageResource(R.drawable.tab_find_frd_normal);
        imgBtnSetting.setImageResource(R.drawable.tab_settings_normal);
        imgBtnMain.setImageResource(R.drawable.tab_weixin_normal);
        imgBtnConnect.setImageResource(R.drawable.tab_address_normal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.img_btn_main_page:
                imgBtnMain.setImageResource(R.drawable.tab_weixin_pressed);
                viewPager.setCurrentItem(0);
                break;
            case R.id.img_btn_setting_page:
                imgBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
                viewPager.setCurrentItem(3);
                break;
            case R.id.img_btn_connect_page:
                imgBtnConnect.setImageResource(R.drawable.tab_address_pressed);
                viewPager.setCurrentItem(2);
                break;
            case R.id.img_btn_friend_page:
                imgBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                viewPager.setCurrentItem(1);
                break;
            default:
                break;
        }

    }
}
