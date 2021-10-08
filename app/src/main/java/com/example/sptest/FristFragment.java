package com.example.sptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sptest.adapters.NewsAdapter;
import com.example.sptest.dto.SPInteractive;
import com.example.sptest.entity.News;
import com.example.sptest.utils.RandomDataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seaguller
 * @date 2021/9/27 10:47
 * @Description
 */
public class FristFragment extends Fragment {

    private List<News> newsList = new ArrayList<>();
    private NewsAdapter adapter = null;
    private RecyclerView recyclerView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);

        newsList = RandomDataUtil.newsRandomGenerate(100);

        recyclerView = view.findViewById(R.id.news_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        /* 初始化分隔线、添加分隔线 */
        DividerItemDecoration mDivider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.spilit_divider, null));
        recyclerView.addItemDecoration(mDivider);

        adapter = new NewsAdapter(newsList);

        return view;
    }
}
