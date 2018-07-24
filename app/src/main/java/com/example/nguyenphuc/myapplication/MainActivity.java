package com.example.nguyenphuc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final ImageButton iBtnService = (ImageButton) findViewById(R.id.menuService);
//
//        iBtnService.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton iBtnBooking = (ImageButton) findViewById(R.id.menuBooking);
//
//        iBtnBooking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
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
                break;
            case R.id.menuBooking:
                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
                startActivity(intent);
                break;
            case R.id.menuService:
                Intent intent1 = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
