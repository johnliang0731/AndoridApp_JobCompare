package edu.gatech.seclass.jobcompare6300.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ComparisonSettings {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int weeklyTeleworkDaysWeight;
    private int retirementBenefitsWeight;
    private int leaveTimeWeight;

    public ComparisonSettings() {

    }

    @Ignore
    public ComparisonSettings(int yearlySalaryWeight, int yearlyBonusWeight, int weeklyTeleworkDaysWeight,
                              int retirementBenefitsWeight, int leaveTimeWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.weeklyTeleworkDaysWeight = weeklyTeleworkDaysWeight;
        this.retirementBenefitsWeight = retirementBenefitsWeight;
        this.leaveTimeWeight = leaveTimeWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public void setYearlySalaryWeight(int yearlySalaryWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
    }

    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public void setYearlyBonusWeight(int yearlyBonusWeight) {
        this.yearlyBonusWeight = yearlyBonusWeight;
    }

    public int getWeeklyTeleworkDaysWeight() {
        return weeklyTeleworkDaysWeight;
    }

    public void setWeeklyTeleworkDaysWeight(int weeklyTeleworkDaysWeight) {
        this.weeklyTeleworkDaysWeight = weeklyTeleworkDaysWeight;
    }

    public int getRetirementBenefitsWeight() {
        return retirementBenefitsWeight;
    }

    public void setRetirementBenefitsWeight(int retirementBenefitsWeight) {
        this.retirementBenefitsWeight = retirementBenefitsWeight;
    }

    public int getLeaveTimeWeight() {
        return leaveTimeWeight;
    }

    public void setLeaveTimeWeight(int leaveTimeWeight) {
        this.leaveTimeWeight = leaveTimeWeight;
    }
}
