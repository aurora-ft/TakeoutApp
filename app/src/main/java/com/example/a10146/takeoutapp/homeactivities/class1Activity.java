package com.example.a10146.takeoutapp.homeactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.example.a10146.takeoutapp.R;
import com.example.a10146.takeoutapp.SearchActivity;

public class class1Activity extends Activity {

    private SearchView class1Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        class1Search = (SearchView) findViewById(R.id.class1_search);
        class1Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(class1Activity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
