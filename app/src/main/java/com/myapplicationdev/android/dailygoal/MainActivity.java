package com.myapplicationdev.android.dailygoal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int radio1;
    int radio2;
    int radio3;
    String reflect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id. buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup1);
                TextView tvContent = (TextView)findViewById(R.id. textViewContent1);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                radio1 = selectedButtonId;
                RadioButton rb = (RadioButton)findViewById(selectedButtonId);

                RadioGroup rg1 = (RadioGroup)findViewById(R.id.radioGroup2);
                TextView tvContent1 = (TextView)findViewById(R.id. textViewContent2);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                radio2 = selectedButtonId1;
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId1);

                RadioGroup rg2 = (RadioGroup)findViewById(R.id.radioGroup3);
                TextView tvContent2 = (TextView)findViewById(R.id. textViewContent3);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                radio3 = selectedButtonId2;
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);

                EditText etReflect = (EditText)findViewById(R.id. editTextReflect);
                reflect = etReflect.getText().toString();

                String[] info = {tvContent.getText().toString(), rb.getText().toString(),
                                tvContent1.getText().toString(), rb1.getText().toString(),
                                tvContent2.getText().toString(), rb2.getText().toString(),
                        etReflect.getText().toString()};
                Intent i = new Intent(MainActivity.this, Summary.class);
                i.putExtra("info",info);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("p","p");
        //Step1b: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step1c: Obtain an instance of the Shared Preference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step1d: Add the key-value pair
        prefEdit.putInt("radio1", radio1);
        prefEdit.putInt("radio2", radio2);
        prefEdit.putInt("radio3", radio3);
        prefEdit.putString("reflection", reflect);
        //Step1e: Call commit() method to save the changes into the Shared Preference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("p","hjkp");

        //Step1b: Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step1d: Add the key-value pair
        String strStart = prefs.getString("start", "Welcome");

        Toast toast = Toast.makeText(getApplicationContext(),strStart, Toast.LENGTH_LONG);
        toast.show();
    }
}
