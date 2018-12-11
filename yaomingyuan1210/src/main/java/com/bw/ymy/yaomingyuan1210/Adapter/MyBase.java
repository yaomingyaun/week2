package com.bw.ymy.yaomingyuan1210.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.ymy.yaomingyuan1210.Bean.UserBean;
import com.bw.ymy.yaomingyuan1210.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyBase extends BaseAdapter {
    private List<UserBean.DataBean> mdata;
    private Context context;

    public MyBase(Context context) {
        this.mdata = new ArrayList<>();
        this.context = context;
    }

    public void setlist(List<UserBean.DataBean> mdata) {
        this.mdata = mdata;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public UserBean.DataBean getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.text11);
            holder.icon = convertView.findViewById(R.id.icon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(mdata.get(position).getTitle());
        ImageLoader.getInstance().displayImage(getItem(position).getIcon(), holder.icon);
        //ImageLoader.getInstance().displayImage(getItem(position).getThumbnail_pic_s02(),holder.icon2);
        //  ImageLoader.getInstance().displayImage(getItem(position).getThumbnail_pic_s03(),holder.icon3);
        return convertView;
    }

    class ViewHolder {
        TextView title;
        ImageView icon;
    }
}
