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
import com.example.sptest.adapters.UnreadNewsAdapter;
import com.example.sptest.component.NewsListManage;
import com.example.sptest.dto.SPInteractive;
import com.example.sptest.entity.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Seaguller
 * @date 2021/9/27 10:47
 * @Description
 */
public class UnreadNewsFragment extends Fragment {

    private List<News> unreadNewsList = new ArrayList<>();
    private UnreadNewsAdapter adapter = null;
    private RecyclerView recyclerView = null;

    private NewsListManage newsListManage = NewsListManage.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unread_news_fragment, null);

        recyclerView = view.findViewById(R.id.unread_news_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        /* 初始化分隔线、添加分隔线 */
        DividerItemDecoration mDivider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mDivider.setDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.spilit_divider, null));
        recyclerView.addItemDecoration(mDivider);

        adapter = new UnreadNewsAdapter();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView.setAdapter(adapter);
    }

}
