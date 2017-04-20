package com.cqxiaokang.bug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BugActivity extends AppCompatActivity implements View.OnClickListener {

    TextView fix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bug_activity_bug);
        fix = (TextView) findViewById(R.id.tv_bug_fix);
        Button go = (Button) findViewById(R.id.btn_bug_go);
        fix.setOnClickListener(this);
        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_bug_fix) {
            String s = null;
            s.length();
//            fix.setText("问题已经被修复了");
//            Snackbar.make(findViewById(R.id.tv_bug_fix), "问题已经被修复了!", Snackbar.LENGTH_SHORT)
//                    .setAction("Undo", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            // Perform anything for the action selected
//                        }
//                    })
//                    .setDuration(2000).show();
        } else if (view.getId() == R.id.btn_bug_go) {
            Intent intent = new Intent();
            intent.setClassName(getBaseContext(), "com.cqxiaokang.remote.RemoteActivity");
            startActivity(intent);
        }
    }
}
