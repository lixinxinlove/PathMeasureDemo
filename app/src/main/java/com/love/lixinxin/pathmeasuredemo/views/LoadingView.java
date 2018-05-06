package com.love.lixinxin.pathmeasuredemo.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class LoadingView extends View implements View.OnClickListener {

    private int angle=1;
    private int x = 0;
    private int  y = 0;
    private int centerX = 250;
    private int centerY = 250;
    private int radius = 200;

    private Paint mPaint;
    private Paint mPaintPoint;

    private  ValueAnimator valueAnimator;
    public LoadingView(Context context) {
        super(context);
        init();
    }


    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(centerX, centerY, radius, mPaint);
        canvas.drawCircle(x, y,20, mPaintPoint);
        //canvas.drawPoint(x, y,mPaintPoint);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        mPaintPoint = new Paint();
        mPaintPoint.setAntiAlias(true);
        mPaintPoint.setColor(Color.RED);
        mPaintPoint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintPoint.setStrokeWidth(15);

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        valueAnimator = ValueAnimator.ofInt(0, 360);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setInterpolator(new LinearInterpolator());
        //valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // x =centerX +  radius * cos(angle * 3.14 / 180)
                //  y = centerY +radius * sin(angle *3.14 /180);
                angle = (int) animation.getAnimatedValue();
                x = (int) (centerX + radius * Math.cos(angle * Math.PI / 180));
                y = (int) (centerY + radius * Math.sin(angle * Math.PI / 180));
                invalidate();
                Log.e("valueAnimator",x+"--"+y);
            }
        });
        valueAnimator.start();

    }
}
