package com.example.timeboard;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class TableViewModel extends AndroidViewModel {

    private TableRepository mRepository;

    private final LiveData<List<TimeTable>> mAllWords;

    public TableViewModel (Application application) {
        super(application);
        mRepository = new TableRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<TimeTable>> getAllWords() {
        return mAllWords;
    }

    public void insert(TimeTable timeTable) {
        mRepository.insert(timeTable);
    }

    public void deleteById(long id) {
        mRepository.deleteById(id);
    }

}