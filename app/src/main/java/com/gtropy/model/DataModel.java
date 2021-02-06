package com.gtropy.model;
import com.google.gson.annotations.SerializedName;
public class DataModel {
    @SerializedName("Vehicle")
    private String Vehicle;

    @SerializedName("Lati")
    private Double Lati;

    @SerializedName("Long")
    private Double Long;

    @SerializedName("Date")
    private String date;

    @SerializedName("Imei")
    private String Imei;

    @SerializedName("VehicleId")
    private String vehicleId;

    @SerializedName("Location")
    private String Location;

    @SerializedName("Moving")
    private String Moving;

    @SerializedName("NoDate")
    private String noDate;

    @SerializedName("CompanyId")
    private String companyId;

    @SerializedName("TrackNum")
    private String trackNum;

    @SerializedName("ExtraInfo")
    private String extraInfo;

    @SerializedName("DriverName")
    private String driverName;

    @SerializedName("DriverMobile")
    private String driverMobile;

    @SerializedName("Mobile")
    private String Mobile;

    @SerializedName("Device")
    private String device;

    public void setVehicle(String vehicle){
        this.Vehicle=vehicle;
    }

    public void setLati(Double lati){
        this.Lati=lati;
    }

    public void setLong(Double aLong){
        this.Long=aLong;
    }

    public void setDate(String date){
        this.date=date;
    }

    public void setImei(String imei){
        this.Imei=imei;
    }

    public void setVehicleId(String Vehicleid){
        this.vehicleId=vehicleId;
    }

    public void setLocation(String location){
        this.Location=location;
    }
    public void setMoving(String moving){
        this.Moving=moving;
    }
    public void setNoDate(String noDate){
        this.noDate=noDate;
    }

    public void setCompanyId(String companyId){
        this.companyId=companyId;
    }

    public void setTrackNum(String trackNum){
        this.trackNum=trackNum;
    }

    public void setExtraInfo(String extraInfo){
        this.extraInfo=extraInfo;
    }

    public void setDriverName(String driverName){
        this.driverName=driverName;
    }

    public void setDriverMobile(String driverMobile){
        this.driverMobile=driverMobile;
    }

    public void setMobile(String mobile){
        this.Mobile=mobile;
    }

    public void setDevice(String device){
        this.device=device;
    }

    public String getCompanyId(){
        return this.companyId;
    }

    public String getVehicle(){
        return this.Vehicle;
    }

    public Double getLong(){
        return this.Long;
    }
    public Double getLati(){
        return this.Lati;
    }
    public String getDevice(){
        return this.device;
    }
    public String getMobile(){
        return this.Mobile;
    }
    public String getDriverMobile(){
        return this.driverMobile;
    }
    public String getDriverName(){
        return this.driverName;
    }
    public String getExtraInfo(){
        return this.extraInfo;
    }
    public String getTrackNum(){
        return this.trackNum;
    }
    public String getNoDate(){
        return this.noDate;
    }
    public String getMoving(){
        return this.Moving;
    }
    public String getLocation(){
        return this.Location;
    }
    public String getVehicleId(){
        return this.vehicleId;
    }
    public String getImei(){
        return this.Imei;
    }
    public String getDate(){
        return this.date;
    }
}