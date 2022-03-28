package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.gatech.seclass.jobcompare6300.adapter.JobListAdapter;
import edu.gatech.seclass.jobcompare6300.controller.SystemController;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class CompareJobOffersListActivity extends AppCompatActivity {

    private SystemController systemController;
    private ListView listView;
    private JobListAdapter jobListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_job_offers_list);

        systemController = new SystemController(this);
        System.out.println("There are " + systemController.getJobOffers().size() + " jobs in the system!!!!");

        // need to attract all the job title and job company from database

        jobListAdapter = new JobListAdapter(this, systemController.getTopJobOffers());
        listView = (ListView) findViewById(R.id.jobOfferList);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(jobListAdapter);


    }

    public void handleCompareClick(View view) {
        if (view.getId() == R.id.compareJobList) {

            // need to save the selection result and send to job compare activity
            Map<Integer,Boolean> checkedItemsMap = jobListAdapter.getCheckedMap();
            List<Integer> checkPositions = new ArrayList<>();
            int totalChecked = 0;
            for (Map.Entry<Integer,Boolean> entry : checkedItemsMap.entrySet()) {
                if (entry.getValue()){
                    totalChecked += 1;
                    checkPositions.add(entry.getKey());
                }
            }

            if (totalChecked == 2){
                Intent intent = new Intent(this, CompareJobOffersActivity.class);
                List<Job> selectedJobs = checkPositions
                        .stream()
                        .map(position -> (Job) jobListAdapter.getItem(position))
                        .collect(Collectors.toList());
                selectedJobs.forEach(job -> {
                    System.out.println(job.getId());
                    System.out.println(job.getTitle());
                });
                intent.putExtra("num", 2);
                intent.putExtra("jobId1", selectedJobs.get(0).getId());
                intent.putExtra("jobId2", selectedJobs.get(1).getId());
                startActivity(intent);
            } else {
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(this, "You must select 2 jobs to compare", duration);
                toast.show();
            }
        }
    }

    public void handleCancelClick(View view) {
        if (view.getId() == R.id.cancelJobList) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
