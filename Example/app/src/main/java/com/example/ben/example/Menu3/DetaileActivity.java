package com.example.ben.example.Menu3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.example.Data.Blood;
import com.example.ben.example.Data.BloodProfile;
import com.example.ben.example.Data.MenuThreeChoice;
import com.example.ben.example.MainActivity;
import com.example.ben.example.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class DetaileActivity extends AppCompatActivity {


    private ArrayList<BloodProfile> list2 = new ArrayList<>();
    private RecyclerView recyclerView;
    HistoryView adapter;
    private Toolbar toolbar;
    private DatabaseReference databaseReference;
    private SeekBar seekBar;
    private ProgressBar progressBar;
    private ProgressDialog progress_loading;
    private TextView textunit,textViewlevel,textViewvalue,av;
    ArrayList<String> listvalue  = new ArrayList<>();
    float average ,average2 = 0;
    int count = 0 ;
    Integer[] progress1,secondary,progress2,seekbarMax;
    String[] unit,name;
    MenuThreeChoice menuThreeChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaile);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.RE5);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        seekBar = (SeekBar)findViewById(R.id.seekBar_blood);
        progressBar = (ProgressBar)findViewById(R.id.progressBar_blood);
        textunit = (TextView)findViewById(R.id.unit);
        textViewlevel = (TextView)findViewById(R.id.d_level);
        textViewvalue = (TextView)findViewById(R.id.blood_value);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        checkInternet();

        int num = getIntent().getIntExtra("num",0);

        if(num == 0){

            getGlucose(num);
        }
        else if(num == 1){
            getGlucose(num);
        }
        else if(num == 2){
            getGlucose(num);
        }
        else if(num == 3){
            getGlucose(num);
        }
        else if(num == 4){
            getGlucose(num);
        }
        else if(num == 5){
            getGlucose(num);
        }
        else if(num == 6){
            getGlucose(num);
        }


    }

    public void getGlucose(final int num){

        String[] g = {"Glucose","Sodium","Potassium","Cholesterol","LDL","HDL","Triglyceride"};

        getProgressValue(num);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User/Profile/List/put/Blood/list/"+g[num]);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                list2 = new ArrayList<BloodProfile>();

                if(dataSnapshot.exists()) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        BloodProfile bp = dataSnapshot1.getValue(BloodProfile.class);

                            list2.add(bp);


                        String value = dataSnapshot1.child("value").getValue(String.class);
                        listvalue.addAll(Collections.singleton(value));

                        Log.d("listvalue", String.valueOf(listvalue));
                    }

                    getAveragelist(listvalue, num);

                    adapter = new HistoryView(list2, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }

                hideProgressDialog();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(), "There was a problem with the network", Toast.LENGTH_SHORT).show();
                showProgressDialog();


            }
        });

    }

    public void getProgressValue(int num){

        Blood b = new Blood();
        progress1 = b.getSeekbar();
        secondary = b.getSecondarybar();
        progress2 = b.getProgressbar();
        seekbarMax = b.getSeekbarMax();
        unit = b.getUnitBlood();
        name = b.getName();


        av = (TextView)findViewById(R.id.d_average);
        av.setText("Average of "+name[num]);
        textunit.setText(unit[num]);

        seekBar.setMax(seekbarMax[num]);
        seekBar.setEnabled(false);
        progressBar.setProgress(progress1[num]);
        progressBar.setSecondaryProgress(secondary[num]);
        progressBar.setMax(seekbarMax[num]);
    }

    public void getAveragelist(ArrayList<String> listvalue,int num){


        ArrayList<Float> list2 = new ArrayList<>();

        for (String myInt : listvalue)
        {
            list2.add(Float.valueOf(myInt));
        }


        for(int i = 0;i<list2.size();i++) {

            if (list2.get(i) == 0) {

                average += list2.get(i);
                count++;

                count = count - 1 ;
                average2 = average/count;
            }

            else{
                average += list2.get(i);
                count++;

                average2 = average/count;
            }


        }

        menuThreeChoice = new MenuThreeChoice(num,(int) average2);

        textViewvalue.setText(String.valueOf((int)Math.round(average2)));
        seekBar.setProgress((int) average2);

        menuThreeChoice.setNum(num);
        menuThreeChoice.setBloodValue((int) average2);
        Log.d("round", String.valueOf(num)+" "+(int) average2);
        textViewlevel.setText(menuThreeChoice.getBloodLevel());


    }

    private void showProgressDialog() {
        if (progress_loading == null) {
            progress_loading = new ProgressDialog(DetaileActivity.this);
            progress_loading.setMessage("Please check your internet connection");
            progress_loading.setIndeterminate(true);
        }
        progress_loading.show();
    }

    private void hideProgressDialog() {
        if (progress_loading != null && progress_loading.isShowing()) {
            progress_loading.dismiss();
        }
    }

    public void checkInternet(){

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            hideProgressDialog();
        }
        else {
            connected = false;
            showProgressDialog();
        }
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
            Toast.makeText(DetaileActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            Intent i = new Intent(DetaileActivity.this, MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
