package edujohnliang0731/cs7638_SLAM_project.gatech.seclass.jobcompare6300.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.model.ComparisonSettings;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class SystemController {
    private Job currentJob;
    private List<Job> jobOffers;
    private ComparisonSettings comparisonSettings;
    private AppDatabase appDatabase;


    public SystemController(Context context) {
        this.appDatabase = AppDatabase.getAppDatabase(context);
        this.jobOffers = appDatabase.jobDao().getAllJobs();
        List<Job> currentJob = appDatabase.jobDao().getCurrentJob();
        this.currentJob = currentJob.size() == 1 ? currentJob.get(0) : null;
        this.comparisonSettings = appDatabase.comparisonSettingDao().getComparisonSettings();
        if(this.comparisonSettings == null) {
            System.out.println("comparisonSetting is null");
            this.comparisonSettings = new ComparisonSettings(1, 1,
                    1, 1, 1);
            this.comparisonSettings.setId(1);
            appDatabase.comparisonSettingDao().insert(this.comparisonSettings);
        }

    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }

    public Job getCurrentJob() {
        return currentJob;
    }


    public Job getJobById(long jobId) {
        return appDatabase.jobDao().getJobById(jobId);
    }

    public void addJobOffer(Job job) {
        this.jobOffers.add(job);
    }

    public void editComparisonSettings(ComparisonSettings comparisonSettings) {
        this.comparisonSettings = comparisonSettings;
    }

    public ComparisonSettings getComparisonSettings() {
        return this.comparisonSettings;
    }

    public void compareJobOffers(Job job1, Job job2) {

    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public List<Job> getTopJobOffers() {
        sortJobOffers();
        return this.jobOffers;
    }

    public void sortJobOffers() {


        // need to add current job when displaying to job offers if not null
        if(this.currentJob != null) {
            this.jobOffers.add(this.currentJob);
        }


        for (Job offer : this.jobOffers) {
            offer.calculateJobScore(this.comparisonSettings);
        }

        Collections.sort(this.jobOffers, (Job job1, Job job2) -> Double.compare(job2.getJobRanking(), job1.getJobRanking()));
    }

    public long saveJobOffer(Job job) {
        return appDatabase.jobDao().insertJob(job);
    }

    public void saveComparisonSettings(ComparisonSettings comparisonSettings) {
        appDatabase.comparisonSettingDao().insert(comparisonSettings);
    }

    public List<Job> getJobOffers() {
        return this.jobOffers;
    }


}

