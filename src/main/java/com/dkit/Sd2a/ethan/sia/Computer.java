package com.dkit.Sd2a.ethan.sia;

public class Computer
{
    private String type;
    private String manufacturer;
    private String processes;
    private String ramSize;
    private String diskSize;
    private String weight;
    private String assetTag;
    private String purchaseDate;

    public Computer(String type, String manufacturer, String processes, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.processes = processes;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = purchaseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProcesses() {
        return processes;
    }

    public void setProcesses(String processes) {
        this.processes = processes;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(String diskSize) {
        this.diskSize = diskSize;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", processes='" + processes + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", diskSize='" + diskSize + '\'' +
                ", weight='" + weight + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }
}
