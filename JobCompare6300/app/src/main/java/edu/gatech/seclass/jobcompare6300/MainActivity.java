package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.gatech.seclass.jobcompare6300.controller.SystemController;

public class MainActivity extends AppCompatActivity {

    private SystemController systemController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        systemController = new SystemController(this);
    }

    public void handleCurrentJobDetailsClick(View view) {
        if (view.getId() == R.id.jobDetails) {
            Intent intent = new Intent(this, CurrentJobDetailsActivity.class);
            startActivity(intent);
        }
    }

    public void handleJobOffersClick(View view) {
        if (view.getId() == R.id.jobOffer) {
            Intent intent = new Intent(this, JobOfferActivity.class);
            startActivity(intent);
        }
    }

    public void handleComparisonSettingsClick(View view) {
        if (view.getId() == R.id.comparisonSettings) {
            Intent intent = new Intent(this, ComparisonSettingsActivity.class);
            startActivity(intent);
        }
    }

    public void handleCompareJobsClick(View view) {
        if (view.getId() == R.id.compareJobOffers) {
            if (systemController.getJobOffers().size() >=2 ||
                    (systemController.getJobOffers().size() >= 1 && systemController.getCurrentJob() != null)
            ) {
                // Only compare jobs if there are at least two offers
                // or one current job and at least one job offer
                Intent intent = new Intent(this, CompareJobOffersListActivity.class);
                startActivity(intent);
            } else {
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "You need to enter at least two job offers or your current job and one job offer", duration);
                toast.show();
            }
        }
    }
}