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
public class ReadNewsFragment extends Fragment {

    private List<News> readNewsList = new ArrayList<>();

    private View globalView;

    private RecyclerView globalRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyLog", "1：onCreate");

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

        ReadNewsAdapter adapter = new ReadNewsAdapter();
        globalRecyclerView.setAdapter(adapter);

        Log.d("MyLog", "1：onStart");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyLog", "1：onDestroyView");
    }
}
