package com.example.homework2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FirstFragment extends Fragment {

    private List<News> newsList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_layout,container,false);

        initNews();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);


        return view;
    }


    public void initNews(){
        for (int i = 0;i < 5;i++) {
            News n1 = new News("林神的新闻",getRandomLengthContent("林神"));
            newsList.add(n1);
            News n2 = new News("涛神的新闻",getRandomLengthContent("涛神"));
            newsList.add(n2);
            News n3 = new News("哲神的新闻",getRandomLengthContent("哲神"));
            newsList.add(n3);
            News n4 = new News("煜神的新闻",getRandomLengthContent("煜神"));
            newsList.add(n4);
            News n5 = new News("齐神的新闻",getRandomLengthContent("齐神"));
            newsList.add(n5);
            News n6 = new News("徐神的新闻",getRandomLengthContent("徐神"));
            newsList.add(n6);
        }

    }


    public String getRandomLengthContent(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name + "YYDS");
        }
        return builder.toString();
    }
}
