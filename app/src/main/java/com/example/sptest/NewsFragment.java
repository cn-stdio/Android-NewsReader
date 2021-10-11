package com.example.sptest;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sptest.adapters.NewsAdapter;
import com.example.sptest.component.NewsListManage;
import com.example.sptest.entity.News;
import com.example.sptest.utils.RandomDataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seaguller
 * @date 2021/10/8 14:14
 * @Description
 */
public class NewsFragment extends Fragment {

    private List<News> newsList = new ArrayList<>();
    private NewsAdapter adapter = null;
    private RecyclerView recyclerView = null;

    private NewsListManage newsListManage = NewsListManage.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyLog", "2：onCreate");

        newsList = newsListManage.getNewsList();

        View view = inflater.inflate(R.layout.fragment_third, null);

        recyclerView = view.findViewById(R.id.news_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        /* 初始化分隔线、添加分隔线 */
        DividerItemDecoration mDivider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.spilit_divider, null));
        recyclerView.addItemDecoration(mDivider);

        adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyLog", "2：onStart");
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyLog", "2：onDestroyView");
    }
}
