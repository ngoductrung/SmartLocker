package com.example.smartlocker;

public class LockerHolder {
    private String locker_id;
    private String grouplockerid;
    private String label;
    private String position;
    private String available;
    private int number;

    public LockerHolder(String locker_id, String grouplockerid, String label, String position, String available, int number) {
        this.locker_id = locker_id;
        this.grouplockerid = grouplockerid;
        this.label = label;
        this.position = position;
        this.available = available;
        this.number = number;
    }

    public String getLocker_id() {
        return locker_id;
    }

    public void setLocker_id(String locker_id) {
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
