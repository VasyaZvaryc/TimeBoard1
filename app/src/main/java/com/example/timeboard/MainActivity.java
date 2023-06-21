package com.example.timeboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static final int NEW_TABLE_ACRIVITY_REQUEST_CODE = 1;

    private TableViewModel tableViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        tableViewModel = new ViewModelProvider(this).get(TableViewModel.class);

        final TableListAdapter adapter = new TableListAdapter(new TableListAdapter.WordDiff(), tableViewModel, MainActivity.this, "");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tableViewModel.getAllWords().observe(this, words -> {
            adapter.submitList(words);
        });
    }

    public void selectGroup(View view) {
        Intent intent = new Intent(this, GroupsActivity.class);
        intent.putExtra("id", (String) view.getTag());
        startActivity(intent);
    }

    public void AddNewItem(View view) {
        Intent intent = new Intent(MainActivity.this, NewItemActivity.class);
        startActivityForResult(intent, NEW_TABLE_ACRIVITY_REQUEST_CODE);
    }

    public void ViewData(View view) {
        if(recyclerView.getVisibility() == View.GONE) {
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.GONE);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(1);

        if (requestCode == NEW_TABLE_ACRIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            TimeTable word = new TimeTable(data.getStringExtra(NewItemActivity.GROUP), data.getIntExtra(NewItemActivity.DEY_OF_WEEK, 0),
                    data.getIntExtra(NewItemActivity.NUM_LESSON, 0), data.getStringExtra(NewItemActivity.SUBJECT), data.getStringExtra(NewItemActivity.TEACHER));
            tableViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.error,
                    Toast.LENGTH_LONG).show();
        }
    }

}
