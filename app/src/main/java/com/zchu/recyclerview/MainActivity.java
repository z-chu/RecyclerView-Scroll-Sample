package com.zchu.recyclerview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Button btnGo;
    private MaterialEditText etIndex;
    private Toolbar toolbar;
    private Spinner spinner1;

    private int spinnerSelectedIndex;


    private BaseQuickAdapter<String, BaseViewHolder> adapter;
    private LinearLayoutManager layoutManager;
    private String[] ways;
    private WaySpinnerAdapter waySpinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnGo = (Button) findViewById(R.id.btn_go);
        etIndex = (MaterialEditText) findViewById(R.id.et_index);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerLinerItemDecoration(this,LinearLayoutManager.VERTICAL,ContextCompat.getDrawable(this,R.drawable.divider)));
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("第" + i + "项");
        }
        adapter = getAdapter(strings);
        recyclerView.setAdapter(adapter);
        ways = getResources().getStringArray(R.array.ways);
        waySpinnerAdapter = new WaySpinnerAdapter(this, ways);
        spinner1.setAdapter(waySpinnerAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                TextView tv = (TextView) view;
                Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_triangle);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tv.setCompoundDrawables(null, null, drawable, null);
                tv.setTextColor(Color.WHITE);    //设置颜色
                tv.setPadding(0, 0, 0, 0);
                tv.setCompoundDrawablePadding(DensityUtil.dp2px(MainActivity.this,8));//设置图片和text之间的间距
                tv.setTextSize(16.0f);    //设置大小
                TextPaint paint = tv.getPaint();
                paint.setFakeBoldText(true);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);   //设置居中
                spinnerSelectedIndex = pos;
                etIndex.setHint(ways[pos]);
                etIndex.setFloatingLabelText(ways[pos]);
                waySpinnerAdapter.setSeletedPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        btnGo.setOnClickListener(this);

    }

    @NonNull
    private BaseQuickAdapter<String, BaseViewHolder> getAdapter(final ArrayList<String> strings) {
        return new BaseQuickAdapter<String, BaseViewHolder>(R.layout.list_item, strings) {

            @Override
            protected void convert(BaseViewHolder helper, String item) {
                if (index >= 0 && helper.getLayoutPosition() == index) {
                    helper.setTextColor(R.id.tv_index, ContextCompat.getColor(mContext, R.color.colorAccent));
                } else {
                    helper.setTextColor(R.id.tv_index, ContextCompat.getColor(mContext, R.color.textPrimary));
                }
                helper.setText(R.id.tv_index, item);

            }

        };
    }


    private int index = -1;

    @Override
    public void onClick(View v) {
        String text = etIndex.getText().toString();
        try {
            index = Integer.parseInt(text);
        } catch (Exception e) {
            return;
        }
        if (text.length() > 0) {
            switch (spinnerSelectedIndex) {
                case 0:
                    recyclerView.scrollBy(0, index);
                    index = -1;
                    adapter.notifyDataSetChanged();
                    break;
                case 1:
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(index);
                    break;
                case 2:
                    adapter.notifyDataSetChanged();
                    recyclerView.smoothScrollToPosition(index);
                    break;
                case 3:
                    adapter.notifyDataSetChanged();
                    ((LinearLayoutManager)recyclerView.getLayoutManager()).scrollToPositionWithOffset(index,0);
                    break;
            }


        }
    }
}
