package com.example.nguyenphuc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    public static ArrayList<News> lstNews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
//        final ImageButton iBtnHome = (ImageButton) findViewById(R.id.menuHome);
//        iBtnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ServiceActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton iBtnBooking = (ImageButton) findViewById(R.id.menuBooking);
//        iBtnBooking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ServiceActivity.this, BookingActivity.class);
//                startActivity(intent);
//            }
//        });
        ListView list = (ListView) findViewById(R.id.listview2);
        if (lstNews.isEmpty()) {
            lstNews.add(new News("Tàu cao tốc chất lượng cao SE5", "Công ty Cổ phần vận tải đường sắt Hà Nội đã chính thức đưa đoàn tàu khách mới, chất lượng cao mác hiệu SE5/SE6 trên tuyến Hà Nội - Sài Gòn vào hoạt động. " +
                    "Đoàn tàu mới này có giá vé không đổi so với tàu hỏa thường ngày. " +
                    "Theo lịch trình, tàu SE5 xuất phát tại ga Hà Nội lúc 9h và đến ga Sài Gòn lúc 20h30 ngày hôm sau. " +
                    "Tàu SE6 xuất phát tại ga Sài Gòn lúc 9h và đến ga Hà Nội lúc 20h30 ngày hôm sau.\n"));
            lstNews.add(new News("Tàu cao tốc chất lượng cao SE3", "Mới đây Tổng công ty ĐSVN đưa vào sử dụng Đoàn tàu SE3/4 chất lượng cao trên tuyến ĐS Thống nhất. " +
                    "Toa ghế ngồi đạt tiêu chuẩn châu Âu. " +
                    "Toa giường nằm có nội thất sang trọng. " +
                    "Hành lang trên các toa giường nằm được trang bị ánh sáng và tranh ảnh giới thiệu các địa danh du lịch nổi tiếng của đất nước. " +
                    "Bồn rửa tay sạch sẽ. Hệ thống cửa cảm ứng tự động, đảm bảo an toàn cho hành khách khi di chuyển giữa các toa.\n"));
            lstNews.add(new News("Tàu cao tốc chất lượng cao Gia Lâm - Đồng Đăng", "Tàu chất lượng cao Gia Lâm - Đồng Đăng chính thức hoạt động từ tháng 6/2015. " +
                    "Ghế ngồi trên tàu được đóng mới hiện đại, có tay cầm. " +
                    "Tại khu vực ghế ngồi có thêm bàn, giỏ hoa treo phía trên. " +
                    "Nền tàu luôn sạch bong trước khi hành khách lên tàu. " +
                    "Trên tàu trang bị máy lạnh và ti vi phục hành khách giải trí. " +
                    "Khu bồn rửa tay luôn sạch bóng, có xà phòng thơm dành cho hành khách rửa tay. " +
                    "Trên tàu có quầy bar phục vụ nhu cầu ăn nhẹ cho hành khách.\n"));
        }

        NewsAdapter adapter = new NewsAdapter(this, R.layout.item_news, lstNews);
        list.setAdapter(adapter);
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
                Intent intent = new Intent(ServiceActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menuBooking:
                Intent intent1 = new Intent(ServiceActivity.this, BookingActivity.class);
                startActivity(intent1);
                break;
            case R.id.menuService:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
