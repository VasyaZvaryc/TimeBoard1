package com.example.timeboard;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TimeTableDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TimeTable timeTable);

    @Query("DELETE FROM time_table WHERE id = :id")
    void deleteById(long id);

    @Query("DELETE FROM time_table")
    void deleteAll();

    @Query("SELECT * FROM time_table ORDER BY id ASC")
    LiveData<List<TimeTable>> getAlphabetizedWords();

}