package com.mrenesinau.remo.Model;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrenesinau.remo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Edit_Profile extends Fragment {


    public Edit_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit__profile, container, false);

    }

}
