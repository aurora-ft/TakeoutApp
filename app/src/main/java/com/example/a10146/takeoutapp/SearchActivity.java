package com.example.a10146.takeoutapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.a10146.takeoutapp.tools.SearchHistoryAdapter;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends Activity {

    private SearchView sSearch;
    private List<String> hisList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        sSearch = (SearchView) findViewById(R.id.search_text);
        initHistory();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SearchHistoryAdapter adapter = new SearchHistoryAdapter(hisList);
        recyclerView.setAdapter(adapter);
        sSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(SearchActivity.this,ResultActivity.class);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void initHistory() {
        hisList.add(new String("烤竹鼠"));
        hisList.add(new String("素烧鹅"));
        hisList.add(new String("全羊"));
        hisList.add(new String("肯德基"));
    }

}
