package com.loadingspectacle;

import android.view.animation.Interpolator;

/**
 * Created by vivek on 13/07/15.
 */
public class CustomInterpolator implements Interpolator {

//    y=cos((t+1)π)/2+0.5

    public CustomInterpolator() {
    }

    @Override
    public float getInterpolation(float t) {
//        float x=2.0f*input-1.0f;
//        return 0.5f*(x*x*x + 1.0f);
        float x = t * 2.0f;
        if (t < 0.5f) return 0.5f * x * x * x * x * x;
        x = (t - 0.5f) * 2 - 1;
        return 0.5f * x * x * x * x * x + 1;
//        return 0;
    }
}
