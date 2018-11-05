package com.example.ben.example.Menu1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ben.example.Data.BloodInformation;
import com.example.ben.example.R;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class Blooddapter extends RecyclerView.Adapter<Blooddapter.MyViewHolder>{

    private List<BloodInformation> bloodInformationList;
    Intent i;
    private Context context;

    public Blooddapter(List<BloodInformation> bloodInformation, Context context) {
        this.bloodInformationList = bloodInformation;
        this.context = context;
    }

    @NonNull
    @Override
    public Blooddapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blood, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Blooddapter.MyViewHolder holder, final int position) {

        final BloodInformation bloodInformation = bloodInformationList.get(position);

        holder.T1.setText(bloodInformation.getName());
        holder.Tlevel.setText(bloodInformation.getLevel());
        holder.T3.setText(bloodInformation.getValue());
        holder.T4.setText(bloodInformation.getUnit());
        holder.sk.setProgress(bloodInformation.getSeekbar());
        holder.pb.setProgress(bloodInformation.getProgressbar());
        holder.pb.setSecondaryProgress(bloodInformation.getSecondprogressbar());
        holder.pb.setMax(bloodInformation.getMaxprogressbar());
        holder.sk.setMax(bloodInformation.getMaxseekbar());


        if(bloodInformation.getLevel().equalsIgnoreCase("normal volume")){
            holder.photo2.setImageResource(R.drawable.normal);
        }
        else if(bloodInformation.getLevel().equalsIgnoreCase("high volume")){
            holder.photo2.setImageResource(R.drawable.high);
        }
        else if(bloodInformation.getLevel().equalsIgnoreCase("high risk volume")){
            holder.photo2.setImageResource(R.drawable.high);
        }
        else if(bloodInformation.getLevel().equalsIgnoreCase("borderline(high) volume")){
            holder.photo2.setImageResource(R.drawable.high);
        }
        else if(bloodInformation.getLevel().equalsIgnoreCase("low volume")){
            holder.photo2.setImageResource(R.drawable.low);
        }
        else if(bloodInformation.getLevel().equalsIgnoreCase("volume")){
            holder.photo2.setImageResource(R.drawable.volume);
            holder.BD.setVisibility(View.GONE);

        }


        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
       @Override
        public void onClick(View v) {
        Log.d("position","1");

        Intent i = new Intent(context,Explain3Activity.class);
        i.putExtra("T1",bloodInformation.getName());
        i.putExtra("TLevel",bloodInformation.getLevel());
        i.putExtra("T3",bloodInformation.getValue());
           i.putExtra("T4",bloodInformation.getUnit());
           i.putExtra("sk",bloodInformation.getSeekbar());
        i.putExtra("pb",bloodInformation.getProgressbar());
        i.putExtra("pb2",bloodInformation.getSecondprogressbar());
        i.putExtra("pb3",bloodInformation.getMaxprogressbar());
        i.putExtra("sk2",bloodInformation.getMaxseekbar());
        i.putExtra("info1",bloodInformation.getInfo1());
           i.putExtra("info2",bloodInformation.getInfo2());
           i.putExtra("info3",bloodInformation.getInfo3());
           i.putExtra("info4",bloodInformation.getInfo4());
           i.putExtra("info5",bloodInformation.getInfo5());
           i.putExtra("info6",bloodInformation.getInfo6());

           context.startActivity(i);
    }
});
    }

    @Override
    public int getItemCount() {
        return bloodInformationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView T1,T2,Tlevel,T3,T4;
        private TextView info1,info2,info3,info4,info5,info6;
        private ImageView photo2;
        private ProgressBar pb;
        private SeekBar sk;
        private LinearLayout parentlayout,BD;

        public MyViewHolder(View itemView) {
            super(itemView);

            T1 = (TextView)itemView.findViewById(R.id.T1);
            Tlevel = (TextView)itemView.findViewById(R.id.TLevel);
            T3 = (TextView)itemView.findViewById(R.id.T3);
            T4 = (TextView)itemView.findViewById(R.id.T4);
            photo2 = (ImageView)itemView.findViewById(R.id.photo2);
            sk = (SeekBar)itemView.findViewById(R.id.sb);
            pb = (ProgressBar)itemView.findViewById(R.id.pbb);
            parentlayout = (LinearLayout)itemView.findViewById(R.id.parentlayout);
            BD = (LinearLayout)itemView.findViewById(R.id.BD);

            info1 = (TextView)itemView.findViewById(R.id.info1);
            info2 = (TextView)itemView.findViewById(R.id.info2);
            info3 = (TextView)itemView.findViewById(R.id.info3);
            info4 = (TextView)itemView.findViewById(R.id.info4);
            info5 = (TextView)itemView.findViewById(R.id.info5);
            info6 = (TextView)itemView.findViewById(R.id.info6);


        }
    }
}
