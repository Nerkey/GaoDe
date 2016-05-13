package com.example.qu.gaode;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * 描述:Activity基础类
 */
public class BaseActivity extends ActionBarActivity {

    public RelativeLayout rl_nav;
    public ImageButton ib_back;//返回键
    public Button btn_title;// 标题
    public Button ib_right;
    public FrameLayout fl_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_base);
        getSupportActionBar().hide();
        initView();
    }

    private void initView() {
        rl_nav = (RelativeLayout) findViewById(R.id.rl_nav);
        // 初始化顶端ACTIONBAR中的左右两侧按钮
        ib_back = (ImageButton) findViewById(R.id.ib_back);
        btn_title = (Button) findViewById(R.id.btn_title);
        ib_right = (Button) findViewById(R.id.ib_right);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);

        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
