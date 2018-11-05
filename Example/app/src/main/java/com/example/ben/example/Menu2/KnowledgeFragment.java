package com.example.ben.example.Menu2;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ben.example.Data.B_information;
import com.example.ben.example.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class KnowledgeFragment extends Fragment {


    private CardView CL1, CL2, CL3, CL4, CL5, CL6;
    private DatabaseReference databaseReference;
    private ProgressDialog progress_loading;

    // private static final String URL_blood = "http://192.168.0.11/B_test/AlllData.php";
    private RecyclerView recyclerView;
    ArrayList<B_information> list = new ArrayList<>();
    KnowledgeAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_knowledge, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycleview_kn);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager);
        checkInternet();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Android/knowledge");

        Log.d("Ben", "6");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("Ben", "10");

                list = new ArrayList<B_information>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Log.d("Ben", "11");

                    B_information p = dataSnapshot1.getValue(B_information.class);
                    list.add(p);
                }
                adapter = new KnowledgeAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "There was a problem with the network", Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }

    private void showProgressDialog() {
        if (progress_loading == null) {
            progress_loading = new ProgressDialog(getActivity());
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

    public void checkInternet() {

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            hideProgressDialog();
        } else {
            connected = false;
            showProgressDialog();
        }

    }

}

