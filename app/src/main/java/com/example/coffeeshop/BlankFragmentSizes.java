package com.example.coffeeshop;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class BlankFragmentSizes extends Fragment {

    private CheckboxListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank_sizes, container, false);

        // Retrieve the checkbox views
        CheckBox checkBox1 = rootView.findViewById(R.id.checkBox1);
        CheckBox checkBox2 = rootView.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = rootView.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = rootView.findViewById(R.id.checkBox4);
        CheckBox checkBox5 = rootView.findViewById(R.id.checkBox5);
        CheckBox checkBox6 = rootView.findViewById(R.id.checkBox6);

        // Set the initial checkbox state
        boolean isChecked = false; // Initialize it with your logic to determine the checkbox state
        checkBox1.setChecked(isChecked);
        checkBox2.setChecked(isChecked);
        checkBox3.setChecked(isChecked);
        checkBox4.setChecked(isChecked);
        checkBox5.setChecked(isChecked);
        checkBox6.setChecked(isChecked);

        // Set listeners for checkbox state changes
        checkBox1.setOnCheckedChangeListener(createCheckedChangeListener(1));
        checkBox2.setOnCheckedChangeListener(createCheckedChangeListener(2));
        checkBox3.setOnCheckedChangeListener(createCheckedChangeListener(3));
        checkBox4.setOnCheckedChangeListener(createCheckedChangeListener(4));
        checkBox5.setOnCheckedChangeListener(createCheckedChangeListener(5));
        checkBox6.setOnCheckedChangeListener(createCheckedChangeListener(6));

        return rootView;
    }

    // Method to create a listener for checkbox state changes
    private CompoundButton.OnCheckedChangeListener createCheckedChangeListener(final int checkboxNumber) {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle checkbox state changes here
                if (mListener != null) {
                    mListener.onCheckboxClicked(isChecked, checkboxNumber);
                }
            }
        };
    }

    public interface CheckboxListener {
        void onCheckboxClicked(boolean isChecked, int checkboxNumber);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof CheckboxListener) {
            mListener = (CheckboxListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement CheckboxListener");
        }
    }

    public void updateCheckboxState(boolean isChecked) {
        // This method can be used to update checkbox state from the hosting activity, if needed
    }
}
