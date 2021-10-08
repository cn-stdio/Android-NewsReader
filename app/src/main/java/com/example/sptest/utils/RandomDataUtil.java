package com.example.sptest.utils;

import com.example.sptest.R;
import com.example.sptest.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seaguller
 * @date 2021/9/26 10:29
 * @Description
 */
public class RandomDataUtil {

    /**
     * 生成指定数量的随机新闻
     * @param count 新闻列表大小
     * @return 新闻列表
     */
    public static List<News> newsRandomGenerate(int count) {

        List<News> newsList = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            News news = new News();

            news.setTitle("第 " + (i+1) + " 个新闻标题");

            String newsContent = "";
            for (int j = 0; j < 50; j++) {
                newsContent += (i+1);
            }

            news.setContent(newsContent);
            news.setImageId(R.drawable.star);

            newsList.add(news);

        }

        return newsList;
    }
}
