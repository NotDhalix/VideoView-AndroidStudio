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

public class MainActivity extends AppCompatActivity {
    private VideoView vv1;
    private ScrollView scrollView;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        vv1 = findViewById(R.id.vv1);

        scrollView = findViewById(R.id.scrollView);
        scrollView.post(() -> scrollView.scrollTo(0, 0));

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videocontaminacion);

        vv1.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vv1);
        vv1.setMediaController(mediaController);

       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, SecondActivity.class);
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