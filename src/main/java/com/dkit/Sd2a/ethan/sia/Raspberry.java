package com.dkit.Sd2a.ethan.sia;

public class Raspberry extends Computer
{
    private int GPIOPins;
    private String sdCard;

    public Raspberry(String type, String manufacturer, String processes, String ramSize, String diskSize, String weight, String assetTag, String purchaseDate, int GPIOPins, String sdCard) {
        super(type, manufacturer, processes, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.GPIOPins = GPIOPins;
        this.sdCard = sdCard;
    }

    public int getGPIOPins() {
        return GPIOPins;
    }

    public void setGPIOPins(int GPIOPins) {
        this.GPIOPins = GPIOPins;
    }

    public String getSdCard() {
        return sdCard;
    }

    public void setSdCard(String sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public String toString() {
        return "Raspberry{" + super.toString()+
                "GPIOPins=" + GPIOPins +
                ", sdCard='" + sdCard + '\'' +
                '}';
    }
}
