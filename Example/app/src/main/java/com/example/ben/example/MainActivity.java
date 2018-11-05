package com.example.ben.example;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.ben.example.Menu1.BloodsFragment;
import com.example.ben.example.Menu2.KnowledgeFragment;
import com.example.ben.example.Menu3.ProfileBdFragment;
//import com.example.ben.example.Menu3.HistoryFragment;

public class MainActivity extends AppCompatActivity  {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new BloodsFragment();
                    break;
                case R.id.navigation_dashboard:
                    fragment = new KnowledgeFragment();

                    break;
                case R.id.navigation_notifications:
                    fragment = new ProfileBdFragment();
                    break;
            }
            return loadFragment(fragment);

        }
    };
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;

    }

    public boolean Dialog() {

        final Dialog dDialog = new Dialog(MainActivity.this);
        dDialog.setContentView(R.layout.dialogpopup2);
        dDialog.getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button button2 = (Button) dDialog.findViewById(R.id.yesbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent i=new Intent();
                i.putExtra("finish", true);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                //startActivity(i);
                finish();
            }
        });

        Button button3 = (Button) dDialog.findViewById(R.id.nobutton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dDialog.dismiss();

            }
        });

        dDialog.show();

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragment();

    }
    private void initFragment() {

        BloodsFragment fragment = new BloodsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment).commit();


    }

    @Override
    public void onBackPressed() {

        if(Dialog()) {
            moveTaskToBack(true);

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                }
            },2000);
        }
    }
}
