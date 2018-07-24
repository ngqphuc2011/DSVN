package com.example.nguyenphuc.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TicketAdapter extends ArrayAdapter<Ticket> {
    Context mContext;
    int mLayoutItem;
    ArrayList<Ticket> mList;

    public TicketAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ticket> objects) {
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
        Ticket t = mList.get(position);
        TextView itemMaVe = (TextView) row.findViewById(R.id.txtMaVe);
        TextView itemNgayDi = (TextView) row.findViewById(R.id.txtNgayDi2);
        TextView itemGaDi = (TextView) row.findViewById(R.id.txtGaDi);
        TextView itemGaDen = (TextView) row.findViewById(R.id.txtGaDen);

        itemMaVe.setText(t.getMaVe());
        itemNgayDi.setText(t.getNgayDi());
        itemGaDi.setText(t.getGaDi());
        itemGaDen.setText(t.getGaDen());

        return row;
    }
}
