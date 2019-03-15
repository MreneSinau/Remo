package com.mrenesinau.remo.ViewHolder;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mrenesinau.remo.R;

/**
 * Created by adipu on 04/01/2018.
 */

public class ViewPageAdapter extends PagerAdapter {

    private Integer [] images = {R.mipmap.slider1, R.mipmap.slider2, R.mipmap.slider3, R.mipmap.slider4};
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewPageAdapter(Context context) {
        this.context = context;

    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==  object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageview = (ImageView) view.findViewById(R.id.imageView);
        imageview.setImageResource(images[position]);

        ViewPager vp=(ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp=(ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
