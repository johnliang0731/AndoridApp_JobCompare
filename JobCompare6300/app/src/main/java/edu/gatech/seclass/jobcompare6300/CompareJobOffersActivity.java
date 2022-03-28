package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.seclass.jobcompare6300.controller.SystemController;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class CompareJobOffersActivity extends AppCompatActivity {
    private SystemController systemController;

    private EditText title1;
    private EditText company1;
    private EditText city1;
    private EditText state1;
    private EditText costOfLiving1;
    private EditText teleworkTime1;
    private EditText yearlySalary1;
    private EditText yearlyBonus1;
    private EditText retirementBenefits1;
    private EditText leaveTime1;

    private EditText title2;
    private EditText company2;
    private EditText city2;
    private EditText state2;
    private EditText costOfLiving2;
    private EditText teleworkTime2;
    private EditText yearlySalary2;
    private EditText yearlyBonus2;
    private EditText retirementBenefits2;
    private EditText leaveTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_job_offers);

        initializeButtons();
        systemController = new SystemController(this);

        Intent intent = getIntent();
        int num = intent.getIntExtra("num", 0);
        if(num == 1) {
            System.out.println("compare one job offer with current job");
            long jobId = intent.getLongExtra("jobId1", -1);

            Job jobOfferOne = systemController.getJobById(jobId);
            Job currentJob = systemController.getCurrentJob();

            if(jobOfferOne == null) {
                System.out.println("Job one is null");
            }

            if(currentJob == null) {
                System.out.println("current job is null");
            }

            if(jobOfferOne != null && currentJob != null) {
                title1.setText(currentJob.getTitle());
                company1.setText(currentJob.getCompany());
                city1.setText(currentJob.getCity());
                costOfLiving1.setText(String.valueOf(currentJob.getCostOfLivingLocation()));
                state1.setText(currentJob.getState());
                teleworkTime1.setText(String.valueOf(currentJob.getAllowedTeleworkDays()));
                yearlyBonus1.setText(String.valueOf(currentJob.getYearlyBonus()));
                yearlySalary1.setText(String.valueOf(currentJob.getYearlySalary()));
                retirementBenefits1.setText(String.valueOf(currentJob.getRetirementBenefits()));
                leaveTime1.setText(String.valueOf(currentJob.getLeaveTime()));

                title2.setText(jobOfferOne.getTitle());
                company2.setText(jobOfferOne.getCompany());
                city2.setText(jobOfferOne.getCity());
                costOfLiving2.setText(String.valueOf(jobOfferOne.getCostOfLivingLocation()));
                state2.setText(jobOfferOne.getState());
                teleworkTime2.setText(String.valueOf(jobOfferOne.getAllowedTeleworkDays()));
                yearlyBonus2.setText(String.valueOf(jobOfferOne.getYearlyBonus()));
                yearlySalary2.setText(String.valueOf(jobOfferOne.getYearlySalary()));
                retirementBenefits2.setText(String.valueOf(jobOfferOne.getRetirementBenefits()));
                leaveTime2.setText(String.valueOf(jobOfferOne.getLeaveTime()));
            }
        } else if (num == 2) {
            int jobId = intent.getIntExtra("jobId1", -1);
            int jobId2 = intent.getIntExtra("jobId2", -1);
            System.out.println("Got jobId1 " + jobId);
            System.out.println("Got jobId2 " + jobId2);
            Job jobOfferOne = systemController.getJobById((long) jobId);
            Job jobOfferTwo = systemController.getJobById((long) jobId2);

            if (jobOfferOne == null) {
                System.out.println("Job with id " +jobId + " is null");
            }

            if (jobOfferTwo == null) {
                System.out.println("Job with id " +jobId + " is null");
            }

            title1.setText(jobOfferOne.getTitle());
            company1.setText(jobOfferOne.getCompany());
            city1.setText(jobOfferOne.getCity());
            costOfLiving1.setText(String.valueOf(jobOfferOne.getCostOfLivingLocation()));
            state1.setText(jobOfferOne.getState());
            teleworkTime1.setText(String.valueOf(jobOfferOne.getAllowedTeleworkDays()));
            yearlyBonus1.setText(String.valueOf(jobOfferOne.getYearlyBonus()));
            yearlySalary1.setText(String.valueOf(jobOfferOne.getYearlySalary()));
            retirementBenefits1.setText(String.valueOf(jobOfferOne.getRetirementBenefits()));
            leaveTime1.setText(String.valueOf(jobOfferOne.getLeaveTime()));

            title2.setText(jobOfferTwo.getTitle());
            company2.setText(jobOfferTwo.getCompany());
            city2.setText(jobOfferTwo.getCity());
            costOfLiving2.setText(String.valueOf(jobOfferTwo.getCostOfLivingLocation()));
            state2.setText(jobOfferTwo.getState());
            teleworkTime2.setText(String.valueOf(jobOfferTwo.getAllowedTeleworkDays()));
            yearlyBonus2.setText(String.valueOf(jobOfferTwo.getYearlyBonus()));
            yearlySalary2.setText(String.valueOf(jobOfferTwo.getYearlySalary()));
            retirementBenefits2.setText(String.valueOf(jobOfferTwo.getRetirementBenefits()));
            leaveTime2.setText(String.valueOf(jobOfferTwo.getLeaveTime()));
        }

    }

    public void handleCompareAnotherClick(View view) {
        if (view.getId() == R.id.compareAnotherJob) {


            // jump back to CompareJobOffersList for another compare
            Intent intent = new Intent(this, CompareJobOffersListActivity.class);
            startActivity(intent);
        }
    }

    public void handleCancelClick(View view) {
        if (view.getId() == R.id.cancelCompareJob) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeButtons() {
        // Initialize buttons
        title1 = (EditText) findViewById(R.id.titleJob1);
        company1 = (EditText) findViewById(R.id.companyJob1);
        city1 = (EditText) findViewById(R.id.cityJob1);
        state1 = (EditText) findViewById(R.id.stateJob1);
        costOfLiving1 = (EditText) findViewById(R.id.colJob1);
        teleworkTime1 = (EditText) findViewById(R.id.ctwJob1);
        yearlySalary1 = (EditText) findViewById(R.id.yearlySalaryJob1);
        yearlyBonus1 = (EditText) findViewById(R.id.yearlyBonusJob1);
        retirementBenefits1 = (EditText) findViewById(R.id.rbJob1);
        leaveTime1 = (EditText) findViewById(R.id.ltJob1);

        title2 = (EditText) findViewById(R.id.titleJob2);
        company2 = (EditText) findViewById(R.id.companyJob2);
        city2 = (EditText) findViewById(R.id.cityJob2);
        state2 = (EditText) findViewById(R.id.stateJob2);
        costOfLiving2 = (EditText) findViewById(R.id.colJob2);
        teleworkTime2 = (EditText) findViewById(R.id.ctwJob2);
        yearlySalary2 = (EditText) findViewById(R.id.yearlySalaryJob2);
        yearlyBonus2 = (EditText) findViewById(R.id.yearlyBonusJob2);
        retirementBenefits2 = (EditText) findViewById(R.id.rbJob2);
        leaveTime2 = (EditText) findViewById(R.id.ltJob2);

    }

}