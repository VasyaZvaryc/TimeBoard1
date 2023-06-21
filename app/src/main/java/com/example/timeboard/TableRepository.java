package com.example.timeboard;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TableRepository {
    private TimeTableDao mTimeTableDao;
    private LiveData<List<TimeTable>> mAllWords;

    TableRepository(Application application) {
        TableRoomDatabase db = TableRoomDatabase.getDatabase(application);
        mTimeTableDao = db.timeTableDao();
        mAllWords = mTimeTableDao.getAlphabetizedWords();
    }

    LiveData<List<TimeTable>> getAllWords() {
        return mAllWords;
    }

    void insert(TimeTable timeTable) {
        TableRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTimeTableDao.insert(timeTable);
        });
    }

    void deleteById(long id) {
        TableRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTimeTableDao.deleteById(id);
        });
    }

}