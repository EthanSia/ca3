package com.dkit.Sd2a.ethan.sia;

public class Desktop extends Computer
{
    private String monitor;

    public Desktop(String type, String manufacturer, String processes, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate, String monitor) {
        super(type, manufacturer, processes, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.monitor = monitor;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Desktop{" + super.toString()+
                "monitor='" + monitor + '\'' +
                '}';
    }
}

