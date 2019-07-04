package com.example.a10146.takeoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10146.takeoutapp.types.ResultItem;

import java.util.ArrayList;
import java.util.List;


public class ResultActivity extends Activity {

    private SearchView resultSearch;

    private List<ResultItem> results;
    private ResultItem item;

    private LinearLayout resultxml;
    private ImageView resultItemImage;
    private TextView resultItemName;
    private TextView resultItemSalesCount;
    private TextView resultItemTimeDis;
    private TextView resultItemPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultSearch = (SearchView) findViewById(R.id.result_search);
        resultxml = (LinearLayout) findViewById(R.id.result_xml);
        resultItemImage = (ImageView) findViewById(R.id.resultItem_image);
        resultItemName = (TextView) findViewById(R.id.resultItem_name);
        resultItemSalesCount = (TextView) findViewById(R.id.resultItem_salescount);
        resultItemTimeDis = (TextView) findViewById(R.id.resultItem_timedis);
        resultItemPrices = (TextView) findViewById(R.id.resultItem_prices);

        resultSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        initResults();
        Intent intent = getIntent();
        String requestStr = intent.getStringExtra("request");
//        Toast.makeText(getApplicationContext(),requestStr,Toast.LENGTH_SHORT).show();//获取成功
        item = searchList(requestStr);
        if(item != null) {
            double distance = item.getDistance();
            double delivery = item.getDelivery();
            resultItemImage.setImageResource(item.getImageId());
            resultItemName.setText(item.getName());
            resultItemSalesCount.setText("月售" + item.getSalescount());
            resultItemTimeDis.setText(item.getTime() + "分钟 " + (distance > 20 ? (distance + "m") : (distance + "km")));
            resultItemPrices.setText("起送 ￥ " + item.getPickup() + " " + (delivery > 0 ? delivery : "免配送费") + " " + "人均 ￥ " + item.getAverage());
        } else {
            resultxml.removeAllViews();
        }
    }



    private ResultItem searchList(String request) {
        for(int i = 0; i < results.size(); i ++) {
            if(results.get(i).getName().indexOf(request)>=0) { //如果找到对应字串 则返回该对象
                return results.get(i);
            }
        }
        return null;
    }

    private void initResults(){
        results = new ArrayList<>();
        results.add(new ResultItem(R.drawable.taihaoxianbing, "泰好馅饼",826, 40, 4.9, 20, 2.5, 14));
        results.add(new ResultItem(R.drawable.duomitiebanchaofan, "哆咪铁板炒饭", 1088, 45, 5.2, 15, 1, 18));
        results.add(new ResultItem(R.drawable.baijishuijiao, "柏记水饺宅急送", 3295, 54, 5.2, 0, 3.5,16));
        results.add(new ResultItem(R.drawable.lumengroubing, "鲁蒙肉饼糁汤", 984, 30, 1.2, 15, 0.5, 16));
        results.add(new ResultItem(R.drawable.jigongbao, "煜熠重庆鸡公煲", 1787, 39, 3.6, 15, 1.5, 16));
        results.add(new ResultItem(R.drawable.luzhengzongjianggufan, "鲁正宗酱骨饭", 395, 30, 1.9, 15, 0.5, 19));
        results.add(new ResultItem(R.drawable.shanshisan, "陕十三肉夹馍", 409, 35, 2.8, 15, 0.5, 18));
        results.add(new ResultItem(R.drawable.yidalifengwei, "意大利风味牛排饭", 1772, 40,4.0,0, 1.5, 16));
        results.add(new ResultItem(R.drawable.dapanji, "天山大盘鸡", 7145, 43, 4.1, 15, 2.5, 17));
        results.add(new ResultItem(R.drawable.hualaishi, "华莱士炸鸡汉堡", 748, 30, 770, 20, 1.5, 20));
        results.add(new ResultItem(R.drawable.chenxiaochu, "枣庄辣子鸡", 1273, 30, 2.3, 15, 0.5, 25));
        results.add(new ResultItem(R.drawable.youjiachuancai, "有家川菜", 772, 43, 4.3, 20, 0, 20));
        results.add(new ResultItem(R.drawable.jinghechaofan, "井盒炒饭", 6947,30, 2.0, 15, 0, 20));
        results.add(new ResultItem(R.drawable.xinlanhanmenbing, "新懒汉焖饼", 2092, 30, 2.0, 0, 0.5, 15));
        results.add(new ResultItem(R.drawable.miaozhuge, "妙诸葛蕉庄鲜肉烧饼", 325, 37, 3.3, 15, 1.5, 13));
        results.add(new ResultItem(R.drawable.hanbaobuluo, "汉堡部落", 2200, 30, 749, 15, 1, 15));
    }
}
