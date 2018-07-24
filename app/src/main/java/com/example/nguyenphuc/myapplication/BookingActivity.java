package com.example.nguyenphuc.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ResourceCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mHoVaTen, mSoDienThoai, mNgayDen, mNgayDi, mNguoi, mTreEm;
    Button mDatVe;
    RadioButton mRadMotChieu, mRadKhuHoi;
    Spinner mGaDi, mGaDen;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        mNgayDi = (EditText) findViewById(R.id.txtNgayDi);
        mNgayDen = (EditText) findViewById(R.id.txtNgayDen);

        mHoVaTen = (EditText) findViewById(R.id.txtHoVaTen);
        mSoDienThoai = (EditText) findViewById(R.id.txtSoDienThoai);
        mGaDi = (Spinner) findViewById(R.id.spinnerGaDi);
        mGaDen = (Spinner) findViewById(R.id.spinnerGaDen);
        mRadMotChieu = (RadioButton) findViewById(R.id.radMotChieu);
        mRadKhuHoi = (RadioButton) findViewById(R.id.radKhuHoi);
        mNguoi = (EditText) findViewById(R.id.txtNguoi);
        mTreEm = (EditText) findViewById(R.id.txtTreEm);
        mDatVe = (Button) findViewById(R.id.btnDatVe);
        mDatVe.setOnClickListener(this);

        loadSavedPreferences();

//        final ImageButton iBtnService = (ImageButton) findViewById(R.id.menuService);
//        iBtnService.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(BookingActivity.this, ServiceActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton iBtnHome = (ImageButton) findViewById(R.id.menuHome);
//        iBtnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(BookingActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        setTitle("Đặt vé Online");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuHome:
                Intent intent = new Intent(BookingActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menuBooking:

                break;
            case R.id.menuService:
                Intent intent1 = new Intent(BookingActivity.this, ServiceActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue = sharedPreferences.getBoolean("sp_radmotchieu", false);

        String hoVaTen = sharedPreferences.getString("sp_hoVaTen", "");
        String soDienThoai = sharedPreferences.getString("sp_soDienThoai", "");
        int gaDi = sharedPreferences.getInt("sp_gaDi", 0);
        int gaDen = sharedPreferences.getInt("sp_gaDen", 0);
        String ngayDi = sharedPreferences.getString("sp_ngayDi", "");
        String ngayDen = sharedPreferences.getString("sp_ngayDen", "");
        String nguoi = sharedPreferences.getString("sp_nguoi", "");
        String treEm = sharedPreferences.getString("sp_treEm", "");

        if (checkBoxValue) {
            mRadMotChieu.setChecked(true);
            mRadKhuHoi.setChecked(false);
        } else {
            mRadMotChieu.setChecked(false);
            mRadKhuHoi.setChecked(true);
        }

        mHoVaTen.setText(hoVaTen);
        mSoDienThoai.setText(soDienThoai);
        mNgayDi.setText(ngayDi);
        mNgayDen.setText(ngayDen);
        mNguoi.setText(nguoi);
        mTreEm.setText(treEm);
        mGaDi.setSelection(gaDi);
        mGaDen.setSelection(gaDen);

    }

    private void savePreferences(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    @Override
    public void onClick(View view) {
        savePreferences("sp_hoVaTen", mHoVaTen.getText().toString());
        savePreferences("sp_soDienThoai", mSoDienThoai.getText().toString());
        savePreferences("sp_ngayDi", mNgayDi.getText().toString());
        savePreferences("sp_ngayDen", mNgayDen.getText().toString());
        savePreferences("sp_nguoi", mNguoi.getText().toString());
        savePreferences("sp_treEm", mTreEm.getText().toString());
        savePreferences("sp_radmotchieu", mRadMotChieu.isChecked());
        savePreferences("sp_gaDi", mGaDi.getSelectedItemPosition());
        savePreferences("sp_gaDen", mGaDen.getSelectedItemPosition());

        Toast.makeText(this, "Booked!", Toast.LENGTH_SHORT).show();

        Ticket ticket = new Ticket("DSVN0000", mNgayDi.getText().toString(), mGaDi.getSelectedItem().toString(), mGaDen.getSelectedItem().toString(), mHoVaTen.getText().toString(), mSoDienThoai.getText().toString(), mNgayDen.getText().toString(), mNguoi.getText().toString(), mTreEm.getText().toString(), mRadKhuHoi.isChecked());
        TicketBookingActivity.lstTicket.add(ticket);

        Intent intent = new Intent(BookingActivity.this, TicketBookingActivity.class);
        startActivity(intent);
    }

    public void openPickerNgayDi(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mNgayDi.setText(i2 + "/" + (i1 + 1) + "/" + i);
            }
        };

        DatePickerDialog dialog = new DatePickerDialog(this, dateSetListener, 2018, 7, 24);
        dialog.show();
    }

    public void openPickerNgayDen(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mNgayDen.setText(i2 + "/" + (i1 + 1) + "/" + i);
            }
        };

        DatePickerDialog dialog = new DatePickerDialog(this, dateSetListener, 2018, 7, 25);
        dialog.show();
    }

}
