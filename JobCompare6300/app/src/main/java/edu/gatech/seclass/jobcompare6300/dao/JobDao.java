package edu.gatech.seclass.jobcompare6300.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.model.Job;

@Dao
public interface JobDao {

    @Query("SELECT * FROM job where isCurrentJob = 0")
    List<Job> getAllJobs();

    @Query("SELECT * FROM job where isCurrentJob = 1")
    List<Job> getCurrentJob();

    @Query("SELECT * FROM job where id = :jobId")
    Job getJobById(long jobId);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertJob(Job job);
}
