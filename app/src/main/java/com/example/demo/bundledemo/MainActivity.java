package com.example.demo.bundledemo;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
            }
        });
    }

    public void data(){
        Bundle bundle = new Bundle();
        bundle.putString("Name", "Test");
        bundle.putString("Age", "12");
        String packageName = "com.example.demo.myapplication";
        String className = "com.example.demo.myapplication.MainActivity";
        ComponentName componetName = new ComponentName(packageName, className);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setAction("android.intent.action.VIEW");
        intent.setComponent(componetName);
        startActivityForResult(intent,1);

        Log.d("App", " result: " + intent.getStringExtra("Result"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
            case RESULT_OK:
                Bundle b=data.getExtras(); //data为B中回传的Intent
                final String str=b.getString("Result");//str即为回传的值
                Log.d("App", "print result: " + str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,  str+"", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }
    }

}
