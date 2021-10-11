package com.example.sptest.entity;

import androidx.annotation.Nullable;

import java.util.UUID;

/**
 * @author Seaguller
 * @date 2021/9/24 16:28
 * @Description
 */
public class News {

    private String newsId;

    private String title;

    private String content;

    private int imageId;

    /**
     * 是否被阅读，默认为否
     */
    private boolean read = false;

    public News(String newsId, String title, int imageId) {
        this.newsId = newsId;

        this.title = title;
        this.imageId = imageId;
    }

    public News(String newsId, String title, String content, int imageId) {
        this.newsId = newsId;

        this.title = title;
        this.content = content;
        this.imageId = imageId;
    }

    public News(String newsId){
        this.newsId = newsId;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsId() {
        return newsId;
    }

    @Override
    public boolean equals(@Nullable Object obj) {

        News news = (News) obj;

        return (this.getTitle().equals(news.getTitle())) && (this.getContent().equals(news.getContent()));
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId='" + newsId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageId=" + imageId +
                ", read=" + read +
                '}';
    }
}
