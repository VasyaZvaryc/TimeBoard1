package com.example.timeboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TimeTable.class}, version = 1, exportSchema = false)
public abstract class TableRoomDatabase extends RoomDatabase {

    public abstract TimeTableDao timeTableDao();

    private static volatile TableRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                TimeTableDao dao = INSTANCE.INSTANCE.timeTableDao();

                TimeTable l1 = new TimeTable("ЕЗС-14", 1, 1, "Інформатика", "Батурін, Бортник");
                dao.insert(l1);
                TimeTable l2 = new TimeTable("ЕЗС-14", 1, 2, "Інформатика", "Батурін, Бортник");
                dao.insert(l2);
                TimeTable l3 = new TimeTable("ЕЗС-14", 1, 3, "Математика", "Романська");
                dao.insert(l3);
                TimeTable l4 = new TimeTable("ЕЗС-14", 1, 4, "Історія Укранїни", "Соловей");
                dao.insert(l4);
                TimeTable l5 = new TimeTable("ЕЗС-14", 1, 5, "Захист України/Всесвітня Історія", "Гищук/Соловей");
                dao.insert(l5);
                TimeTable l6 = new TimeTable("ЕЗС-14", 1, 6, "Захист України/Всесвітня Історія", "Гищук/Соловей");
                dao.insert(l6);
                TimeTable l7 = new TimeTable("ЕЗС-14", 1, 7, "Іноземна Мова/-", "Замулінська Кавака");
                dao.insert(l7);
                TimeTable l8 = new TimeTable("ЕЗС-14", 1, 8, "Іноземна Мова/-", "Замулінська Кавака");
                dao.insert(l8);
                TimeTable l9 = new TimeTable("ЕЗС-14",2, 1, "Виробниче навчання","Голяк, Гриньків");
                dao.insert(l9);
                TimeTable l10 = new TimeTable("ЕЗС-14",3, 1-2, "Українська мова/Іноземна мова","Прунько,Кавака, Зумулінська");
                dao.insert(l10);
                TimeTable l11 = new TimeTable("ЕЗС-14",3, 3-4, "Технологія Слюсарних робіт","Хромей");
                dao.insert(l11);
                TimeTable l12 = new TimeTable("ЕЗС-14",3, 5-6, "Біологія","Ганжа");
                dao.insert(l12);
                TimeTable l13 = new TimeTable("ЕЗС-14",3, 7, "Фізична Культура","Долик");
                dao.insert(l13);
                TimeTable l14 = new TimeTable("ЕЗС-14",3, 8, "Хімія","Козій");
                dao.insert(l14);
                TimeTable l15 = new TimeTable("ЕЗС-14",4, 1-2, "Математика/Фізика","Романська, Дяків");
                dao.insert(l15);
                TimeTable l16 = new TimeTable("ЕЗС-14",4, 3, "Хімія","Козій");
                dao.insert(l16);
                TimeTable l17 = new TimeTable("ЕЗС-14",4, 4, "Географія","Федорів");
                dao.insert(l17);
                TimeTable l18 = new TimeTable("ЕЗС-14",4, 5-6, "Фізична культура","Долик");
                dao.insert(l18);
                TimeTable l19 = new TimeTable("ЕЗС-14",4, 7, "Українська література","Прунько");
                dao.insert(l19);
                TimeTable l20 = new TimeTable("ЕЗС-14",4, 8, "Зарубіжна Література","Прунько");
                dao.insert(l20);
                TimeTable l21 = new TimeTable("ЕЗС-14",5, 1-2, "Технологія слюсарних робіт","Хромей");
                dao.insert(l21);
                TimeTable l22 = new TimeTable("ЕЗС-14",5, 3-4, "Технічне Креслення","Задовська");
                dao.insert(l22);
                TimeTable l23 = new TimeTable("ЕЗС-14",5, 5-6, "Фізика і астрономія","Дяків");
                dao.insert(l23);
                TimeTable l24 = new TimeTable("ЕЗС-14",5, 7, "Математика","Романська");
                dao.insert(l24);
                TimeTable l25 = new TimeTable("ЗВ-15",1, 1, "Ураїнська мова","Кубарич");
                dao.insert(l25);
                TimeTable l26 = new TimeTable("ЗВ-15",1,2 , "Географія","Федорів");
                dao.insert(l26);
                TimeTable l27 = new TimeTable("ЗВ-15",1, 3, "Біологія і екологія","Ганжа");
                dao.insert(l27);
                TimeTable l28 = new TimeTable("ЗВ-15",1, 4 , "Фізика і астрономія","Гринюк");
                dao.insert(l28);
                TimeTable l29 = new TimeTable("ЗВ-15",1, 5-6, "Матеріало знавство","Худяк");
                dao.insert(l29);
                TimeTable l30 = new TimeTable("ЗВ-15",1, 7-8, "Німецька мова/ Англійська мова","Зумулінська/Кавака");
                dao.insert(l30);
                TimeTable l31 = new TimeTable("ОПЗ-16",1, 1, "Німецька мова/ Англійська мова","Зумулінська/Кавака");
                dao.insert(l31);
            });
        }
    };

    static TableRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TableRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TableRoomDatabase.class, "table_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}