package com.example.timeboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class GroupsActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout listButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grups);

        listButtons = findViewById(R.id.listButtons);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Resources res = getResources();
        String[] course = res.getStringArray(res.getIdentifier("course_"+id, "array", getPackageName()));

        Typeface typeface = ResourcesCompat.getFont(GroupsActivity.this, R.font.montserrat_bold);

        for (String i : course) {
            Button button = new Button(GroupsActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 50;
            params.rightMargin = 50;
            button.setLayoutParams(params);
            button.setBackgroundTintList(res.getColorStateList(R.color.teal_200));
            button.setText(i);
            button.setTag(i);
            button.setOnClickListener(this);
            button.setTypeface(typeface);
            listButtons.addView(button);
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, TableActivity.class);
        intent.putExtra("id", (String) view.getTag());
        startActivity(intent);
    }

}