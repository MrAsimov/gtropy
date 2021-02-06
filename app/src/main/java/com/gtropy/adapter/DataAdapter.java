package com.gtropy.adapter;

import android.content.Context;
import android.graphics.Color;
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
    private String[] colors;
    //private List<String> colors=

    public DataAdapter(Context context, List<DataModel> dataModelList, OnItemClickListener listener){
        this.mcontext=context;
        this.dataModelList=dataModelList;
        this.listener=listener;
    }
    public DataAdapter(Context context, List<DataModel> dataModelList, OnItemClickListener listener,String[] color){
        this.mcontext=context;
        this.dataModelList=dataModelList;
        this.listener=listener;
        this.colors=color;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView vehicleid,location,date,drivername,drivernumber;
        private LinearLayout Container;
        public ViewHolder(View v) {
            super(v);
            vehicleid=(TextView)v.findViewById(R.id.vehicleid);
            location=(TextView)v.findViewById(R.id.location);
            Container=(LinearLayout)v.findViewById(R.id.container);
            date=(TextView)v.findViewById(R.id.date);
            drivername=(TextView)v.findViewById(R.id.drivername);
            drivernumber=(TextView)v.findViewById(R.id.drivernumber);

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
        String vehicleid,location,date,driverName,driverNumber;
        if(dataModelList.get(position).getVehicleId()==null)
            vehicleid="ID";
        else{
            vehicleid=dataModelList.get(position).getVehicleId();
        }
        if(dataModelList.get(position).getLocation()==null){
            location="LOCATION";
        }else{
            location=dataModelList.get(position).getLocation();
        }

        if(dataModelList.get(position).getDate()==null){
            date="Dateee";
        }else{
            date=dataModelList.get(position).getDate();
        }

        if(dataModelList.get(position).getDriverName()==null){
            driverName="Driver-name";
        }else{
            driverName=dataModelList.get(position).getDriverName();
        }

        if(dataModelList.get(position).getDriverMobile()==null){
            driverNumber="Driver-number";
        }else{
            driverNumber=dataModelList.get(position).getDriverMobile();
        }
        vh.vehicleid.setText("Vehicle id:"+vehicleid);
        vh.location.setText("Location:"+location);
        vh.date.setText(date);
        vh.drivername.setText("Driver name:"+driverName);
        vh.drivernumber.setText("Driver number:"+driverNumber);

        int clength=colors.length;
        int pos=position% clength;

        vh.Container.setBackgroundColor(Color.parseColor(colors[pos]));
    }

    @Override
    public int getItemCount(){
        return this.dataModelList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
