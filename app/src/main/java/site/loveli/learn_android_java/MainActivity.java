package site.loveli.learn_android_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.xml.transform.Result;

import static site.loveli.learn_android_java.R.id.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hello", "onCreate");
        Button btn = findViewById(btn_next);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                finish();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", "Hello SecondActivity");
//                startActivity(intent);
                startActivityForResult(intent,1);
//                Intent intent = new Intent("site.loveli.learn_android_java.ACTION_START");
//                intent.addCategory("site.loveli.learn_android_java.MY_CATEGORY");
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case add_item:
                Toast.makeText(this, "你点击 Add", Toast.LENGTH_SHORT).show();
                break;
            case remove_item:
                Toast.makeText(this, "你点击删除", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String reData = data.getStringExtra("data_return");
                Log.d("MainActivity", reData);
            }
        }
    }
}