package com.example.a10146.takeoutapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
//import android.widget.SearchView;

import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import com.example.a10146.takeoutapp.MyCarouselPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    private ViewPager vPager;
    private List<ImageView> mList;

    private SearchView homeSearch;
    private LinearLayout llClass1, llClass2, llClass3, llClass4, llClass5;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);



        return v;
    }

    private void initView() {
        homeSearch = (SearchView) getView().findViewById(R.id.search_bar);
        vPager = (ViewPager) getView().findViewById(R.id.home_carousel);
        llClass1 = (LinearLayout)getView().findViewById(R.id.class1);
        llClass2 = (LinearLayout)getView().findViewById(R.id.class2);
        llClass3 = (LinearLayout)getView().findViewById(R.id.class3);
        llClass4 = (LinearLayout)getView().findViewById(R.id.class4);
        llClass5 = (LinearLayout)getView().findViewById(R.id.class5);
    }

    public int[] getImageRes() {
        return new int[]{R.mipmap.chaoshi,R.mipmap.meishi,R.mipmap.mianfeipeisong,R.mipmap.xianguogou};
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        homeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        int []imageRes = getImageRes();
        mList = new ArrayList<>();
        for(int i = 0; i < imageRes.length; i++) {
            ImageView iv = new ImageView(getActivity());
            iv.setImageResource(imageRes[i]);
            mList.add(iv);
        }
        MyCarouselPagerAdapter myCarouselPagerAdapter = new MyCarouselPagerAdapter(mList);
        vPager.setAdapter(myCarouselPagerAdapter);
    }

//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }
}
