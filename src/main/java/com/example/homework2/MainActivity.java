package com.example.homework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        //初始化FragmentLists
        List<Fragment> FragmentLists = new ArrayList<>();
        FragmentLists.add(new FirstFragment());
        FragmentLists.add(new SecondFragment());
        FragmentLists.add(new ThirdFragment());



        //给viewPager添加适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return FragmentLists.get(position);
            }

            @Override
            public int getCount() {
                return FragmentLists.size();
            }
        });


        //设置TabLayout和ViewPager联动
        tabLayout.setupWithViewPager(viewPager,false);



        //用数组保存每一个Tab的文字
        String[] tabs = {"page1", "page2", "page3"};


        //给tabLayout添加Tab
        for(int i = 0;i < tabs.length;i++){
            Objects.requireNonNull(tabLayout.getTabAt(i)).setText(tabs[i]);
        }



    }
}