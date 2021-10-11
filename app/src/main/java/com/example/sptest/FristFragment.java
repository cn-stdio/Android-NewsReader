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
import com.example.sptest.adapters.UnreadNewsAdapter;
import com.example.sptest.component.NewsListManage;
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

    private List<News> unreadNewsList = new ArrayList<>();
    private UnreadNewsAdapter adapter = null;
    private RecyclerView recyclerView = null;

    private NewsListManage newsListManage = NewsListManage.getInstance();

    /**
     * 碎片与活动建立关联，调用一次，负责进入活动的初始化
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        newsListManage.init();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("MyLog", "0：onCreate");

        View view = inflater.inflate(R.layout.fragment_first, null);

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
        Log.d("MyLog", "0：onStart");
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MyLog", "0：onDestroyView");
    }

}
