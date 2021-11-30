package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.MyViewHolder> {
  private Context context;
  private List<AppsModel> appList;



    public class MyViewHolder  extends RecyclerView.ViewHolder{
        public TextView title,appDown;
        public ImageView thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            appDown=itemView.findViewById(R.id.count);
            thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }

    public AppsAdapter(Context context, List<AppsModel> appList) {
        this.context = context;
        this.appList = appList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_app,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      AppsModel appsModel = appList.get(position);
      holder.title.setText(appsModel.getName());
      holder.appDown.setText(appsModel.getNumOfDowmloads() +"Users");


      //DISPLAYING THE IMAGE USING GLIDE LIBRARY
        Glide.with(context)
                .load(appsModel.getThumbnail())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {

        return appList.size();
    }
}
