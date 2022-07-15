package com.example.smartlocker;

import android.os.BaseBundle;
import android.os.Parcelable;

import java.io.Serializable;

public class LockerHolder implements Serializable{
    private int locker_id;
    private String grouplockerid;
    private String label;
    private String position;
    private String available;
    private int number;
    private String DeviceIMEI;

    public LockerHolder(int locker_id, String grouplockerid, String label, String position, String available, int number,String DeviceIMEI) {
        this.locker_id = locker_id;
        this.grouplockerid = grouplockerid;
        this.label = label;
        this.position = position;
        this.available = available;
        this.number = number;
        this.DeviceIMEI = DeviceIMEI;
    }

    public String getDeviceIMEI() {
        return DeviceIMEI;
    }

    public void setDeviceIMEI(String deviceIMEI) {
        DeviceIMEI = deviceIMEI;
    }

    public int getLocker_id() {
        return locker_id;
    }

    public void setLocker_id(int locker_id) {
        this.locker_id = locker_id;
    }

    public String getGrouplockerid() {
        return grouplockerid;
    }

    public void setGrouplockerid(String grouplockerid) {
        this.grouplockerid = grouplockerid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return available;
    }

    public void setStatus(String status) {
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
