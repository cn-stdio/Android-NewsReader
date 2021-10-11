package com.example.sptest.component;

import com.example.sptest.R;
import com.example.sptest.entity.News;
import com.example.sptest.utils.RandomDataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seaguller
 * @date 2021/10/11 10:05
 * @Description
 */
public class NewsListManage {

    private List<News> newsList = new ArrayList<>();

    private List<News> unreadNewsList = new ArrayList<>();

    private List<News> haveReadNewsList = new ArrayList<>();

    private NewsListManage() {}

    private static class NewsListManageHolder {
        private static final NewsListManage newsListManageInstance = new NewsListManage();
    }

    /**
     * 获得唯一实例
     * @return 唯一实例
     */
    public static NewsListManage getInstance() {
        return NewsListManageHolder.newsListManageInstance;
    }

    public void init() {
        newsList = RandomDataUtil.newsRandomGenerate(100);

        /* 浅拷贝 */
        unreadNewsList.addAll(newsList);
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public List<News> getUnreadNewsList() {
        return unreadNewsList;
    }

    public List<News> getHavereadNewsList() {
        return haveReadNewsList;
    }

    public void newsBecomesRead(News news) {
        unreadNewsList.remove(news);

        news.setRead(true);
        news.setImageId(R.drawable.have_read);

        haveReadNewsList.add(news);
    }

}
