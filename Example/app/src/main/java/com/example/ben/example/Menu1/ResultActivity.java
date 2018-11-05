package com.example.ben.example.Menu1;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.example.ben.example.Data.B_information;
import com.example.ben.example.Data.Blood;
import com.example.ben.example.Data.BloodInformation;
import com.example.ben.example.MainActivity;
import com.example.ben.example.Menu2.KnowledgeAdapter;
import com.example.ben.example.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.security.AccessController.getContext;

public class ResultActivity extends AppCompatActivity {


    private List<BloodInformation> InList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Blooddapter mAdapter;
    private Toolbar toolbar;
    ArrayList<String> bloods,sym;
    ArrayList<Integer> value;
    BloodInformation bloodInformation;
    Integer[] p1,p2,p3,s2,image,ps1;
    String info1[],info2[],info3[],info4[],info5[],info6[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__list);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        mAdapter = new Blooddapter(InList,this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview2);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Intent intent = getIntent();
        bloods = intent.getStringArrayListExtra("blood");
        sym  = intent.getStringArrayListExtra("sym");
        value = intent.getIntegerArrayListExtra("bloodvalue");

        Data(bloods,sym,value);
    }


    private void Data(ArrayList<String> bloods,ArrayList<String> symton,ArrayList<Integer> value) {
        Log.d("Blood",bloods.get(0));
        Log.d("value","value1 "+value.get(0));
        Log.d("sym2", String.valueOf(symton));

        Blood b = new Blood();
        p1 = b.getSeekbar();
        ps1 = b.getSecondarybar();
        p2 = b.getProgressbar();
        p3 = b.getSeekbarMax();
        s2 = b.getProgressbarMax();

        image = b.getImage();
        info1 = b.getinfo1();
        info2 = b.getinfo2();
        info3 = b.getinfo3();
        info4 = b.getinfo4();
        info5 = b.getinfo5();
        info6 = b.getinfo6();


        BloodInformation  blood = new BloodInformation("Blood Glucose ",symton.get(0),bloods.get(0),"mg/dl",
                image[0],value.get(0),p1[0],p2[0],p3[0],s2[0],info1[0],info2[0],info3[0],info4[0],info5[0],info6[0]);
        InList.add(blood);

        blood = new BloodInformation("Blood Sodium ",symton.get(1),bloods.get(1),"mmol/L"
                ,image[1],value.get(1),p1[1],p2[1],p3[1],s2[1],info1[1],info2[1],info3[1],info4[1],info5[1],info6[1]);
        InList.add(blood);

        blood = new BloodInformation("Blood Potassium",symton.get(2),bloods.get(2),"mEq/L",
                image[2],value.get(2),p1[2],p2[2],p3[2],s2[2],info1[2],info2[2],info3[2],info4[2],info5[2],info6[2]);
        InList.add(blood);

        blood = new BloodInformation("Blood Cholesterol",symton.get(3),bloods.get(3),"mg/dl",
                image[3],value.get(3),p1[3],p2[3],p3[3],s2[3],info1[3],info2[3],info3[3],info4[3],info5[3],info6[3]);
        InList.add(blood);

        blood = new BloodInformation("Blood LDL ",symton.get(4),bloods.get(4),"mg/dl"
                ,image[4],value.get(4),p1[4],p2[4],p3[4],s2[4],info1[4],info2[4],info3[4],info4[4],info5[4],info6[4]);
        InList.add(blood);

        blood = new BloodInformation("Blood HDL",symton.get(5),bloods.get(5),"mg/dl",
                image[5],value.get(5),p1[5],p2[5],p3[5],s2[5],info1[5],info2[5],info3[5],info4[5],info5[5],info6[5]);
        InList.add(blood);

        blood = new BloodInformation("Blood Triglycerides",symton.get(6),bloods.get(6),"mg/dl",
                image[6],value.get(6),p1[6],p2[6],p3[6],s2[6],info1[6],info2[6],info3[6],info4[6],info5[6],info6[6]);
        InList.add(blood);

    }


    @Override
    public boolean onSupportNavigateUp() {
        Intent i = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(i);
        return true;
    }

    @Override
    public void onBackPressed() {

        Dialog();
    }

    public void Dialog() {

        final Dialog dDialog = new Dialog(ResultActivity.this);
        dDialog.setContentView(R.layout.dialogpopup2);
        dDialog.getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button button2 = (Button) dDialog.findViewById(R.id.yesbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                startActivity(i);
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
    }


}
