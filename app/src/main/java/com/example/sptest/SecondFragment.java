package com.example.sptest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sptest.adapters.ReadNewsAdapter;
import com.example.sptest.dto.SPInteractive;
import com.example.sptest.entity.News;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Seaguller
 * @date 2021/9/27 10:50
 * @Description
 */
public class SecondFragment  extends Fragment {

    private List<News> readNewsList = new ArrayList<>();

    private View globalView;

    private RecyclerView globalRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, null);
        globalView = view;

        SPInteractive.clearHaveReadNews(view.getContext());

        RecyclerView recyclerView = view.findViewById(R.id.read_news_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        /* 初始化分隔线、添加分隔线 */
        DividerItemDecoration mDivider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.spilit_divider, null));
        recyclerView.addItemDecoration(mDivider);

        globalRecyclerView = recyclerView;

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        String[] readNewsStrs = SPInteractive.getHaveReadNews(globalView.getContext());
        if (!"".equals(readNewsStrs[0]) && !"".equals(readNewsStrs[1])) {
            News news = new News(readNewsStrs[0], readNewsStrs[1], R.drawable.have_read);

            if (!readNewsList.contains(news)) {
                readNewsList.add(news);
            }

        }

        ReadNewsAdapter adapter = new ReadNewsAdapter(readNewsList);
        globalRecyclerView.setAdapter(adapter);
    }
}
