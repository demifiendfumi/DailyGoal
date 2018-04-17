package com.myapplicationdev.android.dailygoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv1 = (TextView)findViewById(R.id. textView1);

        tv1.setText(info[0] + ": " + info[1] + "\n"
                    + info[2] + ": " + info[3] + "\n"
                    + info[4] + ": " + info[5] + "\n"
                    + "Reflection: " + info[6]);

        Button homeBtn = (Button)findViewById(R.id. buttonHome);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
