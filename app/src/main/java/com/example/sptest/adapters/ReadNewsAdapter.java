package com.example.sptest.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sptest.R;
import com.example.sptest.SecondActivity;
import com.example.sptest.dto.SPInteractive;
import com.example.sptest.entity.News;

import java.util.List;

/**
 * @author Seaguller
 * @date 2021/9/30 15:14
 * @Description
 */
public class ReadNewsAdapter extends RecyclerView.Adapter<ReadNewsAdapter.ViewHolder> {

    private List<News> mReadNewsList;

    public ReadNewsAdapter(List<News> newsList) {
        mReadNewsList = newsList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View newsView;
        ImageView newsReadFlag;
        TextView newsTitle;

        public ViewHolder(View view) {
            super(view);

            newsView = view;
            newsReadFlag = view.findViewById(R.id.read_news_read_flag);
            newsTitle = view.findViewById(R.id.read_news_title);
        }
    }

    @NonNull
    @Override
    public ReadNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.read_news_item, parent, false);

        ReadNewsAdapter.ViewHolder viewHolder = new ReadNewsAdapter.ViewHolder(view);

        /* 列表点击事件，点击后跳转到新闻内容活动页 */
        viewHolder.newsView.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            News news = mReadNewsList.get(position);

            SPInteractive.saveNewsContent(view.getContext(), news.getContent());
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            v.getContext().startActivity(intent);
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReadNewsAdapter.ViewHolder holder, int position) {
        News news = mReadNewsList.get(position);

        holder.newsTitle.setText(news.getTitle());
        holder.newsReadFlag.setImageResource(news.getImageId());

    }

    @Override
    public int getItemCount() {
        return mReadNewsList.size();
    }
}
