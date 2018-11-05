package com.example.ben.example.Menu1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.example.MainActivity;
import com.example.ben.example.R;

public class Explain3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String T1 = getIntent().getStringExtra("T1");
        toolbar.setTitle(T1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Log.d("Oncreate" ,"Start");
        getValue();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getValue(){
        Log.d("getValue" ,"1");

        Intent intent = getIntent();

        String T1 = getIntent().getStringExtra("T1");
        String T3 = getIntent().getStringExtra("T3");
        String unit = getIntent().getStringExtra("T4");

        int seekbar1_blood = getIntent().getIntExtra("sk",0);
        int seekbar2_blood = getIntent().getIntExtra("sk2",0);

        int progressbar = getIntent().getIntExtra("pb",0);
        int progress_second  = getIntent().getIntExtra("pb2",0);
        int progress_third  = getIntent().getIntExtra("pb3",0);

        String info1 = getIntent().getStringExtra("info1");
        String info2 = getIntent().getStringExtra("info2");
        String info3 = getIntent().getStringExtra("info3");
        String info4 = getIntent().getStringExtra("info4");
        String info5 = getIntent().getStringExtra("info5");
        String info6 = getIntent().getStringExtra("info6");


        Log.d("seekbar", String.valueOf(seekbar1_blood+"\n"+seekbar2_blood));
        Log.d("progressbar",String.valueOf(progressbar+"\n"+progress_second+"\n"+progress_third));

        setValue(T1,T3,seekbar1_blood,seekbar2_blood,progressbar,progress_second,progress_third);

        setInformation(info1,info2,info3,info4,info5,info6,unit);
    }

    private void setValue(String T1,String TLevel,int seekBar1_blood,
                          int seekbar2_blood,int progressbar,int progress_third,int progress_second){

        Log.d("getValue" ,"2");


        TextView textView1 = (TextView)findViewById(R.id.blood_value);
        textView1.setText(TLevel);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar_blood);
        seekBar.setProgress(seekBar1_blood);
        seekBar.setEnabled(false);
        seekBar.setMax(seekbar2_blood);

        Log.d("seekbar2", "yes "+seekBar1_blood+"\n"+seekbar2_blood);


        ProgressBar progressBar2 =  (ProgressBar)findViewById(R.id.progressBar_blood);
        progressBar2.setProgress(progressbar);
        progressBar2.setSecondaryProgress(progress_third);
        progressBar2.setMax(progress_second);

        Log.d("progressbar2",String.valueOf(progressbar+"\n"+progress_third+"\n"+progress_second));

    }

    private void setInformation(String info1,String info2,String info3,String info4,String info5,String info6,String unit){

        TextView information1 = (TextView)findViewById(R.id.title1);
        information1.setText(info1);

        TextView information2 = (TextView)findViewById(R.id.title2);
        information2.setText(info2);

        TextView information3 = (TextView)findViewById(R.id.title3);
        information3.setText(info3);

        TextView information4 = (TextView)findViewById(R.id.title4);
        information4.setText(info4);

        TextView information5 = (TextView)findViewById(R.id.title5);
        information5.setText(info5);

        TextView information6 = (TextView)findViewById(R.id.title6);
        information6.setText(info6);

        TextView unit1 = (TextView)findViewById(R.id.unit);
        unit1.setText(unit);

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
            Toast.makeText(Explain3Activity.this, "Action clicked", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Explain3Activity.this, MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
