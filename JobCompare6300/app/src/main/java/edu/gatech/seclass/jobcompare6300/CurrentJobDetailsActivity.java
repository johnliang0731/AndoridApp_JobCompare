package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.jobcompare6300.controller.SystemController;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class CurrentJobDetailsActivity extends AppCompatActivity {

    private EditText title;
    private EditText company;
    private EditText city;
    private EditText state;
    private EditText costOfLiving;
    private EditText allowedTeleworkDays;
    private EditText yearlySalary;
    private EditText yearlyBonus;
    private EditText retirementBenefits;
    private EditText leaveTime;

    private SystemController systemController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job_details);

        systemController = new SystemController(this);

        initializeButtons();

        if (systemController.getCurrentJob() != null) {
            Job currentJob = systemController.getCurrentJob();
            title.setText(currentJob.getTitle());
            company.setText(currentJob.getCompany());
            city.setText(currentJob.getCity());
            costOfLiving.setText(String.valueOf(currentJob.getCostOfLivingLocation()));
            state.setText(currentJob.getState());
            allowedTeleworkDays.setText(String.valueOf(currentJob.getAllowedTeleworkDays()));
            yearlyBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
            yearlySalary.setText(String.valueOf(currentJob.getYearlySalary())); //Important to use String.valueOf otherwise resource not found exception is thrown
            retirementBenefits.setText(String.valueOf(currentJob.getRetirementBenefits()));
            leaveTime.setText(String.valueOf(currentJob.getLeaveTime()));
        }
    }

    public void handleSaveClick(View view) {
        if (view.getId() == R.id.saveCurrentJob) {

            if(inputValidationCheck()) {
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "Error, input invalid information", duration);
                toast.show();
                System.out.println("input invalid information");
            } else {
                Job job = new Job();
                if (systemController.getCurrentJob() != null){
                    job.setId(systemController.getCurrentJob().getId()); // Ensures current job is overwritten
                }
                job.setTitle(title.getText().toString().trim());
                job.setCompany(company.getText().toString().trim());
                job.setCity(city.getText().toString().trim());
                job.setCostOfLivingLocation(Integer.parseInt(costOfLiving.getText().toString().trim()));
                job.setState(state.getText().toString().trim());
                job.setAllowedTeleworkDays(Integer.parseInt(allowedTeleworkDays.getText().toString().trim()));
                job.setYearlyBonus(Double.parseDouble(yearlyBonus.getText().toString().trim()));
                job.setYearlySalary(Double.parseDouble(yearlySalary.getText().toString().trim()));
                job.setRetirementBenefits(Integer.parseInt(retirementBenefits.getText().toString().trim()));
                job.setLeaveTime(Integer.parseInt(leaveTime.getText().toString().trim()));
                job.setCurrentJob(true);
                systemController.saveJobOffer(job);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }

        }
    }

    public void handleCancelClick(View view) {
        if (view.getId() == R.id.cancelCurrentJob) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeButtons() {
        // Initialize buttons
        title = (EditText) findViewById(R.id.title);
        company = (EditText) findViewById(R.id.company);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        costOfLiving = (EditText) findViewById(R.id.col);
        allowedTeleworkDays = (EditText) findViewById(R.id.ctw);
        yearlySalary = (EditText) findViewById(R.id.salaryw);
        yearlyBonus = (EditText) findViewById(R.id.bonusw);
        retirementBenefits = (EditText) findViewById(R.id.rbw);
        leaveTime = (EditText) findViewById(R.id.ltw);
    }

    private boolean isInteger(String str) {
        boolean res = false;
        if(str.isEmpty()) {
            return res;
        }
        try {
            int num = Integer.parseInt(str);
            if(num >= 0) { res = true; }
        }
        catch (NumberFormatException e) {
            res = false;
        }

        return res;
    }

    private boolean isPosInteger(String str) {
        boolean res = false;
        if(str.isEmpty()) {
            return res;
        }
        try {
            int num = Integer.parseInt(str);
            if(num > 0) { res = true; }
        }
        catch (NumberFormatException e) {
            res = false;
        }

        return res;
    }

    private boolean isDouble(String str) {
        boolean res = false;
        if(str.isEmpty()) {
            return res;
        }
        try {
            double num = Double.parseDouble(str);
            res = true;
        }
        catch (NumberFormatException e) {
            res = false;
        }

        return res;
    }

    private boolean inputValidationCheck() {
        boolean haveError = false;

        if (title.getText().toString().trim().isEmpty()) {
            title.setError("Title cannot be Empty");
            haveError = true;
        }

        if (company.getText().toString().trim().isEmpty() ) {
            company.setError("Company cannot be Empty");
            haveError = true;
        }

        if (city.getText().toString().trim().isEmpty()) {
            city.setError("City cannot be Empty");
            haveError = true;
        }

        if (state.getText().toString().trim().isEmpty() ) {
            state.setError("State cannot be Empty");
            haveError = true;
        }

        if (costOfLiving.getText().toString().trim().isEmpty() || !isPosInteger(costOfLiving.getText().toString().trim())) {
            costOfLiving.setError("Cost of Living cannot be Empty");
            haveError = true;
        }

        if (allowedTeleworkDays.getText().toString().trim().isEmpty() || !isInteger(allowedTeleworkDays.getText().toString().trim())) {
            allowedTeleworkDays.setError("Remote Work Day cannot be Empty");
            haveError = true;
        }  else if (Integer.parseInt(allowedTeleworkDays.getText().toString().trim()) > 5) {
            allowedTeleworkDays.setError("Remote Work Day should between  0 to 5");
            haveError = true;
        }

        if (yearlyBonus.getText().toString().trim().isEmpty() || !isDouble(yearlyBonus.getText().toString().trim())) {
            yearlyBonus.setError("Yearly Bonus cannot be Empty");
            haveError = true;
        }

        if (yearlySalary.getText().toString().trim().isEmpty() || !isDouble(yearlySalary.getText().toString().trim())) {
            yearlySalary.setError("Yearly Salary cannot be Empty");
            haveError = true;
        }

        if (retirementBenefits.getText().toString().trim().isEmpty() || !isInteger(retirementBenefits.getText().toString().trim())) {
            retirementBenefits.setError("Retirement Benefits cannot be Empty");
            haveError = true;
        }
        else if(Integer.parseInt(retirementBenefits.getText().toString().trim()) > 100 || Integer.parseInt(retirementBenefits.getText().toString().trim()) < 0) {
            retirementBenefits.setError("Retirement Benefits must be in 1~100");
            haveError = true;
        }

        if (leaveTime.getText().toString().trim().isEmpty() || !isInteger(leaveTime.getText().toString().trim())) {
            leaveTime.setError("Leave Time cannot be Empty");
            haveError = true;
        }  else if (Integer.parseInt(leaveTime.getText().toString()) > 365) {
            leaveTime.setError("Leave Time should cannot exceed 365 days/year");
            haveError = true;
        }

        return haveError;
    }

}