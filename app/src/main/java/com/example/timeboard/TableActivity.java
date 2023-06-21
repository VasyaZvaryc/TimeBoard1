package com.example.timeboard;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TableViewModel tableViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_acrivity);

        recyclerView = findViewById(R.id.recyclerview);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        tableViewModel = new ViewModelProvider(this).get(TableViewModel.class);

        final TableListAdapter adapter = new TableListAdapter(new TableListAdapter.WordDiff(), tableViewModel, TableActivity.this, id);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tableViewModel.getAllWords().observe(this, words -> {
            adapter.submitList(words);
        });

    }

}