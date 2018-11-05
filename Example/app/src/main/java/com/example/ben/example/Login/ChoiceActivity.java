package com.example.ben.example.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ben.example.MainActivity;
import com.example.ben.example.Menu1.ResultActivity;
import com.example.ben.example.R;

public class ChoiceActivity extends AppCompatActivity {

    private Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        button = (Button)findViewById(R.id.Button_signin);
        button2 = (Button)findViewById(R.id.Button_register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ChoiceActivity.this, LoginActivity.class);
                startActivity(i);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChoiceActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}
