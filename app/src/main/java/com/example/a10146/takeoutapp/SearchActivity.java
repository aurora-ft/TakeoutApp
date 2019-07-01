package com.example.a10146.takeoutapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.inputmethod.InputMethodManager;
import android.support.v7.widget.SearchView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {

    private SearchView sSearch;
    private List<String> hisList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        SearchView sv = (SearchView) findViewById(R.id.search_text);
//        showSoftInputFromWindow(sv);
        initHistory();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SearchHistoryAdapter adapter = new SearchHistoryAdapter(hisList);
        recyclerView.setAdapter(adapter);
    }

    private void initHistory() {
        hisList.add(new String("烤竹鼠"));
        hisList.add(new String("素烧鹅"));
        hisList.add(new String("全羊"));
        hisList.add(new String("肯德基"));
    }

//    public void showSoftInputFromWindow(SearchView searchView){
//        searchView.setFocusable(true);
//        searchView.setFocusableInTouchMode(true);
//        searchView.requestFocus();
//        InputMethodManager inputManager = (InputMethodManager) searchView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputManager.showSoftInput(searchView, 0);
//    }
}
