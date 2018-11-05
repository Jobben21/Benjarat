package com.example.ben.example.Menu3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ben.example.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileBdFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ProfileBdFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private LinearLayout M1,M2,M3,M4,M5,M6,M7;
    int i;
    public ProfileBdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_profile_bd, container, false);

        M1 = (LinearLayout)v.findViewById(R.id.click);
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);            }
        });

        M2 = (LinearLayout)v.findViewById(R.id.click2);
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 1;

                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);
            }
        });

        M3 = (LinearLayout)v.findViewById(R.id.click3);
        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 2;

                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);
            }
        });

        M4 = (LinearLayout)v.findViewById(R.id.click4);
        M4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 3;

                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);
            }
        });

        M5 = (LinearLayout)v.findViewById(R.id.click5);
        M5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 4;

                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);
            }
        });

        M6 = (LinearLayout)v.findViewById(R.id.click6);
        M6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 5;

                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);
            }
        });

        M7 = (LinearLayout)v.findViewById(R.id.click7);
        M7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 6;

                Intent intent = new Intent(getActivity().getBaseContext(),DetaileActivity.class);
                intent.putExtra("num",i);
                startActivity(intent);
            }
        });


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
