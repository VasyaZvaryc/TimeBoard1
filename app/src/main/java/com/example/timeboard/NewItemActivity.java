package com.example.timeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemActivity extends AppCompatActivity {

    EditText editGroup;
    EditText editDayOfWeek;
    EditText editNumLesson;
    EditText editSubject;
    EditText editTeacher;

    Button button_save;

    public static final String GROUP = "group";
    public static final String DEY_OF_WEEK = "dayOfWeek";
    public static final String NUM_LESSON = "numLesson";
    public static final String SUBJECT = "subject";
    public static final String TEACHER = "teacher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        editGroup = findViewById(R.id.editGroup);
        editDayOfWeek = findViewById(R.id.editDayOfWeek);
        editNumLesson = findViewById(R.id.editNumLesson);
        editSubject = findViewById(R.id.editSubject);
        editTeacher = findViewById(R.id.editTeacher);

        button_save = findViewById(R.id.button_save);

        button_save.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(editGroup.getText()) || TextUtils.isEmpty(editDayOfWeek.getText()) || TextUtils.isEmpty(editNumLesson.getText())
                    || TextUtils.isEmpty(editSubject.getText()) || TextUtils.isEmpty(editTeacher.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                replyIntent.putExtra(GROUP, editGroup.getText().toString());
                replyIntent.putExtra(DEY_OF_WEEK, editDayOfWeek.getText().toString());
                replyIntent.putExtra(NUM_LESSON, editNumLesson.getText().toString());
                replyIntent.putExtra(SUBJECT, editSubject.getText().toString());
                replyIntent.putExtra(TEACHER, editTeacher.getText().toString());
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}