package com.zchu.recyclerview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Chu on 2017/2/11.
 */

public class WaySpinnerAdapter extends BaseAdapter {

    private Context mContext;
    private String[] strings;
    private int seletedPosition=-1;

    public WaySpinnerAdapter(Context context, String[] strings) {
        mContext = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public String getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(mContext);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dp2px(mContext, 40)));
            textView.setPadding(DensityUtil.dp2px(mContext, 8), 0, DensityUtil.dp2px(mContext, 40), 0);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setTextSize(14);

        } else {
            textView = (TextView) convertView;
        }
        textView.setText(getItem(position));
        if(seletedPosition>=0&&position==seletedPosition){
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.colorPrimary));
        }else{
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.textSecondary));
        }

        return textView;
    }

    public void setSeletedPosition(int position){
        seletedPosition=position;

    }
}
