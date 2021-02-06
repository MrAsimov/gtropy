package com.gtropy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gtropy.R;
import com.gtropy.model.DataModel;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context mcontext;
    private List<DataModel> dataModelList;
    private OnItemClickListener listener;

    public DataAdapter(Context context, List<DataModel> dataModelList, OnItemClickListener listener){
        this.mcontext=context;
        this.dataModelList=dataModelList;
        this.listener=listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView vehicleid,location;
        private LinearLayout Container;
        public ViewHolder(View v) {
            super(v);
            vehicleid=(TextView)v.findViewById(R.id.vehicleid);
            location=(TextView)v.findViewById(R.id.location);
            Container=(LinearLayout)v.findViewById(R.id.container);
            Container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(mcontext).inflate(R.layout.adapter_data,viewGroup,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder vh, int position){
        vh.vehicleid.setText(dataModelList.get(position).getVehicleId());
        //vh.vehicleid.setText("pappu");
        vh.location.setText(dataModelList.get(position).getLocation());
    }

    @Override
    public int getItemCount(){
        return this.dataModelList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
