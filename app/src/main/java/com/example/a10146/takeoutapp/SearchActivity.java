package com.example.a10146.takeoutapp;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.a10146.takeoutapp.tools.SearchHistoryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends Activity {

    private SearchView sSearch;
    private ImageView delHistory;
//    private List<String> hisList = new ArrayList<>();
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private List<String> historyList;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private SearchHistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        sp = getSharedPreferences("USER_LIST", MODE_PRIVATE);

        sSearch = (SearchView) findViewById(R.id.search_text);
        delHistory = (ImageView) findViewById(R.id.del_history);
//        initHistory();
        getHistoryData();
        if(historyList != null) {
            recyclerView = (RecyclerView) findViewById(R.id.search_history);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new SearchHistoryAdapter(historyList);
            recyclerView.setAdapter(adapter);
        }

        sSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(SearchActivity.this,ResultActivity.class);
                String request = new String(sSearch.getQuery().toString());
                historyList.add(request);
                setHistoryData();
                intent.putExtra("request", request);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        delHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHistory();
            }
        });
    }

//    private void initHistory() {
//        hisList.add(new String("烤竹鼠"));
//        hisList.add(new String("素烧鹅"));
//        hisList.add(new String("全羊"));
//        hisList.add(new String("肯德基"));
//    }

    //获取保存的历史数据
    private void getHistoryData() {
        historyList = new ArrayList<>();
        String listJson = sp.getString("HISTORY_DATA","");
        if(!listJson.equals("")) {
            Gson gson = new Gson();
            historyList = gson.fromJson(listJson, new TypeToken<List<String>>(){}.getType());
        }
    }

    //保存历史数据
    private void setHistoryData() {
        Gson gson = new Gson();
        String listJson = gson.toJson(historyList);
        editor = sp.edit();
        editor.putString("HISTORY_DATA", listJson);
        editor.commit();
    }

    private void clearHistory() {
        recyclerView.removeAllViews();
        historyList.clear();
        adapter.notifyDataSetChanged();
        setHistoryData();
    }

}
