package com.example.lostandfoundapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createAdvertButton = findViewById(R.id.btn_create_advert);
        createAdvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAdvertActivity.class);
                startActivity(intent);
            }
        });

        Button showAllItemsButton = findViewById(R.id.btn_show_all_items);
        showAllItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowAllItemsActivity.class);
                startActivity(intent);
            }
        });
    }
}
