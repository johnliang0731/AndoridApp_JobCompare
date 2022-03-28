package edu.gatech.seclass.jobcompare6300.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.gatech.seclass.jobcompare6300.dao.ComparisonSettingsDao;
import edu.gatech.seclass.jobcompare6300.dao.JobDao;
import edu.gatech.seclass.jobcompare6300.model.ComparisonSettings;
import edu.gatech.seclass.jobcompare6300.model.Job;

@Database(entities = {Job.class, ComparisonSettings.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JobDao jobDao();

    public abstract ComparisonSettingsDao comparisonSettingDao();

    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            "job-compare-db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
