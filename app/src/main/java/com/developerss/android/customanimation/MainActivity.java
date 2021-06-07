package com.developerss.android.customanimation;

import android.app.ActivityOptions;
import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mListLayout;

    private ImageView mProfileImage;
    private TextView mNameText;
    private TextView mDescText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mListLayout = findViewById(R.id.layoutView);
        mProfileImage = findViewById(R.id.image);
        mNameText = findViewById(R.id.textView1);
        mDescText = findViewById(R.id.text2);

        mListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(mProfileImage, "imageTransition");
                pairs[1] = new Pair<View, String>(mNameText, "nameTransition");
                pairs[2] = new Pair<View, String>(mDescText, "descTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
//                        Pair.create(view1, "imageTransition"));

                startActivity(intent, options.toBundle());

            }
        });

    }
}
