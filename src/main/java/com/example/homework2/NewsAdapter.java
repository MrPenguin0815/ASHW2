package com.example.homework2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNewsList;


    //静态内部类ViewHolder，对子布局中每一个控件的实例进行缓存
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsName;
        TextView newsContent;

        public ViewHolder(View view) {
            super(view);
            newsContent = view.findViewById(R.id.news_content);
            newsName = view.findViewById(R.id.news_name);

        }
    }


    //适配器构造器，传入新闻集合作为数据源
    public NewsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //依据子项布局建立新视图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        //实例化子项视图的viewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override//该方法给viewHolder里面的每一个控件赋值
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.newsName.setText(news.getName());
        holder.newsContent.setText(news.getContent());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

}
