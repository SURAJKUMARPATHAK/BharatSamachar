package com.my.bharatsamachar.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.my.bharatsamachar.R;
import com.my.bharatsamachar.adapter.PagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    TextView breakingt,breakingtext;
    ViewPager simpleViewPager ;
    TabLayout tabLayout ;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homek, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        breakingt = view.findViewById(R.id.breakingt);
        breakingtext = view.findViewById(R.id.textBreaking);
        simpleViewPager = ( ViewPager ) view.findViewById ( R . id.viewpager );
        tabLayout = ( TabLayout ) view.findViewById ( R . id .tablayout );




        TabLayout.Tab  firstTab = tabLayout.newTab();
        firstTab.setText("Home");
        tabLayout.addTab(firstTab);
        // tabLayout.setTabGravity(1);

        TabLayout.Tab  secondTab = tabLayout.newTab();
        secondTab.setText("LiveTv");
        tabLayout.addTab(secondTab);
        // tabLayout.setTabGravity(1);

        TabLayout.Tab  thirdTab = tabLayout.newTab();
        thirdTab.setText("Photo");
        tabLayout.addTab(thirdTab);
        //tabLayout.setTabGravity(1);

        PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager() , tabLayout.getTabCount());
        simpleViewPager.setAdapter(adapter);

// addOnPageChangeListener event change the tab on slide
        simpleViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        //event change the tab on click
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                simpleViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(400); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // if you want to change color at start of animation
                //textview.settextcolor("your color")
                breakingt.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // if you want to change color at end of animation
                //textview.settextcolor("your color")
               // breakingt.setTextColor(getResources().getColor(R.color.yellow));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {


            }
        });
        breakingt.startAnimation(anim);


    }
}
