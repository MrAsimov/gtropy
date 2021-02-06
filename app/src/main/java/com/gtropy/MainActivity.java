package com.gtropy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.gtropy.adapter.DataAdapter;
import com.gtropy.model.DataModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements DataAdapter.OnItemClickListener {

    List<DataModel> data=new ArrayList<DataModel>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json=get_json();
        try {

            JSONArray obj = new JSONArray(json);
            for(int i=0;i<obj.length();i++){
                DataModel model=new DataModel();
                model.setCompanyId(obj.getJSONObject(i).getString("CompanyId"));
                model.setVehicle(obj.getJSONObject(i).getString("Vehicle"));
                model.setDate(obj.getJSONObject(i).getString("Date"));

                model.setDevice(obj.getJSONObject(i).getString("Device"));
                model.setMobile(obj.getJSONObject(i).getString("Mobile"));
                model.setDriverMobile(obj.getJSONObject(i).getString("DriverMobile"));
                model.setExtraInfo(obj.getJSONObject(i).getString("ExtraInfo"));
                model.setTrackNum(obj.getJSONObject(i).getString("TrackNum"));
                model.setNoDate(obj.getJSONObject(i).getString("NoDate"));
                model.setMoving(obj.getJSONObject(i).getString("Moving"));
                model.setLocation(obj.getJSONObject(i).getString("Location"));
                model.setVehicleId(obj.getJSONObject(i).getString("VehicleId"));
                model.setImei(obj.getJSONObject(i).getString("Imei"));
                model.setLong(obj.getJSONObject(i).getDouble("Long"));
                model.setLati(obj.getJSONObject(i).getDouble("Lati"));

                //Toast.makeText(getApplicationContext(),model.getCompanyId(),Toast.LENGTH_SHORT).show();

                data.add(model);

                Toast.makeText(getApplicationContext(),data.get(i).getLocation(),Toast.LENGTH_LONG).show();

            }

            setAdapter(data);

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Exception",Toast.LENGTH_SHORT).show();
        }
    }

    public void setAdapter(List<DataModel> data){
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_vendor_list);
        DataAdapter adapter=new DataAdapter(this,data,this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearVertical);
    }

    public String get_json(){
        String json;
        try {
            InputStream is = this.getAssets().open("data_1_.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"E "+e.toString(),Toast.LENGTH_SHORT).show();

            e.printStackTrace();
            return null;
        }
        return json;
    }

    public void onItemClick(int position){
        Intent intent = new Intent(this,MapActivity.class);
        intent.putExtra("lattitude",data.get(position).getLati());
        intent.putExtra("longitude",data.get(position).getLong());
        startActivity(intent);
    }
}