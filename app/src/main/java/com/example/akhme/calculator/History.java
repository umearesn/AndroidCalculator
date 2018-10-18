package com.example.akhme.calculator;

import android.content.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.Activity;

import java.util.ArrayList;

public class History extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        RecyclerView recyclerView = findViewById(R.id.historyRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> data = new ArrayList<>();
        data.add("hello");
        data.add("world!");
        HistoryAdapter adapter = new HistoryAdapter(this, data);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
