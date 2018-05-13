package com.love.lixinxin.pathmeasuredemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.love.lixinxin.pathmeasuredemo.MyAdapter;
import com.love.lixinxin.pathmeasuredemo.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeDelMenuActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemChildClickListener {


    private RecyclerView mRecyclerView;

    private MyAdapter mAdapter;

    private List<String> mData;

    // private SparseArray<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_del_menu);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        mAdapter.setOnItemChildClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add(i + "" + "---" + i);
        }
        mAdapter = new MyAdapter(mData);
    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.btn_edit:
                Toast.makeText(this,"编辑",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;


        }
    }
}
