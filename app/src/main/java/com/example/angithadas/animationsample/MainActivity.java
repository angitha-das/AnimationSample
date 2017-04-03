package com.example.angithadas.animationsample;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{

    TextView txtMessage;
    ImageView imageView;
    Button btnStart;
    Button btnClick;
    Animation animFadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnClick = (Button) findViewById(R.id.btnClick);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                txtMessage.startAnimation(animFadein);
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.GONE);
                Animation animation = new TranslateAnimation(0,0,0,-5000);
                animation.setDuration(3000);
                animation.setFillAfter(true);
                imageView.startAnimation(animation);
            }
        });

    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Started",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(getApplicationContext(), "Animation Repeated",
                Toast.LENGTH_SHORT).show();
    }
}
