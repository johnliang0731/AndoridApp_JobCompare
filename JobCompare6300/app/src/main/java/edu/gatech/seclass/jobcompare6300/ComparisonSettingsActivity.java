package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.seclass.jobcompare6300.controller.SystemController;
import edu.gatech.seclass.jobcompare6300.model.ComparisonSettings;

public class ComparisonSettingsActivity extends AppCompatActivity {

    private EditText ctw;
    private EditText salaryw;
    private EditText bonusw;
    private EditText rbw;
    private EditText ltw;

    private SystemController systemController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        initializeButtons();

        systemController = new SystemController(this);
        ComparisonSettings comparisonSettings = systemController.getComparisonSettings();
        if(comparisonSettings == null) {
            comparisonSettings = new ComparisonSettings(1, 1, 1, 1,1);
            comparisonSettings.setId(1);
            systemController.saveComparisonSettings(comparisonSettings);
        }

        ctw.setText(String.valueOf(comparisonSettings.getWeeklyTeleworkDaysWeight()));
        salaryw.setText(String.valueOf(comparisonSettings.getYearlySalaryWeight()));
        bonusw.setText(String.valueOf(comparisonSettings.getYearlyBonusWeight()));
        rbw.setText(String.valueOf(comparisonSettings.getRetirementBenefitsWeight()));
        ltw.setText(String.valueOf(comparisonSettings.getLeaveTimeWeight()));

    }

    public void handleSaveClick(View view) {
        if (view.getId() == R.id.compare) {
            if(!inputValidationCheck()) {
                ComparisonSettings comparisonSettings = new ComparisonSettings();

                comparisonSettings.setId(1);

                comparisonSettings.setYearlySalaryWeight(Integer.parseInt(salaryw.getText().toString().trim()));
                comparisonSettings.setYearlyBonusWeight(Integer.parseInt(bonusw.getText().toString().trim()));
                comparisonSettings.setWeeklyTeleworkDaysWeight(Integer.parseInt(ctw.getText().toString().trim()));
                comparisonSettings.setRetirementBenefitsWeight(Integer.parseInt(rbw.getText().toString().trim()));
                comparisonSettings.setLeaveTimeWeight(Integer.parseInt(ltw.getText().toString().trim()));

                systemController.saveComparisonSettings(comparisonSettings);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void handleCancelClick(View view) {
        if (view.getId() == R.id.cancel) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeButtons() {
        // Initialize buttons
        ctw = (EditText) findViewById(R.id.ctw);
        salaryw = (EditText) findViewById(R.id.salaryw);
        bonusw = (EditText) findViewById(R.id.bonusw);
        rbw = (EditText) findViewById(R.id.rbw);
        ltw = (EditText) findViewById(R.id.ltw);

    }


    private boolean isPosInteger(String str) {
        boolean res = false;
        if(str.isEmpty()) {
            return res;
        }
        try {
            int num = Integer.parseInt(str);
            if(num >= 1 && num <=10) { res = true; }
        }
        catch (NumberFormatException e) {
            res = false;
        }

        return res;
    }

    private boolean inputValidationCheck() {
        boolean haveError = false;

        if (ctw.getText().toString().trim().isEmpty() || !isPosInteger(ctw.getText().toString().trim()) ) {
            ctw.setError("Should be positive integer between 1~10");
            haveError = true;
        }

        if (salaryw.getText().toString().trim().isEmpty() || !isPosInteger(salaryw.getText().toString().trim())) {
            salaryw.setError("Should be positive integer between 1~10");
            haveError = true;
        }

        if ( bonusw.getText().toString().trim().isEmpty() || !isPosInteger(bonusw.getText().toString().trim()) ) {
            bonusw.setError("Should be positive integer between 1~10");
            haveError = true;
        }

        if (rbw.getText().toString().trim().isEmpty() || !isPosInteger(rbw.getText().toString().trim())) {
            rbw.setError("Should be positive integer between 1~10");
            haveError = true;
        }

        if (ltw.getText().toString().trim().isEmpty() || !isPosInteger(ltw.getText().toString().trim())) {
            ltw.setError("Should be positive integer between 1~10");
            haveError = true;
        }

        return haveError;
    }
}