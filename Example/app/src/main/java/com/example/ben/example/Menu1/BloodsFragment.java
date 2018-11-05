package com.example.ben.example.Menu1;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.example.Data.BloodTest;
import com.example.ben.example.MainActivity;
import com.example.ben.example.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodsFragment extends Fragment {


    EditText e_sugar, e_sodium, e_potassium, e_choles, e_ldl, e_hdl, e_tri,dateBloods;
    TextView error, error2, error3, error4, error5, error6, error7;
    private int e_sugar2, e_sodium2, e_choles2, e_ldl2, e_hdl2, e_tri2;
    private double e_potassium2;
    private String sugar2, sodium2, potassium2, choles2, hdl2, ldl2, tri2,dateTime;;
    private String Levels, Levels1, Levels2, Levels3, Levels4, Levels5, Levels6;
    Button button;
    BloodTest bloodTest;
    private ArrayList<String> blood = new ArrayList<>();
    private ArrayList<String> sym = new ArrayList<>();
    private ArrayList<Integer> bloodvalue = new ArrayList<>();
    DatabaseReference database1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference databaseRef;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bloods, container, false);


        e_sugar = (EditText) v.findViewById(R.id.e_sugar);
        e_sodium = (EditText) v.findViewById(R.id.e_sodium);
        e_potassium = (EditText) v.findViewById(R.id.e_potass);
        e_choles = (EditText) v.findViewById(R.id.e_chol);
        e_ldl = (EditText) v.findViewById(R.id.e_ldl);
        e_hdl = (EditText) v.findViewById(R.id.e_hdl);
        e_tri = (EditText) v.findViewById(R.id.e_tri);
        dateBloods = (EditText) v.findViewById(R.id.e_date);
        button = (Button) v.findViewById(R.id.confirmb);

        error = (TextView) v.findViewById(R.id.error1);
        error2 = (TextView) v.findViewById(R.id.error2);
        error3 = (TextView) v.findViewById(R.id.error3);
        error4 = (TextView) v.findViewById(R.id.error4);
        error5 = (TextView) v.findViewById(R.id.error5);
        error6 = (TextView) v.findViewById(R.id.error6);
        error7 = (TextView) v.findViewById(R.id.error7);

        bloodTest = new BloodTest(dateTime,e_sugar2, e_sodium2, e_potassium2, e_choles2, e_ldl2, e_hdl2, e_tri2);

        dataBloods(v);
        Calendar();

        //write in storage

        return v;
    }

    public void dataBloods(View v) {

        final AlertDialog.Builder dDialog = new AlertDialog.Builder(getActivity());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ("".equals(e_sugar.getText().toString()) && "".equals(e_sodium.getText().toString())
                        && "".equals(e_potassium.getText().toString()) && "".equals(e_choles.getText().toString())
                        && "".equals(e_ldl.getText().toString()) && "".equals(e_hdl.getText().toString())
                        && "".equals(e_tri.getText().toString())) {

                    Log.d("Error", "4");
                    Dialog();
                }

               else if("".equals(dateBloods.getText().toString().trim())){
                    Dialog2();
                }

                else{

                    PassSugar(e_sugar);
                    PassSodium(e_sodium);
                    PassPotassium(e_potassium);
                    PassCholesterol(e_choles);
                    PassLdl(e_ldl);
                    PassHdl(e_hdl);
                    PassTrigryceride(e_tri);

                    SendData();
                }


                Log.d("String", String.valueOf(+e_sugar2 + "\n" + e_sodium2 + "\n" + e_potassium2 + "\n" +
                        e_choles2 + "\n" + e_ldl2 + "\n" + e_hdl2 + "\n" + e_tri2));

                Log.d("Int", sugar2 + "\n" + sodium2 + "\n" + potassium2 + "\n" +
                        choles2 + "\n" + ldl2 + "\n" + hdl2 + "\n" + tri2);


                Log.d("Level", Levels + "\n" + Levels1 + "\n"
                        + Levels2 + "\n" + Levels3 + "\n" + Levels4 + "\n" + Levels5 + "\n" + Levels6);

            }
        });

    }

    public void Calendar() {

      final  DatePickerDialog.OnDateSetListener date;

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateBloods.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateBloods.setText(sdf.format(myCalendar.getTime()));

        dateTime = dateBloods.getText().toString();

        Log.d("mm",dateTime);

    }

    public void PassSugar(EditText e_sugar) {

        if (e_sugar.getText().toString().trim().equals("")) {

            e_sugar.setText("0");
            e_sugar2 = (int) Float.parseFloat(e_sugar.getText().toString());
            sugar2 = "-";
            sugar2 = String.valueOf(e_sugar2);
            bloodTest.setSugar(e_sugar2);
            Levels = bloodTest.getSugar_Level();

        } else {
            e_sugar2 = (int) Float.parseFloat(e_sugar.getText().toString());
            sugar2 = String.valueOf(e_sugar2);

                bloodTest.setSugar(e_sugar2);
                Levels = bloodTest.getSugar_Level();

        }
        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/Glucose");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",sugar2);
        postBlootest2.put("level",Levels);
        database1.push().setValue(postBlootest2);

    }

    public void PassSodium(EditText e_sodium) {

        if (e_sodium.getText().toString().trim().equals("")) {
            e_sodium.setText("0");
            e_sodium2 = (int) Float.parseFloat(e_sodium.getText().toString());
            sodium2 = String.valueOf(e_sodium2);

            bloodTest.setSodium(e_sodium2);
            Levels1 = bloodTest.getSodium_Level();


        } else {
            e_sodium2 = (int) Float.parseFloat(e_sodium.getText().toString());
            sodium2 = String.valueOf(e_sodium2);

                bloodTest.setSodium(e_sodium2);
                Levels1 = bloodTest.getSodium_Level();


        }

        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/Sodium");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("nameofblood","Sodium");
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",sodium2);
        postBlootest2.put("level",Levels1);
        database1.push().setValue(postBlootest2);



    }

    public void PassPotassium(EditText e_potassium) {



        if (e_potassium.getText().toString().trim().equals("")) {
            e_potassium.setText("0");
            e_potassium2 = (int) Float.parseFloat(e_potassium.getText().toString());
            potassium2 = String.valueOf(e_potassium2);

            bloodTest.setPotassium(e_potassium2);
            Levels2 = bloodTest.getPotassium_Level();


        } else {
            e_potassium2 = (int) Float.parseFloat(e_potassium.getText().toString());
            potassium2 = String.valueOf(e_potassium2);

            bloodTest.setPotassium(e_potassium2);
                Levels2 = bloodTest.getPotassium_Level();

        }

        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/Potassium");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",potassium2);
        postBlootest2.put("level",Levels2);
        database1.push().setValue(postBlootest2);




    }

    public void PassCholesterol(EditText e_choles) {

        if (e_choles.getText().toString().trim().equals("")) {
            e_choles.setText("0");
            e_choles2 = (int) Float.parseFloat(e_choles.getText().toString());
            choles2 = String.valueOf(e_choles2);

            bloodTest.setCholesteral(e_choles2);
            Levels3 = bloodTest.getCholesterol_Level();
        } else {
            e_choles2 = (int) Float.parseFloat(e_choles.getText().toString());
            choles2 = String.valueOf(e_choles2);

                bloodTest.setCholesteral(e_choles2);
                Levels3 = bloodTest.getCholesterol_Level();

        }

        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/Cholesterol");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",choles2);
        postBlootest2.put("level",Levels3);
        database1.push().setValue(postBlootest2);


    }

    public void PassLdl(EditText e_ldl) {

        if (e_ldl.getText().toString().trim().equals("")) {
            e_ldl.setText("0");
            e_ldl2 = (int) Float.parseFloat(e_ldl.getText().toString());
            ldl2 = String.valueOf(e_ldl2);
            bloodTest.setLdl(e_ldl2);
            Levels4 = bloodTest.getLDL_Level();

        } else {
            e_ldl2 = (int) Float.parseFloat(e_ldl.getText().toString());
            ldl2 = String.valueOf(e_ldl2);


                bloodTest.setLdl(e_ldl2);
                Levels4 = bloodTest.getLDL_Level();

        }

        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/LDL");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",ldl2);
        postBlootest2.put("level",Levels4);
        database1.push().setValue(postBlootest2);


    }

    public void PassHdl(EditText e_hdl) {

        if (e_hdl.getText().toString().trim().equals("")) {
            e_hdl.setText("0");
            e_hdl2 = (int) Float.parseFloat(e_hdl.getText().toString());
            hdl2 = String.valueOf(e_hdl2);
            bloodTest.setHdl(e_hdl2);
            Levels5 = bloodTest.getHDL_Level();

        } else {
            e_hdl2 = (int) Float.parseFloat(e_hdl.getText().toString());
            hdl2 = String.valueOf(e_hdl2);


                bloodTest.setHdl(e_hdl2);
                Levels5 = bloodTest.getHDL_Level();

        }
        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/HDL");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",hdl2);
        postBlootest2.put("level",Levels5);
        database1.push().setValue(postBlootest2);



    }

    public void PassTrigryceride(EditText e_tri) {

        if (e_tri.getText().toString().trim().equals("")) {
            e_tri.setText("0");
            e_tri2 = (int) Float.parseFloat(e_tri.getText().toString());
            tri2 = String.valueOf(e_tri2);
            bloodTest.setTrigryceride(e_tri2);
            Levels6 = bloodTest.getTrigryceride_Level();
        } else {

            e_tri2 = (int) Float.parseFloat(e_tri.getText().toString());
            tri2 = String.valueOf(e_tri2);


                bloodTest.setTrigryceride(e_tri2);
                Levels6 = bloodTest.getTrigryceride_Level();

        }

        database1 = FirebaseDatabase.getInstance().getReference("User/Profile/List/put/Blood/list/Triglyceride");
        HashMap<String,Object> postBlootest2 = new HashMap<>();
        postBlootest2.put("Date",dateTime);
        postBlootest2.put("value",tri2);
        postBlootest2.put("level",Levels6);
        database1.push().setValue(postBlootest2);


    }

    public void SendData() {

        blood.add(sugar2);
        blood.add(sodium2);
        blood.add(potassium2);
        blood.add(choles2);
        blood.add(ldl2);
        blood.add(hdl2);
        blood.add(tri2);

        Log.d("blood", String.valueOf(blood));

        sym.add(Levels);
        sym.add(Levels1);
        sym.add(Levels2);
        sym.add(Levels3);
        sym.add(Levels4);
        sym.add(Levels5);
        sym.add(Levels6);

        Log.d("sym", String.valueOf(sym));

        bloodvalue.add(e_sugar2);
        bloodvalue.add(e_sodium2);
        bloodvalue.add((int) e_potassium2);
        bloodvalue.add(e_choles2);
        bloodvalue.add(e_ldl2);
        bloodvalue.add(e_hdl2);
        bloodvalue.add(e_tri2);

        try {
            Intent intent = new Intent(getActivity().getBaseContext(), ResultActivity.class);
            intent.putExtra("blood", blood);
            intent.putExtra("sym", sym);
            intent.putExtra("bloodvalue", bloodvalue);
            startActivity(intent);

            databaseRef = FirebaseDatabase.getInstance().getReference("User/Dates");
            databaseRef.push().setValue(dateTime);

        }
        catch (Exception ex){

            Toast.makeText(getActivity(),ex.toString(),Toast.LENGTH_LONG).show();
        }
    }

    public void Dialog() {

        final Dialog dDialog = new Dialog(getActivity());
        dDialog.setContentView(R.layout.dialogpopup);
        dDialog.getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView textView = (TextView)dDialog.findViewById(R.id.date_text);
        textView.setText("Please input Blood Test "+"\n"+" and Date MM/DD/YY");

        Button button2 = (Button) dDialog.findViewById(R.id.buttondialog);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dDialog.dismiss();
            }
        });

        dDialog.show();
    }

    public void Dialog2() {

        final Dialog dDialog = new Dialog(getActivity());
        dDialog.setContentView(R.layout.dialogpopup);
        dDialog.getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView textView = (TextView)dDialog.findViewById(R.id.date_text);
        textView.setText("Please input Date MM/DD/YY");
        Button button2 = (Button) dDialog.findViewById(R.id.buttondialog);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dDialog.dismiss();
            }
        });

        dDialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}