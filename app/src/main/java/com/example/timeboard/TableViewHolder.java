package com.example.timeboard;

import static android.view.View.GONE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class TableViewHolder extends RecyclerView.ViewHolder {

    private TextView textGroup;
    private TextView textDayOfWeek;
    private TextView textNumLesson;
    private TextView textSubject;
    private TextView textTeacher;
    private ImageButton btnDeleteItem;

    private TableViewHolder(View view) {
        super(view);
        textGroup = view.findViewById(R.id.textGroup);
        textDayOfWeek = view.findViewById(R.id.textDayOfWeek);
        textNumLesson = view.findViewById(R.id.textNumLesson);
        textSubject = view.findViewById(R.id.textSubject);
        textTeacher = view.findViewById(R.id.textTeacher);
        btnDeleteItem = view.findViewById(R.id.btnDeleteItem);
    }

    public void bind(TimeTable table, TableViewModel tableViewModel, Context context, String id) {
        if (!id.isEmpty()) {
            btnDeleteItem.setVisibility(GONE);
            if (!id.equals(table.getGr())) {
                itemView.setVisibility(GONE);
                return;
            }
        }

        textGroup.setText(String.valueOf(table.getGr()));
        textDayOfWeek.setText(String.valueOf(table.getDayOfWeek()));
        textNumLesson.setText(String.valueOf(table.getNumLesson()));
        textSubject.setText(String.valueOf(table.getSubject()));
        textTeacher.setText(String.valueOf(table.getTeatcher()));

        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context, R.style.CustomAlertDialog);
                alert.setTitle("Видалити запис");
                alert.setMessage("Ви дійсно хочете видалити цей запис?");
                alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        tableViewModel.deleteById(table.getId());
                    }
                });
                alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
    }

    static TableViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new TableViewHolder(view);
    }

}