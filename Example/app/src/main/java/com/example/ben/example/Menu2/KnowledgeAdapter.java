package com.example.ben.example.Menu2;

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
import android.widget.TextView;

import com.example.ben.example.Data.B_information;
import com.example.ben.example.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.ViewHolder> {

    private ArrayList<B_information> blood;
    private Context context;


    public KnowledgeAdapter(Context context, ArrayList<B_information> bloodNames) {

        this.context = context;
        this.blood = bloodNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("Ben", "12");
        View v = (LayoutInflater.from(context).inflate(R.layout.item_knowledge, parent,false));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final B_information bloodName2 = blood.get(position);

        Log.d("Ben", "8");

        holder.b1.setText(bloodName2.getB1());
        Picasso.get().load(bloodName2.getImageview()).into(holder.imageview);

        holder.Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ListKnowledgeActivity.class);

                i.putExtra("b1", bloodName2.getB1());
                i.putExtra("B_high_volum", bloodName2.getB_high_volum());
                i.putExtra("B_low_volum", bloodName2.getB_low_volum());
                i.putExtra("B_normal_volum", bloodName2.getB_normal_volum());
                i.putExtra("B_unit", bloodName2.getB_unit());
                i.putExtra("B_data", bloodName2.getB_data());
                i.putExtra("B_data_information",bloodName2.getB_data_information());
                i.putExtra("B_data_information2",bloodName2.getB_data_information2());

                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return blood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        LinearLayout Click;

        TextView b1, B_data, B_high_volum, B_low_volum;
        TextView B_normal_volum,B_unit,B_data_information,B_data_information2;
        ImageView imageview;

        public ViewHolder(View itemView) {
            super(itemView);

            imageview = (ImageView) itemView.findViewById(R.id.know_image);
            b1 = (TextView) itemView.findViewById(R.id.b1);
            B_data = (TextView) itemView.findViewById(R.id.b_vol1);
            B_high_volum = (TextView) itemView.findViewById(R.id.b_vol2);
            B_low_volum = (TextView) itemView.findViewById(R.id.b_vol3);
            B_normal_volum = (TextView) itemView.findViewById(R.id.b_unit);
            B_unit = (TextView) itemView.findViewById(R.id.b_data);
            B_data_information = (TextView) itemView.findViewById(R.id.b_data_info);
            B_data_information2 = (TextView) itemView.findViewById(R.id.b_data_info2);
            Click = (LinearLayout) itemView.findViewById(R.id.click);


        }
    }
}
