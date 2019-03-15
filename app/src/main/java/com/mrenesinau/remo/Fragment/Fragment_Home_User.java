package com.mrenesinau.remo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrenesinau.remo.R;
import com.mrenesinau.remo.ViewHolder.ViewPageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home_User extends Fragment {

    ViewPager PagerHomme;


    public Fragment_Home_User() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentview = inflater.inflate(R.layout.fragment_home__user, container, false);

        //=================slider==============
        PagerHomme = (ViewPager) fragmentview.findViewById(R.id.PagerHomme);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getActivity());
        PagerHomme.setAdapter(viewPageAdapter);
        //=================slider==============

        return fragmentview;
    }

}
