package com.xingui.keer.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * =============================================
 * 作者： Lizh on 2017/8/14.
 * 描述：
 * ============================================
 */
public class BeaierThree extends View  implements View.OnClickListener {
    private Path mPath;
    private Paint mFillCirclePaint;
    /**
     * View的宽度
     **/
    private int width;
    /**
     * View的高度，这里View应该是正方形，所以宽高是一样的
     **/
    private int height;
    /**
     * View的中心坐标x
     **/
    private int centerX;
    /**
     * View的中心坐标y
     **/
    private int centerY;
    private float maxLength;
    /**
     * 平移动化时间（值总在0-1之间）
     */
    private float mInterpolatedTime;
    /**
     * 拉伸长度
     */
    private float stretchDistance;
    /**
     * 圆球半径
     */
    private float radius;
    private float c;
    private float blackMagic = 0.551915024494f;
    private VPoint p2, p4;
    private HPoint p1, p3;

    public BeaierThree(Context context) {
        this(context,null);
    }

    public BeaierThree(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public BeaierThree(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mFillCirclePaint = new Paint();
        mFillCirclePaint.setColor(0xFFfe626d);
        mFillCirclePaint.setStyle(Paint.Style.FILL);
        mFillCirclePaint.setStrokeWidth(1);
        mFillCirclePaint.setAntiAlias(true);
        mPath = new Path();
        p2 = new VPoint();
        p4 = new VPoint();
        p1 = new HPoint();
        p3 = new HPoint();
    }
    /**
     * 初始化圆的各个点
     */
    private void initCirclePoint() {
        p1.setY(radius);
        p3.setY(-radius);
        p3.x = p1.x = 0;
        p3.left.x = p1.left.x = -c;
        p3.right.x = p1.right.x = c;
        p2.setX(radius);
        p4.setX(-radius);
        p2.y = p4.y = 0;
        p2.top.y = p4.top.y = -c;
        p2.bottom.y = p4.bottom.y = c;
        setOnClickListener(this);
    }
    /**
     * 绘图
     */
    private void drawCircle(float interpolatedTime) {
        if (mInterpolatedTime >= 0 && mInterpolatedTime <= 0.2) {
            drawCircleStatus_1(interpolatedTime);
        } else if (mInterpolatedTime > 0.2 && mInterpolatedTime <= 0.5) {
            drawCircleStatus_2(interpolatedTime);
        } else if (mInterpolatedTime > 0.5 && mInterpolatedTime <= 0.8) {
            drawCircleStatus_3(interpolatedTime);
        } else if (mInterpolatedTime > 0.8 && mInterpolatedTime <= 0.9) {
            drawCircleStatus_4(interpolatedTime);
        } else if (mInterpolatedTime > 0.9 && mInterpolatedTime <= 1) {
            drawCircleStatus_5(interpolatedTime);
        }
    }

    /**
     * 状态1
     *
     * @param interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
     */
    private void drawCircleStatus_1(float interpolatedTime) {//0~0.2
        initCirclePoint();
        p2.adjustAllX(stretchDistance * interpolatedTime * 5);
    }
    /**
     * 状态2
     *
     * @param interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
     */
    private void drawCircleStatus_2(float interpolatedTime) {//0.2~0.5
        drawCircleStatus_1(0.20f);
        p4.adjustAllX(-stretchDistance * (interpolatedTime - 0.2f) * (10f / 3));
    }
    /**
     * 状态3
     *
     * @param interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
     */
    private void drawCircleStatus_3(float interpolatedTime) {//0.5~0.8
        drawCircleStatus_2(0.5f);
        p2.adjustAllX(-stretchDistance * (interpolatedTime - 0.5f) * (10f / 3));
    }
    /**
     * 状态4
     *
     * @param interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
     */
    private void drawCircleStatus_4(float interpolatedTime) {//0.8~0.9
        drawCircleStatus_3(0.8f);
        p4.adjustAllX(stretchDistance * (interpolatedTime - 0.8f) * 10);
    }
    /**
     * 状态5
     *
     * @param interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
     */
    private void drawCircleStatus_5(float interpolatedTime) {
        drawCircleStatus_4(0.9f);
        interpolatedTime = interpolatedTime - 0.9f;
        p4.adjustAllX((float) (Math.sin(Math.PI * interpolatedTime * 10f) * (2 / 10f * radius)));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        canvas.translate(2 * radius, radius);
        drawCircle(mInterpolatedTime);
        // 平移
        float offset = maxLength * (mInterpolatedTime - 0.2f);
        offset = offset > 0 ? offset : 0;
        p1.adjustAllX(offset);
        p2.adjustAllX(offset);
        p3.adjustAllX(offset);
        p4.adjustAllX(offset);
        // 圆球效果
        mPath.moveTo(p1.x, p1.y);
        mPath.cubicTo(p1.right.x, p1.right.y, p2.bottom.x, p2.bottom.y, p2.x, p2.y);
        mPath.cubicTo(p2.top.x, p2.top.y, p3.right.x, p3.right.y, p3.x, p3.y);
        mPath.cubicTo(p3.left.x, p3.left.y, p4.top.x, p4.top.y, p4.x, p4.y);
        mPath.cubicTo(p4.bottom.x, p4.bottom.y, p1.left.x, p1.left.y, p1.x, p1.y);
        canvas.drawPath(mPath, mFillCirclePaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        centerX = width / 2;
        centerY = height / 2;
        radius = 100;
        c = radius * blackMagic;
        stretchDistance = radius;
        maxLength = width - radius - radius;
    }

    class VPoint {
        public float x;
        public float y;
        public PointF top = new PointF();
        public PointF bottom = new PointF();
        public void setX(float x) {
            this.x = x;
            top.x = x;
            bottom.x = x;
        }
        public void adjustY(float offset) {
            top.y -= offset;
            bottom.y += offset;
        }
        public void adjustAllX(float offset) {
            this.x += offset;
            top.x += offset;
            bottom.x += offset;
        }
    }
    class HPoint {
        public float x;
        public float y;
        public PointF left = new PointF();
        public PointF right = new PointF();
        public void setY(float y) {
            this.y = y;
            left.y = y;
            right.y = y;
        }
        public void adjustAllX(float offset) {
            this.x += offset;
            left.x += offset;
            right.x += offset;
        }
    }

    @Override
    public void onClick(View v) {
        startAnimation();
    }
    /**
     * 重写动画
     */
    private class MoveAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            // interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
            mInterpolatedTime = interpolatedTime;
            invalidate();
        }
    }
    public void startAnimation() {
        mPath.reset();
        mInterpolatedTime = 0;
        MoveAnimation move = new MoveAnimation();
        move.setDuration(3000);
        move.setInterpolator(new AccelerateDecelerateInterpolator());
        startAnimation(move);
    }
}
