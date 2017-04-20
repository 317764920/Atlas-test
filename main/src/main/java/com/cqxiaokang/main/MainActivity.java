package com.cqxiaokang.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
//        TextView content = (TextView) findViewById(R.id.tv_main_content);
//        content.setText("我是首页的新内容\n(*^__^*) 嘻嘻……");
        Button button = (Button) findViewById(R.id.btn_main_go);
        button.setOnClickListener(this);
//        toast();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), "com.cqxiaokang.bug.BugActivity");
        startActivity(intent);
    }

//    private void toast() {
//        Toast.makeText(this, "新增了代码，提示一下", Toast.LENGTH_SHORT).show();
//    }
}
