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
import com.example.sptest.component.NewsListManage;
import com.example.sptest.dto.SPInteractive;
import com.example.sptest.entity.News;

import java.util.List;

/**
 * @author Seaguller
 * @date 2021/10/8 14:09
 * @Description
 */
public class UnreadNewsAdapter extends RecyclerView.Adapter<UnreadNewsAdapter.ViewHolder> {

    private List<News> mUnreadNewsList;

    private NewsListManage newsListManage = NewsListManage.getInstance();

    public UnreadNewsAdapter() {
        mUnreadNewsList = newsListManage.getUnreadNewsList();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View newsView;
        ImageView newsReadFlag;
        TextView newsTitle;

        public ViewHolder(View view) {
            super(view);

            newsView = view;
            newsReadFlag = view.findViewById(R.id.unread_news_read_flag);
            newsTitle = view.findViewById(R.id.unread_news_title);
        }
    }

    @NonNull
    @Override
    public UnreadNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unread_news_item, parent, false);

        UnreadNewsAdapter.ViewHolder viewHolder = new UnreadNewsAdapter.ViewHolder(view);

        /* 列表点击事件，点击后跳转到新闻内容活动页，并设置新闻为“已读” */
        viewHolder.newsView.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            News news = mUnreadNewsList.get(position);

            /* 新闻阅读检查 */
            newsReadChecking(viewHolder, news);

            SPInteractive.saveNewsContent(view.getContext(), news.getContent());
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            v.getContext().startActivity(intent);
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UnreadNewsAdapter.ViewHolder holder, int position) {
        News news = mUnreadNewsList.get(position);

        holder.newsTitle.setText(news.getTitle());
        holder.newsReadFlag.setImageResource(news.getImageId());

    }

    @Override
    public int getItemCount() {
        return mUnreadNewsList.size();
    }

    /**
     * 新闻是否阅读检查，若已阅读则改变其图片，并更新未读列表
     * @param holder
     * @param news
     */
    private void newsReadChecking(UnreadNewsAdapter.ViewHolder holder, News news) {
        if (!news.isRead()) {
            newsListManage.newsBecomesRead(news);
            mUnreadNewsList = newsListManage.getUnreadNewsList();
        }
    }


}
