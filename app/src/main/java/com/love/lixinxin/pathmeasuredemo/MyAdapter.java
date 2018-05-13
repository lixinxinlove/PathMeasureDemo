package com.love.lixinxin.pathmeasuredemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public MyAdapter(@Nullable List<String> data) {
        super(R.layout.item_del_muen, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.content,item);
        helper.addOnClickListener(R.id.btn_edit);
    }
}
