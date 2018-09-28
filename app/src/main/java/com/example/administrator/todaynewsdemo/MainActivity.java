package com.example.administrator.todaynewsdemo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //  private TextView tv_tab;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> mTitle = new ArrayList<>();
    String[] mData = new String[20];
    TabLayout mTabLayout;
    ViewPager mViewPager;
    private PopupWindow popupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton button1 = findViewById(R.id.headline);
        button1.setOnClickListener(this);
        RadioButton button2 = findViewById(R.id.watermelon);
        button2.setOnClickListener(this);
        RadioButton button3 = findViewById(R.id.video);
        button3.setOnClickListener(this);
        RadioButton button4 = findViewById(R.id.wei_headline);
        button4.setOnClickListener(this);
        RadioButton button5 = findViewById(R.id.my);
        button5.setOnClickListener(this);
        initFragment();
        ImageButton button_menu = findViewById(R.id.menu);
        button_menu.setOnClickListener(this);
        replacefragment(fragments.get(0));
        initData();
        initView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    private void initData() {
        for (int i = 0; i < 20; i++) {
            mTitle.add("关注");
            mTitle.add("推荐");
            mTitle.add("南京");
            mTitle.add("教育");
            mTitle.add("数码");
            mTitle.add("游戏");
            mTitle.add("视频");
            mTitle.add("热点");
            mData[i] = mTitle.get(i);
        }
    }

    private void initView() {
        mTabLayout = findViewById(R.id.tl_tab);
        mViewPager = findViewById(R.id.vp_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {

                return mTitle.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                //创建Fragment并返回
                TabFragment fragment = new TabFragment();
                return fragment;
            }

            @Override
            public int getCount() {
                return mTitle.size();
            }
        });
        //将ViewPager关联到TabLayout上
        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void replacefragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.vp_pager, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    private void initFragment() {
        fragments.add(new TabFragment());
        fragments.add(new WatermelonFragment());
        fragments.add(new weiFragment());
        fragments.add(new vidioFragment());
        fragments.add(new MyFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.headline:
                replacefragment(new TabFragment());
                break;
            case R.id.watermelon:
                replacefragment(new WatermelonFragment());
                break;
            case R.id.wei_headline:
                replacefragment(new weiFragment());
                break;
            case R.id.video:
                replacefragment(new vidioFragment());
                break;
            case R.id.my:
                replacefragment(new MyFragment());
                break;
            case R.id.menu:
                if (popupwindow != null && popupwindow.isShowing()) {
                    popupwindow.dismiss();
                    return;
                } else {
                    initmPopupWindowView();
                    popupwindow.showAsDropDown(view, 10, 5);
                }
                break;


        }
    }

    public void initmPopupWindowView() {

        // // 获取自定义布局文件pop.xml的视图
        View customView = getLayoutInflater().inflate(R.layout.menu_item,
                null, false);
        // 创建PopupWindow实例,200,150分别是宽度和高度
        popupwindow = new PopupWindow(customView, 300, 360);


        // 自定义view添加触摸事件
        customView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupwindow != null && popupwindow.isShowing()) {
                    popupwindow.dismiss();
                    popupwindow = null;
                }

                return false;
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {


            finish();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}