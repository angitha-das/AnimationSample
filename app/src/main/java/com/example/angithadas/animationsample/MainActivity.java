package com.example.angithadas.animationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{

    TextView txtMessage;
    TextView wave;
    ImageView imageView;
    Button btnStart;
    Button btnClick;
    Button button;
    Animation animFadein;
    Animation animation2;
    TranslateAnimation animation1;
    TranslateAnimation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        wave = (TextView) findViewById(R.id.text);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnClick = (Button) findViewById(R.id.btnClick);
        button = (Button) findViewById(R.id.btn);


        animation = new TranslateAnimation(0,0,0,-500);
        animation.setDuration(2000);
        wave.setVisibility(View.VISIBLE);
        animation.setAnimationListener(this);

        animation1 = new TranslateAnimation(0,0,-500,0);
        animation1.setDuration(2000);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        animFadein.setAnimationListener(this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setVisibility(View.VISIBLE);
                wave.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);
                txtMessage.startAnimation(animFadein);
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.GONE);
                wave.setVisibility(View.GONE);
                animation2 = new TranslateAnimation(0,0,0,-5000);
                animation2.setDuration(3000);
                animation2.setFillAfter(true);
                imageView.startAnimation(animation2);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wave.startAnimation(animation);
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
        else if(animation == animation){
            wave.startAnimation(animation1);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(getApplicationContext(), "Animation Repeated",
                Toast.LENGTH_SHORT).show();
    }
}
