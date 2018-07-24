package com.example.nguyenphuc.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    Context mContext;
    int mLayoutItem;
    ArrayList<News> mList;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<News> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayoutItem = resource;
        this.mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutItem, null);
        }
        News n = mList.get(position);
        TextView itemTitle = (TextView) row.findViewById(R.id.newsTitle);
        TextView itemBody = (TextView) row.findViewById(R.id.newsBody);

        itemTitle.setText(n.getTitle());
        itemBody.setText(n.getBody());

        return row;
    }
}
