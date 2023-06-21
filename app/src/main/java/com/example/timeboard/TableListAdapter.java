package com.example.timeboard;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TableListAdapter extends ListAdapter<TimeTable, TableViewHolder> {

    private TableViewModel tableViewModel;
    private Context context;
    private String id;

    public TableListAdapter(@NonNull DiffUtil.ItemCallback<TimeTable> diffCallback, TableViewModel tableViewModel, Context context, String id) {
        super(diffCallback);
        this.tableViewModel = tableViewModel;
        this.context = context;
        this.id = id;
    }

    @Override
    public TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TableViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TableViewHolder holder, int position) {
        TimeTable current = getItem(position);
        holder.bind(current, tableViewModel, context, id);
    }

    static class WordDiff extends DiffUtil.ItemCallback<TimeTable> {

        @Override
        public boolean areItemsTheSame(@NonNull TimeTable oldItem, @NonNull TimeTable newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull TimeTable oldItem, @NonNull TimeTable newItem) {
            return oldItem.getId() == newItem.getId();
        }

    }

}