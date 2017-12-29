package com.example.t420.applocksreen;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentTwo.Remove{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("Save",MODE_PRIVATE);

    }
    boolean  check;
    @Override
    public void remove() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new FragmentOne())
                .commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        check=sharedPreferences.getBoolean("key",false);
        if(check==true){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, new FragmentTwo())
                    .commit();
        }else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, new FragmentOne())
                    .commit();
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, new FragmentTwo())
                            .commit();
                }
            },3000);
        }
    }
}
