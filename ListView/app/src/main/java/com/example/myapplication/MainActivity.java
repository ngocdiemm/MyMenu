package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String dishList[] = {"Món mặn", "Món canh", "Món xào"};
    int images[] = {R.drawable.monman, R.drawable.moncanh, R.drawable.monxao};

    String dishListItems[][] = {
            {"Cá chiên", "Thịt rang sa ot", "Tôm chiên xù", "Gà xối mỡ"},
            {"Canh cải bẹ xanh", "Canh bí đỏ", "Canh rong biển"},
            {"Rau muống xào tỏi", "Bắp cải xào trứng", "Ớt chuông xào mực"},
    };
    String dishListItemPrice[][] = {
            {"22.000", "24.000", "20.000", "22.000"},
            {"10.000", "15.000", "12.000"},
            {"20.000", "25.000", "22.000"},
    };
    int imagesItems[][] = {
            {R.drawable.cachien, R.drawable.canhkhoaimo, R.drawable.thitrangsaot, R.drawable.tomchienxu},
            {R.drawable.canhcaibexanh, R.drawable.canhbido, R.drawable.canhrongbien},
            {R.drawable.bapcaixaotrung, R.drawable.otchuongxaomuc, R.drawable.raumuongxaotoi},
    };

    ListView listView;
    TextView textView;
    ImageView btnBack;
    LinearLayout left;
    boolean canListenClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        textView = findViewById(R.id.headerText);
        left = findViewById(R.id.left);
        btnBack = findViewById(R.id.backBtn);
        List list = new List(getApplicationContext(), dishList, images, dishListItems);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canListenClick == false) {
                    listView.setAdapter(list);
                    textView.setText("Ăn cơm trưa hoy");
                    canListenClick = true;
                    handleListXml();
                }
            }
        });
        listView.setAdapter(list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(canListenClick) {
                    Item itemCustom = new Item(getApplicationContext(), dishListItems[position], imagesItems[position], dishListItemPrice[position]);
                    listView.setAdapter(itemCustom);
                    textView.setText(dishList[position]);
                    canListenClick = false;
                    handleItemXml();
                }
            }
        });
    }
    protected void handleItemXml() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) left.getLayoutParams();
        params.weight = 2;
        left.setLayoutParams(params);
    }
    protected void handleListXml() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) left.getLayoutParams();
        params.weight = 1;
        left.setLayoutParams(params);
    }
}