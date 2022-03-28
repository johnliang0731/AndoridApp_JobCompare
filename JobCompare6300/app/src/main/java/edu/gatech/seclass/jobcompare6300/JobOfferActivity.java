package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.jobcompare6300.controller.SystemController;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class JobOfferActivity extends AppCompatActivity {

    private EditText title;
    private EditText company;
    private EditText city;
    private EditText state;
    private EditText costOfLiving;
    private EditText teleworkDays;
    private EditText yearlySalary;
    private EditText yearlyBonus;
    private EditText retirementBenefits;
    private EditText leaveTime;

    private SystemController systemController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);
        initializeButtons();
        systemController = new SystemController(this);
    }

    public void handleSaveClick(View view) {
        boolean haveError = false;

        if (view.getId() == R.id.saveJobOffers) {

            if(inputValidationCheck()) {

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "Error, input invalid information", duration);
                toast.show();
                System.out.println("input invalid information");

            } else {

                Job job = new Job();

                job.setTitle(title.getText().toString());
                job.setCompany(company.getText().toString());
                job.setCity(city.getText().toString());
                job.setCostOfLivingLocation(Integer.parseInt(costOfLiving.getText().toString()));
                job.setState(state.getText().toString());
                job.setAllowedTeleworkDays(Integer.parseInt(teleworkDays.getText().toString()));
                job.setYearlyBonus(Double.parseDouble(yearlyBonus.getText().toString()));
                job.setYearlySalary(Double.parseDouble(yearlySalary.getText().toString()));
                job.setRetirementBenefits(Integer.parseInt(retirementBenefits.getText().toString()));
                job.setLeaveTime(Integer.parseInt(leaveTime.getText().toString()));
                job.setCurrentJob(false);
                systemController.saveJobOffer(job);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            };
        }
    }

    public void handleSaveAndEnterNewOfferClick(View view) {
        if (view.getId() == R.id.save2) {

            if(inputValidationCheck()) {

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "Error, input invalid information", duration);
                toast.show();
                System.out.println("input invalid information");

            } else {

                Job job = new Job();

                job.setTitle(title.getText().toString());
                job.setCompany(company.getText().toString());
                job.setCity(city.getText().toString());
                job.setCostOfLivingLocation(Integer.parseInt(costOfLiving.getText().toString()));
                job.setState(state.getText().toString());
                job.setAllowedTeleworkDays(Integer.parseInt(teleworkDays.getText().toString()));
                job.setYearlyBonus(Double.parseDouble(yearlyBonus.getText().toString()));
                job.setYearlySalary(Double.parseDouble(yearlySalary.getText().toString()));
                job.setRetirementBenefits(Integer.parseInt(retirementBenefits.getText().toString()));
                job.setLeaveTime(Integer.parseInt(leaveTime.getText().toString()));
                job.setCurrentJob(false);
                systemController.saveJobOffer(job);

                int duration1 = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "Job Saved", duration1);
                toast.show();

                System.out.println("save and enter new job offer");

                clearTexts();
            }
        }
    }

    public void handleCancelClick(View view) {
        if (view.getId() == R.id.cancelJobOffers) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void handleCompareJobsClick(View view) {
        if (view.getId() == R.id.compareCurrent) {

        }
            if(systemController.getCurrentJob() == null) { //disable this functionality if current job is not entered

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "Current job not exist, please enter a current job", duration);
                toast.show();
//                return;

            } else if(inputValidationCheck()) {

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "Error, input invalid information", duration);
                toast.show();
                System.out.println("input invalid information");

            } else {

            Job job = new Job();

            job.setTitle(title.getText().toString().trim());
            job.setCompany(company.getText().toString().trim());
            job.setCity(city.getText().toString().trim());
            job.setCostOfLivingLocation(Integer.parseInt(costOfLiving.getText().toString().trim()));
            job.setState(state.getText().toString().trim());
            job.setAllowedTeleworkDays(Integer.parseInt(teleworkDays.getText().toString().trim()));
            job.setYearlyBonus(Double.parseDouble(yearlyBonus.getText().toString().trim()));
            job.setYearlySalary(Double.parseDouble(yearlySalary.getText().toString().trim()));
            job.setRetirementBenefits(Integer.parseInt(retirementBenefits.getText().toString().trim()));
            job.setLeaveTime(Integer.parseInt(leaveTime.getText().toString().trim()));
            job.setCurrentJob(false);
            long jobId = systemController.saveJobOffer(job);

            Intent intent = new Intent(this, CompareJobOffersActivity.class);


            System.out.println("generate job id as: " + jobId);

            intent.putExtra("num", 1);
            intent.putExtra("jobId1", jobId);
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
        teleworkDays = (EditText) findViewById(R.id.ctw);
        yearlySalary = (EditText) findViewById(R.id.salaryw);
        yearlyBonus = (EditText) findViewById(R.id.bonusw);
        retirementBenefits = (EditText) findViewById(R.id.rbw);
        leaveTime = (EditText) findViewById(R.id.ltw);
    }

    private void clearTexts() {
        title.setText("");
        company.setText("");
        city.setText("");
        costOfLiving.setText("");
        state.setText("");
        teleworkDays.setText("");
        yearlyBonus.setText("");
        yearlySalary.setText(""); //Important to use String.valueOf otherwise resource not found exception is thrown
        retirementBenefits.setText("");
        leaveTime.setText("");
    }

    private boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean inputValidationCheck() {
        boolean haveError = false;

        if ( title.getText().toString().length() == 0 || title.getText().toString().trim().isEmpty() ) {
            title.setError("Title cannot be Empty");
            haveError = true;
        }

        if ( company.getText().toString().length() == 0 || company.getText().toString().trim().isEmpty() ) {
            company.setError("Company cannot be Empty");
            haveError = true;
        }

        if ( city.getText().toString().length() == 0 || city.getText().toString().trim().isEmpty() ) {
            city.setError("City cannot be Empty");
            haveError = true;
        }

        if ( state.getText().toString().length() == 0 || state.getText().toString().trim().isEmpty() ) {
            state.setError("State cannot be Empty");
            haveError = true;
        }

        if ( costOfLiving.getText().toString().length() == 0 || costOfLiving.getText().toString().trim().isEmpty() ) {
            costOfLiving.setError("Cost of Living cannot be Empty");
            haveError = true;
        } else if ( !isNumeric(costOfLiving.getText().toString().trim()) ) {
            costOfLiving.setError("Cost of Living should be positive integer");
            haveError = true;
        } else if (Integer.parseInt(costOfLiving.getText().toString().trim()) == 0) {
            costOfLiving.setError("Cost of Living should not be 0");
            haveError = true;
        }

        if ( teleworkDays.getText().toString().length() == 0 || teleworkDays.getText().toString().trim().isEmpty() ) {
            teleworkDays.setError("Remote Work Day cannot be Empty");
            haveError = true;
        } else if ( !isNumeric(teleworkDays.getText().toString().trim()) ) {
            teleworkDays.setError("Remote Work Day should be 0 or positive integer");
            haveError = true;
        } else if (Integer.parseInt(teleworkDays.getText().toString().trim()) > 5) {
            teleworkDays.setError("Remote Work Day should between  0 to 5");
            haveError = true;
        }

        if ( yearlyBonus.getText().toString().length() == 0 || yearlyBonus.getText().toString().trim().isEmpty() ) {
            yearlyBonus.setError("Yearly Bonus cannot be Empty");
            haveError = true;
        } else {
            try {
                Double doub1 = Double.parseDouble(yearlyBonus.getText().toString().trim());
            } catch (NumberFormatException ex) {
                yearlyBonus.setError("Yearly Bonus should >= 0, example: 15000.00");
                haveError = true;
            }
        }

        if ( yearlySalary.getText().toString().length() == 0 || yearlySalary.getText().toString().trim().isEmpty() ) {
            yearlySalary.setError("Yearly Salary cannot be Empty");
            haveError = true;
        } else {
            try {
                Double doub = Double.parseDouble(yearlySalary.getText().toString().trim());
            } catch (NumberFormatException ex) {
                yearlySalary.setError("Yearly Salary should >= 0, example: 45000.00");
                haveError = true;
            }
        }

        if ( retirementBenefits.getText().toString().length() == 0 || retirementBenefits.getText().toString().trim().isEmpty() ) {
            retirementBenefits.setError("Retirement Benefits cannot be Empty");
            haveError = true;
        } else if ( !isNumeric(retirementBenefits.getText().toString().trim()) ) {
            retirementBenefits.setError("Retirement benefits should be 0 or positive integer");
            haveError = true;
        } else if(Integer.parseInt(retirementBenefits.getText().toString().trim()) > 100 || Integer.parseInt(retirementBenefits.getText().toString().trim()) < 0) {
            retirementBenefits.setError("Retirement Benefits must be in 1~100");
            haveError = true;
        }

        if ( leaveTime.getText().toString().length() == 0 || leaveTime.getText().toString().trim().isEmpty() ) {
            leaveTime.setError("Leave Time cannot be Empty");
            haveError = true;
        } else if ( !isNumeric(leaveTime.getText().toString().trim()) ) {
            leaveTime.setError("Leave Time should be 0 or positive integer");
            haveError = true;
        } else if (Integer.parseInt(leaveTime.getText().toString().trim()) > 365) {
            leaveTime.setError("Leave Time should cannot exceed 365 days/year");
            haveError = true;
        }

        return haveError;
    }

}

