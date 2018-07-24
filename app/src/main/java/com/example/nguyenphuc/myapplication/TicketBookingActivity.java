package com.example.nguyenphuc.myapplication;

import android.content.Intent;
import android.service.autofill.FillEventHistory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TicketBookingActivity extends AppCompatActivity {

    static ArrayList<Ticket> lstTicket = new ArrayList<>();
    static TextView mHoTen, mSoDT, mGaDi, mGaDen, mNgayDi, mNgayDen, mLoaiVe, mNguoi, mTreEm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking);


//        final ImageButton iBtnService = (ImageButton) findViewById(R.id.menuService);
//        iBtnService.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TicketBookingActivity.this, ServiceActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton iBtnHome = (ImageButton) findViewById(R.id.menuHome);
//        iBtnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TicketBookingActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

        ListView list = (ListView) findViewById(R.id.listview);
//        lstTicket.add(new Ticket("DSVN0000", "31/12/2018", "Hanoi", "New York"));
//        lstTicket.add(new Ticket("DSVN0001", "30/12/2018", "TPHCM", "New York"));
//        lstTicket.add(new Ticket("DSVN0002", "19/12/2018", "Paris", "New York"));
//        lstTicket.add(new Ticket("DSVN0003", "29/12/2018", "Hanoi", "Bangkok"));
//        lstTicket.add(new Ticket("DSVN0004", "20/12/2018", "Hanoi", "Jakarta"));

        TicketAdapter adapter = new TicketAdapter(this, R.layout.item_ticket, lstTicket);
        list.setAdapter(adapter);

        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Ticket obj = lstTicket.get(info.position);
        String title = "Lựa chọn cho " + obj.getMaVe();
        menu.setHeaderTitle(title);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Ticket obj = lstTicket.get(info.position);
        switch (id) {
            case R.id.menuAdd:
                Intent intent = new Intent(TicketBookingActivity.this, BookingActivity.class);
                startActivity(intent);
                break;
            case R.id.menuDelete:
                lstTicket.remove(obj);
                Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(TicketBookingActivity.this, TicketBookingActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.menuDetail:
                Intent intent2 = new Intent(TicketBookingActivity.this, DetailBookingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("maVe", obj.getMaVe());
                bundle.putString("hoTen", obj.getHoTen());
                bundle.putString("soDT", obj.getsDT());
                bundle.putString("gaDi", obj.getGaDi());
                bundle.putString("gaDen", obj.getGaDen());
                bundle.putString("ngayDi", obj.getNgayDi());
                bundle.putString("ngayDen", obj.getNgayDen());
                bundle.putString("nguoi", obj.getNguoi());
                bundle.putString("treEm", obj.getTreEm());
                if (obj.isKhuHoi()) {
                    bundle.putString("loaiVe", "Khứ hồi");
                } else bundle.putString("loaiVe", "Một chiều");

                intent2.putExtra("MyTicket", bundle);
                startActivity(intent2);
                break;
        }

        return super.onContextItemSelected(item);
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
                Intent intent = new Intent(TicketBookingActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menuBooking:
                Intent intent1 = new Intent(TicketBookingActivity.this, BookingActivity.class);
                startActivity(intent1);
                break;
            case R.id.menuService:
                Intent intent2 = new Intent(TicketBookingActivity.this, ServiceActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
