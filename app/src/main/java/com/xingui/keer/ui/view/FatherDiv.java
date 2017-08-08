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
public class FatherDiv extends LinearLayout {
    public FatherDiv(Context context) {
        this(context,null);
    }

    public FatherDiv(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public FatherDiv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("父亲div：","dispatch");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("父亲div：","Intercept");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("父亲div：","Touch");
        return true;
    }
}
