package edu.gatech.seclass.jobcompare6300.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Job {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String company;
    private double yearlySalary;
    private double yearlyBonus;
    private int allowedTeleworkDays;
    private int retirementBenefits;
    private int leaveTime;
    private double jobRanking;
    private String city;
    private String state;
    private int costOfLivingLocation;
    private boolean isCurrentJob;

    public Job() {

    }

    @Ignore
    public Job(String title, String company, double yearlySalary, double yearlyBonus,
               int allowedTeleworkDays, int retirementBenefits, int leaveTime, String city,
               String state, int costOfLivingLocation) {
        this.title = title;
        this.company = company;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.allowedTeleworkDays = allowedTeleworkDays;
        this.retirementBenefits = retirementBenefits;
        this.leaveTime = leaveTime;
        this.city = city;
        this.state = state;
        this.costOfLivingLocation = costOfLivingLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public int getAllowedTeleworkDays() {
        return allowedTeleworkDays;
    }

    public void setAllowedTeleworkDays(int allowedTeleworkDays) {
        this.allowedTeleworkDays = allowedTeleworkDays;
    }

    public int getRetirementBenefits() {
        return retirementBenefits;
    }

    public void setRetirementBenefits(int retirementBenefits) {
        this.retirementBenefits = retirementBenefits;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public double getJobRanking() {
        return jobRanking;
    }

    public void setJobRanking(double jobRanking) {
        this.jobRanking = jobRanking;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCostOfLivingLocation() {
        return costOfLivingLocation;
    }

    public void setCostOfLivingLocation(int costOfLivingLocation) {
        this.costOfLivingLocation = costOfLivingLocation;
    }

    public boolean isCurrentJob() {
        return isCurrentJob;
    }

    public void setCurrentJob(boolean currentJob) {
        isCurrentJob = currentJob;
    }

    public double getAYS() {
        return yearlySalary * (100.0 / costOfLivingLocation);
    }

    public double getAYB() {
        return yearlyBonus * (100.0 / costOfLivingLocation);
    }

    public void calculateJobScore(ComparisonSettings comparisonSettings) {
        double AYS = getAYS();
        double AYB = getAYB();

        double sumOfWeight = comparisonSettings.getYearlySalaryWeight()
                + comparisonSettings.getYearlyBonusWeight()
                + comparisonSettings.getRetirementBenefitsWeight()
                + comparisonSettings.getLeaveTimeWeight()
                + comparisonSettings.getWeeklyTeleworkDaysWeight();

        jobRanking =  (AYS * comparisonSettings.getYearlySalaryWeight()
                + AYB * comparisonSettings.getYearlyBonusWeight()
                + (retirementBenefits / 100.0 * AYS) * comparisonSettings.getRetirementBenefitsWeight()
                + (leaveTime * AYS / 260.0) * comparisonSettings.getLeaveTimeWeight()
                - ((260.0 - 52.0 * allowedTeleworkDays) * (AYS / 260.0) / 8.0) * comparisonSettings.getWeeklyTeleworkDaysWeight());

        jobRanking /= sumOfWeight;
        System.out.println("New score for " +  this.getCompany() + " is " + jobRanking);
    }
}
