package com.example.a10146.takeoutapp;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private LinearLayout homeBtn, memberBtn, orderBtn, mineBtn;
    private ImageView ivHome, ivMember, ivOrder, ivMine, ivCurrent;
    private TextView tvHome, tvMember, tvOrder, tvMine, tvCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    //----------------------------------------------------------
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        homeBtn = (LinearLayout) findViewById(R.id.llHome);
        memberBtn = (LinearLayout) findViewById(R.id.llMember);
        orderBtn = (LinearLayout) findViewById(R.id.llOrder);
        mineBtn = (LinearLayout) findViewById(R.id.llMine);

        homeBtn.setOnClickListener(this);
        memberBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);
        mineBtn.setOnClickListener(this);

        ivHome = (ImageView) findViewById(R.id.ivHome);
        ivMember = (ImageView) findViewById(R.id.ivMember);
        ivOrder = (ImageView) findViewById(R.id.ivOrder);
        ivMine = (ImageView) findViewById(R.id.ivMine);

        tvHome = (TextView) findViewById(R.id.tvHome);
        tvMember = (TextView) findViewById(R.id.tvMember);
        tvOrder = (TextView) findViewById(R.id.tvOrder);
        tvMine = (TextView) findViewById(R.id.tvMine);

        ivHome.setSelected(true);
        tvHome.setSelected(true);
        ivCurrent = ivHome;
        tvCurrent = tvHome;
        setNavSty(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {  //新的方法
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setOffscreenPageLimit(2); //设置向左和向右都缓存limit个页面
    }

    private void initData() {
        Fragment homeFragment = new HomeFragment();
        Fragment memberFragment = new MemberFragment();
        Fragment orderFragment = new OrderFragment();
        Fragment mineFragment = new MineFragment();

        fragments.add(homeFragment);
        fragments.add(memberFragment);
        fragments.add(orderFragment);
        fragments.add(mineFragment);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
//      MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    private void setNavSty(int i) { //修改导航栏按钮的样式
        //将导航栏所有按钮样式改为未被点击的样式
        ivHome.setImageResource(R.mipmap.homepage_bc);
        tvHome.setTextColor(this.getResources().getColor(R.color.NavigationTextBC));
        ivMember.setImageResource(R.mipmap.member_bc);
        tvMember.setTextColor(this.getResources().getColor(R.color.NavigationTextBC));
        ivOrder.setImageResource(R.mipmap.order_bc);
        tvOrder.setTextColor(this.getResources().getColor(R.color.NavigationTextBC));
        ivMine.setImageResource(R.mipmap.mine_bc);
        tvMine.setTextColor(this.getResources().getColor(R.color.NavigationTextBC));

        //修改被点击按钮的样式
        switch (i) {
            case 0:
                ivHome.setImageResource(R.mipmap.homepage_ac);
                tvHome.setTextColor(this.getResources().getColor(R.color.NavigationTextAC));
                break;
            case 1:
                ivMember.setImageResource(R.mipmap.member_ac);
                tvMember.setTextColor(this.getResources().getColor(R.color.NavigationTextAC));
                break;
            case 2:
                ivOrder.setImageResource(R.mipmap.order_ac);
                tvOrder.setTextColor(this.getResources().getColor(R.color.NavigationTextAC));
                break;
            case 3:
                ivMine.setImageResource(R.mipmap.mine_ac);
                tvMine.setTextColor(this.getResources().getColor(R.color.NavigationTextAC));
                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }

    private void changeTab(int id) {
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        switch (id) {
            case R.id.llHome:
                viewPager.setCurrentItem(0);
//                Toast.makeText(MainActivity.this, "用户名或者密码不正确", Toast.LENGTH_SHORT).show();
            case 0:
                ivHome.setSelected(true);
                ivCurrent = ivHome;
                tvHome.setSelected(true);
                tvCurrent = tvHome;
                setNavSty(0);
                break;
            case R.id.llMember:
                viewPager.setCurrentItem(1);
            case 1:
                ivMember.setSelected(true);
                ivCurrent = ivMember;
                tvMember.setSelected(true);
                tvCurrent = tvMember;
                setNavSty(1);
                break;
            case R.id.llOrder:
                viewPager.setCurrentItem(2);
            case 2:
                ivOrder.setSelected(true);
                ivCurrent = ivOrder;
                tvOrder.setSelected(true);
                tvCurrent = tvOrder;
                setNavSty(2);
                break;
            case R.id.llMine:
                viewPager.setCurrentItem(3);
            case 3:
                ivMine.setSelected(true);
                ivCurrent = ivMine;
                tvMine.setSelected(true);
                tvCurrent = tvMine;
                setNavSty(3);
                break;
            default:
                break;
        }
    }
    //------------------------------------------------------------------
}
