package com.example.sptest.dto;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.sptest.component.NewsListManage;
import com.example.sptest.constant.NewsConstant;
import com.example.sptest.entity.News;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Seaguller
 * @date 2021/9/26 14:51
 * @Description
 */
public class SPInteractive {

    private static final String NEWS_GROUP_KEY = "data";

    /**
     * 创建SP对象并返回
     * @param context 活动上下文
     * @param groupKey SP对象储存的组Key
     * @return SP对象实例
     */
    private static SharedPreferences.Editor getSPObject(Context context, String groupKey) {
        /* 创建一个SP对象 */
        SharedPreferences sharedPreferences = context.getSharedPreferences(groupKey, Context.MODE_PRIVATE);
        /* 实例化SP对象 */
        SharedPreferences.Editor editor = sharedPreferences.edit();

        return editor;
    }

    /**
     * 存储数据
     * @param context 活动上下文
     * @param key 存储数据的key
     * @param value 存储数据的value
     */
    private static <T> void saveData(Context context, String key, T value) {

        SharedPreferences.Editor editor = getSPObject(context, NEWS_GROUP_KEY);

        /* 将获取的值植入文件 */
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set<String>) value);
        }

        /* 提交 */
        editor.commit();
    }

    /**
     * 新闻内容存储
     * @param context 活动上下文
     * @param value 新闻内容
     */
    public static void saveNewsContent(Context context, String value) {
        saveData(context, NewsConstant.NEWS_CONTENT_KEY, value);
    }

    /**
     * 基础内容获取
     * @param context 活动上下文
     * @param groupKey 组Key
     * @param contentKey 要获取的内容Key
     * @param defaultValue 无内容时默认显示的值
     * @return 获取的内容
     */
    private static <T> T getContent(Context context, String groupKey, String contentKey, T defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(groupKey, Context.MODE_PRIVATE);

        if (defaultValue instanceof String) {
            return (T) sharedPreferences.getString(contentKey, (String) defaultValue);
        } else if (defaultValue instanceof Set) {
            return (T) sharedPreferences.getStringSet(contentKey, (Set<String>) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return (T) (Integer) sharedPreferences.getInt(contentKey, (Integer) defaultValue);
        }

        return null;
    }

    /**
     * 新闻内容获取
     * @param context 活动上下文
     * @return 获取的新闻内容
     */
    public static String getNewsContent(Context context) {
        return getContent(context, NEWS_GROUP_KEY, NewsConstant.NEWS_CONTENT_KEY, NewsConstant.NEWS_CONTENT_VALUE_DEFAULT);
    }

    /**
     * 保存字符串到指定字符串集合中
     * @param context 活动上下文
     * @param data 要保存到集合中的字符串
     * @param groupKey 组Key
     * @param contentKey 存储器中字符串集合的Key
     * @param defaultValue 未取出时的默认值
     */
    private static void saveStringToSet(Context context, String data, String groupKey, String contentKey, Set<String> defaultValue) {
        SharedPreferences.Editor editor = getSPObject(context, groupKey);

        Set<String> strList = getContent(context, groupKey, contentKey, defaultValue);
        if (strList == defaultValue) {
            strList = new HashSet<>();
        }
        strList.add(data);

        editor.putStringSet(contentKey, strList);
    }

    /**
     * 保存已读新闻列表
     * @param context 活动上下文
     */
    public static void saveHaveReadNewsList(Context context) {
        SharedPreferences.Editor editor = getSPObject(context, NEWS_GROUP_KEY);

        NewsListManage newsListManage = NewsListManage.getInstance();
        List<News> haveNewsList = newsListManage.getHavereadNewsList();

        Set<String> strList = new HashSet<>();
        for (News news : haveNewsList) {
            strList.add(news.getNewsId());
        }

        editor.putStringSet(NewsConstant.READ_NEWS_LIST_KEY, strList);

        editor.commit();
    }

    /**
     * 将特定新闻保存进已读新闻列表
     * @param context 活动上下文
     * @param news 想要保存的新闻
     */
    public static void saveHaveReadNews(Context context, News news) {
        saveStringToSet(context, news.getNewsId(), NEWS_GROUP_KEY, NewsConstant.READ_NEWS_LIST_KEY, new HashSet<>());
    }

    /**
     * 取出已读新闻列表并清空SP
     * @param context 活动上下文
     * @return 返回已读新闻集合
     */
    public static Set<String> getHaveReadNews(Context context) {
        Set<String> readNewsSet = getContent(context, NEWS_GROUP_KEY, NewsConstant.READ_NEWS_LIST_KEY, new HashSet<>());
        clearHaveReadNews(context);

        return readNewsSet;
    }

    /**
     * 清除SP
     * @param context 活动上下文
     */
    public static void clearHaveReadNews(Context context) {
        SharedPreferences.Editor editor = getSPObject(context, NEWS_GROUP_KEY);

        editor.clear();
    }
}
