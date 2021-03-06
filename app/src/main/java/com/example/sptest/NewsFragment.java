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
import com.example.sptest.adapters.NewsAdapter;
import com.example.sptest.component.NewsListManage;
import com.example.sptest.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seaguller
 * @date 2021/10/8 14:14
 * @Description
 */
public class NewsFragment extends Fragment {

    private NewsAdapter adapter = null;
    private RecyclerView recyclerView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, null);
        recyclerView = view.findViewById(R.id.news_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        /* 初始化分隔线、添加分隔线 */
        DividerItemDecoration mDivider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.spilit_divider, null));
        recyclerView.addItemDecoration(mDivider);

        adapter = new NewsAdapter();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView.setAdapter(adapter);
    }

}
