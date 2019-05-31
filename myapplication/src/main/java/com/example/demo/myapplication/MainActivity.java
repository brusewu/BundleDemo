package com.example.demo.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i =getIntent();
        Bundle data=i.getExtras();
        getData(data);

        i.putExtra("Result","SUCCESS");
        setResult(RESULT_OK,i);
        finish();
    }

    public void getData(final Bundle bundle){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,  bundle.getString("Name")+bundle.getString("Age")+"", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
