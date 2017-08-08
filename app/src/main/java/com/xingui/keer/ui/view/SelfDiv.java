package com.xingui.keer.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * =============================================
 * 作者： Lizh on 2017/7/19.
 * 描述：
 * ============================================
 */
public class SelfDiv extends LinearLayout {
    public SelfDiv(Context context) {
        this(context,null);
    }

    public SelfDiv(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public SelfDiv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // 请求父控件及祖宗控件不要拦截当前控件的时间
        this.requestDisallowInterceptTouchEvent(true);

        /*final int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                this.getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                this.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }*/
        Log.e("自己div：","dispatch");
        return super.dispatchTouchEvent(event);

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("自己div：","Intercept");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("自己div：","Touch");
        /*switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                this.requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                this.requestDisallowInterceptTouchEvent(false);
                break;
        }*/
        return true;
    }
}
