package com.example.sptest.utils;

import android.widget.ImageView;

/**
 * @author Seaguller
 * @date 2021/9/26 15:16
 * @Description
 */
public class ImageChangeUtil {

    /**
     * 改变Image模块图片
     * @param imageView 图片模块
     * @param newImageIndex 新图片索引
     */
    public static void imageChange(ImageView imageView, int newImageIndex) {
        imageView.setImageResource(newImageIndex);
    }
}
