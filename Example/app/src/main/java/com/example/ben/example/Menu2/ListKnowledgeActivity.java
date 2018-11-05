package com.example.ben.example.Menu2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.example.MainActivity;
import com.example.ben.example.Menu1.Explain3Activity;
import com.example.ben.example.R;

public class ListKnowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_knowledge);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getKnowledgeValue();

    }

    private void getKnowledgeValue(){

        Log.d("getValue" ,"2");

        Intent intent = getIntent();

        String b_name = getIntent().getStringExtra("b1");
        String b_vol1 = getIntent().getStringExtra("B_low_volum");
        String b_vol2 = getIntent().getStringExtra("B_normal_volum");
        String b_vol3 = getIntent().getStringExtra("B_high_volum");
        String b_unit = getIntent().getStringExtra("B_unit");
        String b_data = getIntent().getStringExtra("B_data");
        String b_data_info = getIntent().getStringExtra("B_data_information");
        String b_data_info2 = getIntent().getStringExtra("B_data_information2");

        Log.d("b_name",b_name);
        setKnowledgeValue(b_name,b_unit,b_vol1,b_vol2,b_vol3,b_unit,b_data,b_data_info,b_data_info2);


    }

    private void setKnowledgeValue(String b_name, String b_unit,
                                   String b_vol1, String b_vol2, String b_vol3,
                                   String bUnit, String b_data, String b_data_info,
                                   String b_data_info2){

        Log.d("setValue" ,"2");

        TextView t_name = (TextView)findViewById(R.id.b_name2);
        t_name.setText(b_name);

        TextView t_vol1 = (TextView)findViewById(R.id.blood_vol_1);
        t_vol1.setText(b_vol1);

        TextView t_vol2 = (TextView)findViewById(R.id.blood_vol_2);
        t_vol2.setText(b_vol2);

        TextView t_vol3 = (TextView)findViewById(R.id.blood_vol_3);
        t_vol3.setText(b_vol3);

        TextView t_unit = (TextView)findViewById(R.id.b_unit_m);
        t_unit.setText(bUnit);

        TextView t_data = (TextView)findViewById(R.id.blood_data_1);
        t_data.setText(b_data);

        TextView t_data2 = (TextView)findViewById(R.id.blood_data_2);
        t_data2.setText(b_data_info);

        TextView t_data3 = (TextView)findViewById(R.id.blood_data_3);
        t_data3.setText(b_data_info2);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.backtohome, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.tab_menu) {
            Toast.makeText(ListKnowledgeActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            Intent i = new Intent(ListKnowledgeActivity.this, MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
