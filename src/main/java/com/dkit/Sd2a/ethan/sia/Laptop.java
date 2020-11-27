package com.dkit.Sd2a.ethan.sia;

public class Laptop extends Computer
{
    private String screenSizeInches;
    private String batteryLife;

    public Laptop(String type, String manufacturer, String processes, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate, String screenSizeInches, String batteryLife) {
        super(type, manufacturer, processes, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.screenSizeInches = screenSizeInches;
        this.batteryLife = batteryLife;
    }

    public String getScreenSizeInches() {
        return screenSizeInches;
    }

    public void setScreenSizeInches(String screenSizeInches) {
        this.screenSizeInches = screenSizeInches;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return "Laptop{" + super.toString()+
                "screenSizeInches='" + screenSizeInches + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                '}';
    }
}
