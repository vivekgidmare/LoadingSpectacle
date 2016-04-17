package com.loadingspectacle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout loadingGif;
    private ImageView leftFrame, rightFrame;
    Animation clock_animation, anti_clock_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.white_loading_screen);
        setUpLoadingGIF();


    }

    private void startLoadingAnimation() {
        leftFrame.clearAnimation();
        rightFrame.clearAnimation();
        leftFrame.startAnimation(anti_clock_animation);
        rightFrame.startAnimation(clock_animation);
        loadingGif.setVisibility(View.VISIBLE);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                stopLoadingAnimation();
//            }
//        }, 10000);

    }

    private void stopLoadingAnimation() {
        leftFrame.clearAnimation();
        rightFrame.clearAnimation();
        loadingGif.setVisibility(View.GONE);

    }

    private void setUpLoadingGIF() {
        loadingGif = (RelativeLayout) findViewById(R.id.gif_main_container);
        leftFrame = (ImageView) loadingGif.findViewById(R.id.leftFrame);
        rightFrame = (ImageView) loadingGif.findViewById(R.id.rightFrame);
        anti_clock_animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_anti_clockwise);
        clock_animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_clockwise);

        anti_clock_animation.setInterpolator(new CustomInterpolator());
        clock_animation.setInterpolator(new CustomInterpolator());

        clock_animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                try {
                    synchronized (animation) {
                        animation.wait(400);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        anti_clock_animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                try {
                    synchronized (animation) {
                        animation.wait(400);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        startLoadingAnimation();
    }
}
