package com.example.emergencyalert;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    List<Notifications> list;

    public Adapter(Context context, List<Notifications> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_layout,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
          myViewHolder.title.setText(list.get(i).getTitle());
          myViewHolder.description.setText(list.get(i).getDescription());
          myViewHolder.date.setText(tarihHazirla(list.get(i).getDate()));

    }

    public String tarihHazirla(String gelenTarih){
        String donecekString =  "";
        String yil = "";
        String ay = "";
        String gun = "";
        String saat = "";

        yil = gelenTarih.substring(0,4);
        ay = gelenTarih.substring(5,7);
        gun = gelenTarih.substring(8,10);

        saat = gelenTarih.substring(11);

        donecekString = gun + "-" + ay + "-" + yil + " " + saat;

        return donecekString ;


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;
        TextView date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }
}
