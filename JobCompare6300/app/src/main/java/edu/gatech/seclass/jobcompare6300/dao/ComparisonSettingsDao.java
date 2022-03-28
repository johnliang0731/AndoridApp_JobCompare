package edu.gatech.seclass.jobcompare6300.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import edu.gatech.seclass.jobcompare6300.model.ComparisonSettings;

@Dao
public interface ComparisonSettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ComparisonSettings comparisonSettings);

    @Query("SELECT * from comparisonsettings where id = 1")
    ComparisonSettings getComparisonSettings();
}
