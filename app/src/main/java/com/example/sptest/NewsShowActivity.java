package com.example.sptest;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sptest.dto.SPInteractive;

public class NewsShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String newsContent = SPInteractive.getNewsContent(this);

        TextView spContentText = findViewById(R.id.ac2_spcontent_text);
        spContentText.setText(newsContent);

        buttonClick();
    }

    private void buttonClick() {
        Button backToListButton = findViewById(R.id.back_button);
        backToListButton.setOnClickListener(v -> {
            finish();
        });
    }
}