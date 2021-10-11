package com.example.sptest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    /* 导航栏全局变量 */
    private int[] unSelectTabRes = new int[]{
            R.drawable.unread_normal,
            R.drawable.have_read_normal,
            R.drawable.allread_normal};
    private int[] selectTabRes = new int[]{
            R.drawable.unread_press,
            R.drawable.have_read_press,
            R.drawable.allread_press};

    private String[] title = {"未读", "已读", "全部"};
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private void initView() {
        viewPager = findViewById(R.id.viewpager_content_view);
        tabLayout = findViewById(R.id.tab_layout_view);

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < title.length; i++) {
            if (i == 0) {
                tabLayout.getTabAt(0).setIcon(selectTabRes[0]);
            } else {
                tabLayout.getTabAt(i).setIcon(unSelectTabRes[i]);
            }
        }
    }

    private void initData(){}

    private void initListener() {
        /* 图片选中监听 */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < title.length; i++) {
                    if (tab == tabLayout.getTabAt(i)) {
                        tabLayout.getTabAt(i).setIcon(selectTabRes[i]);
                        viewPager.setCurrentItem(i);
                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                for (int i = 0; i < title.length; i++) {
                    if (tab == tabLayout.getTabAt(i)) {
                        tabLayout.getTabAt(i).setIcon(unSelectTabRes[i]);
                    }
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    /* 自定义适配器 */
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {

            //TODO ViewPager打开第 1 个fragment时会打开第 2 个 fragment，尝试只在其可见时加载（懒加载）
            if (position == 1) {
                return new SecondFragment();
            } else if (position == 2) {
                return new ThirdFragment();
            }

            return new FristFragment();
        }
        @Override
        public int getCount() {
            return title.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* 导航栏初始化 */
        initView();
        initData();
        initListener();

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove_item:
                Iterator<News> it = newsList.iterator();

                *//* 遍历新闻列表，将“已读”新闻移除 *//*
                while (it.hasNext()) {
                    News tempNews = it.next();
                    if (tempNews.isRead()) {
                        it.remove();
                    }
                }

                *//* 重新设置Adapter加载布局 *//*
                NewsAdapter adapter = new NewsAdapter(newsList);
                recyclerView.setAdapter(adapter);

                break;

            default:
        }

        return true;
    }*/
}