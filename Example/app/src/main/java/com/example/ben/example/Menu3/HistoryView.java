package com.example.ben.example.Menu3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ben.example.Data.BloodProfile;
import com.example.ben.example.R;

import java.util.ArrayList;

public  class HistoryView extends RecyclerView.Adapter<HistoryView.MyViewHolder> {

    ArrayList<BloodProfile> list = new ArrayList<>();
    private Context context;

    public HistoryView(ArrayList<BloodProfile> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = (LayoutInflater.from(context).inflate(R.layout.item_list_detail, parent,false));

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        final BloodProfile bloodName2 = list.get(position);

        holder.textView.setText(bloodName2.getValue());
        holder.textView1.setText(bloodName2.getLevel());
        holder.textView2.setText(bloodName2.getDate());

        if(bloodName2.getValue().equalsIgnoreCase("0")){
            holder.linearLayout.setVisibility(View.GONE);
        }
        if( bloodName2.getValue().equalsIgnoreCase("0.0")){
            holder.linearLayout.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView textView,textView1,textView2,unit;
        private SeekBar seekBar;
        private ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.Click);
            textView = (TextView)itemView.findViewById(R.id.date1);
            textView1 = (TextView)itemView.findViewById(R.id.level1);
            textView2 = (TextView)itemView.findViewById(R.id.value1);


        }
    }
}
