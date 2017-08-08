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
public class GrandDiv extends LinearLayout {
    public GrandDiv(Context context) {
        this(context,null);
    }

    public GrandDiv(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public GrandDiv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("爷爷div：","dispatch");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("爷爷div：","intercept");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("爷爷div：","Touch");
        return super.onTouchEvent(event);
    }
}
