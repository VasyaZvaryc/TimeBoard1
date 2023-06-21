package com.example.timeboard;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "time_table")
public class TimeTable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
     long id;

    @ColumnInfo(name="nomGr")
     String gr;
    @ColumnInfo
     int dayOfWeek;
    @ColumnInfo
     int numLesson;
    @ColumnInfo
     String subject;
    @ColumnInfo
     String teatcher;

    public TimeTable(){

    }
    public TimeTable(String Gr, int dayOfWeek, int numLesson, String subject, String teatcher) {
        this.gr = Gr;
        this.dayOfWeek = dayOfWeek;
        this.numLesson = numLesson;
        this.subject = subject;
        this.teatcher = teatcher;
    }

    public long getId() {
        return id;
    }

    public String getGr() {
        return gr;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getNumLesson() {
        return numLesson;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeatcher() {
        return teatcher;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGr(String gr) {
        this.gr = gr;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setNumLesson(int numLesson) {
        this.numLesson = numLesson;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTeatcher(String teatcher) {
        this.teatcher = teatcher;
    }
}
