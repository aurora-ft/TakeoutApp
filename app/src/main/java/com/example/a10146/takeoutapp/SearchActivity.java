package com.example.a10146.takeoutapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.support.v7.widget.SearchView;

public class SearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        SearchView sv = (SearchView) findViewById(R.id.search_text);
//        showSoftInputFromWindow(sv);
    }

//    public void showSoftInputFromWindow(SearchView searchView){
//        searchView.setFocusable(true);
//        searchView.setFocusableInTouchMode(true);
//        searchView.requestFocus();
//        InputMethodManager inputManager = (InputMethodManager) searchView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputManager.showSoftInput(searchView, 0);
//    }
}
