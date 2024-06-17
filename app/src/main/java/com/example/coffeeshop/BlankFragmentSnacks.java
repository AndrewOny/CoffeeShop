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


public class BlankFragmentSnacks extends Fragment {

    private BlankFragmentSizes.CheckboxListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank_snacks, container, false);

        // Retrieve the checkbox views
        CheckBox checkBox7 = rootView.findViewById(R.id.checkBox7);
        CheckBox checkBox8 = rootView.findViewById(R.id.checkBox8);
        CheckBox checkBox9 = rootView.findViewById(R.id.checkBox9);
        CheckBox checkBox10 = rootView.findViewById(R.id.checkBox10);

        // Set the initial checkbox state
        boolean isChecked = false; // Initialize it with your logic to determine the checkbox state
        checkBox7.setChecked(isChecked);
        checkBox8.setChecked(isChecked);
        checkBox9.setChecked(isChecked);
        checkBox10.setChecked(isChecked);


        // Set listeners for checkbox state changes
        checkBox7.setOnCheckedChangeListener(createCheckedChangeListener(7));
        checkBox8.setOnCheckedChangeListener(createCheckedChangeListener(8));
        checkBox9.setOnCheckedChangeListener(createCheckedChangeListener(9));
        checkBox10.setOnCheckedChangeListener(createCheckedChangeListener(10));


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
        if (context instanceof BlankFragmentSizes.CheckboxListener) {
            mListener = (BlankFragmentSizes.CheckboxListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement CheckboxListener");
        }
    }

    public void updateCheckboxState(boolean isChecked) {
        // This method can be used to update checkbox state from the hosting activity, if needed
    }
}
