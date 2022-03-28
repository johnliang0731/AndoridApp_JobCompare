package edu.gatech.seclass.jobcompare6300.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class JobListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    private final List<Job> jobOffers;

    private Map<Integer, Boolean> checkedMap;


    public JobListAdapter(Activity context, List<Job> jobOffers) {
        super(context, R.layout.listview_row , jobOffers);
        this.context = context;
        this.jobOffers = jobOffers;
        this.checkedMap = new HashMap<>();
    }

    public View getView(int position, View view, ViewGroup parent) {
        System.out.println("Calling get view!!!!!!!");
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView jobTitleTextField = (TextView) rowView.findViewById(R.id.jobTitle);
        TextView jobCompanyTextField = (TextView) rowView.findViewById(R.id.jobCompany);
        TextView jobIdHiddenTextField = (TextView) rowView.findViewById(R.id.jobRowId);
        CheckBox jobCheckBox = (CheckBox) rowView.findViewById(R.id.jobSelectBox);

        //this code sets the values of the objects to values from the arrays
        jobTitleTextField.setText(jobOffers.get(position).getTitle());
        if (jobOffers.get(position).isCurrentJob()){
            String companyTextField = jobOffers.get(position).getCompany() + " (current)";
            jobCompanyTextField.setText(companyTextField);
        } else {
            jobCompanyTextField.setText(jobOffers.get(position).getCompany());
        }
        jobIdHiddenTextField.setText(String.valueOf(jobOffers.get(position).getId()));

        checkedMap.put(position, false);

        jobCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkedMap.put(position, true);
            } else {
                checkedMap.put(position, false);
            }
        });


        return rowView;

    }

    public Map<Integer, Boolean> getCheckedMap() {
        return checkedMap;
    }
}

