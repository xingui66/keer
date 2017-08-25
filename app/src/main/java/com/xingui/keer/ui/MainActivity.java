package com.xingui.keer.ui;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.xingui.keer.R;
import com.xingui.keer.bean.LoginBean;
import com.xingui.keer.component.DaggerLoginComponet;
import com.xingui.keer.component.LoginComponet;
import com.xingui.keer.module.LoginModule;
import com.xingui.keer.presenter.LoginPresenter;
import com.xingui.keer.ui.activity.DynamicDetailActivity;
import com.xingui.keer.ui.adapter.HomeAdapter;
import com.xingui.keer.view.KeerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements KeerView.LoginView ,View.OnFocusChangeListener, TextWatcher {

    @Inject
    public LoginPresenter loginPresenter;

    private Button login;
    private RecyclerView recyclerview;
    private FloatingActionButton fab_main;
    private List<String> mDatas = new ArrayList<String>();
    //private HomeAdapter mAdapter;

    //**+
    private ImageView img1;
    private EditText edit1, edit2;
    // 显示
    private AnimatedVectorDrawable anim1, anim2, anim3;
    //**-

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//半透明工具栏
        setContentView(R.layout.activity_main);
        //1.登录功能+
        //loginPresenter=new LoginPresenter(this);
        LoginComponet loginComponet =DaggerLoginComponet.builder()
                                                           .loginModule(new LoginModule(this))
                                                           .build();
        loginComponet.inject(this);

        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击登录
                loginPresenter.login("18514596125","123456");
            }
        });
        //1.登录功能-

        //时间轴+
        recyclerview=(RecyclerView)findViewById(R.id.grid_recycler);
        for (int i = 'A'; i < 'H'; i++){
            if(i%3==0){
                if(i%2==0){
                    mDatas.add("今天是个好日子" + (char) i);
                }else{
                    mDatas.add("eabsghsgbsgbsgbsgbsgbsgbg" + (char) i);
                }
            }else{
                mDatas.add("" + (char) i);
            }

        }
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.COLUMN);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        recyclerview.setNestedScrollingEnabled(false);
        /*layoutManager.setAlignContent(AlignContent.STRETCH);*/
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(new HomeAdapter(this,mDatas));
        //时间轴-

        //页面跳转+
        fab_main=(FloatingActionButton) findViewById(R.id.fab_main);
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicDetailActivity.start(MainActivity.this);
            }
        });
        //页面跳转-

        //**svg+
        img1 = ((ImageView) findViewById(R.id.img1));
        edit1 = ((EditText) findViewById(R.id.edit1));
        edit2 = ((EditText) findViewById(R.id.edit2));

        // 加载SVG
        anim1 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim1);
        anim2 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim2);
        anim3 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim3);

        // 设置焦点变化的监听
        edit1.setOnFocusChangeListener(this);
        edit2.setOnFocusChangeListener(this);

        // 文本变化的监听
        edit1.addTextChangedListener(this);
        //**svg-
    }

    @Override
    public void netError() {
        Toast.makeText(getApplication(),"登录失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void shouLoginSuccess(LoginBean loginBean) {
        if (loginBean.isSuccess()) {
            Toast.makeText(getApplication(),"登录成功",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplication(),"登录失败",Toast.LENGTH_LONG).show();
        }
    }

    //**svg+
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        // 内容变化之后，判断内容
        if (!TextUtils.isEmpty(s) && edit1.getText().toString().trim().equals("1234")) {
            Toast.makeText(this, "right", Toast.LENGTH_SHORT).show();
            img1.setImageDrawable(anim2);
            anim2.start();
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.edit1:
                if (hasFocus) {
                    img1.setImageDrawable(anim1);
                    anim1.start();
                }
                break;
            case R.id.edit2:
                if (hasFocus) {
                    img1.setImageDrawable(anim3);
                    anim3.start();
                }
                break;
        }
    }
    //**svg-
}
