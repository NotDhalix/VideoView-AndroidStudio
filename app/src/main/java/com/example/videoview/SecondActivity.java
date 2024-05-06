package com.example.videoview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private VideoView vv2;
    private ScrollView scrollView;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        vv2 = findViewById(R.id.vv2);
        btn2 = findViewById(R.id.btn2);
        scrollView = findViewById(R.id.scrollView);

        scrollView.post(() -> scrollView.scrollTo(0, 0));
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.educacionverde);
        vv2.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vv2);
        vv2.setMediaController(mediaController);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}