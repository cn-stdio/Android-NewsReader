package com.example.sptest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sptest.constant.NewsConstant;
import com.example.sptest.dto.SPInteractive;

public class NewsShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String newsContent = intent.getStringExtra(NewsConstant.NEWS_CONTENT_KEY);

        TextView contentText = findViewById(R.id.ac2_spcontent_text);
        contentText.setText(newsContent);

        buttonClick();
    }

    private void buttonClick() {
        Button backToListButton = findViewById(R.id.back_button);
        backToListButton.setOnClickListener(v -> {
            finish();
        });
    }
}