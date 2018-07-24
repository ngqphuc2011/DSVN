package com.example.nguyenphuc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailBookingActivity extends AppCompatActivity {
    TextView mMaVe, mHoTen, mSoDT, mGaDi, mGaDen, mNgayDi, mNgayDen, mNguoi, mTreEm, mLoaiVe;

    private void mFindViewbyId() {
        mMaVe = (TextView) findViewById(R.id.ctMaVe);
        mHoTen = (TextView) findViewById(R.id.ctHoTen);
        mSoDT = (TextView) findViewById(R.id.ctSoDT);
        mGaDi = (TextView) findViewById(R.id.ctGaDi);
        mGaDen = (TextView) findViewById(R.id.ctGaDen);
        mNgayDi = (TextView) findViewById(R.id.ctNgayDi);
        mNgayDen = (TextView) findViewById(R.id.ctNgayDen);
        mLoaiVe = (TextView) findViewById(R.id.ctLoaiVe);
        mNguoi = (TextView) findViewById(R.id.ctNguoi);
        mTreEm = (TextView) findViewById(R.id.ctTreEm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);

        mFindViewbyId();
        Intent intent = getIntent();
        Bundle getData = intent.getBundleExtra("MyTicket");

        mMaVe.setText(getData.getString("maVe"));
        mHoTen.setText(getData.getString("hoTen"));
        mSoDT.setText(getData.getString("soDT"));
        mGaDi.setText(getData.getString("gaDi"));
        mGaDen.setText(getData.getString("gaDen"));
        mNgayDi.setText(getData.getString("ngayDi"));
        mNgayDen.setText(getData.getString("ngayDen"));
        mLoaiVe.setText(getData.getString("loaiVe"));
        mNguoi.setText(getData.getString("nguoi"));
        mTreEm.setText(getData.getString("treEm"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.empty_menu, menu);
        setTitle("Đặt vé Online");
        return super.onCreateOptionsMenu(menu);
    }
}
