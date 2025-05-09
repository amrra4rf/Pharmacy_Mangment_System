package main;

import java.time.LocalDate;

public class Liquid extends Item {
private double volume;

    Liquid(String name, int count, LocalDate expiry, double volume, double price) {
        super(name, count, expiry, price);
        this.volume = volume;
    }

    @Override
    public void Displayinfo()
    {
        System.out.println("-----------------------------------------------");

        System.out.println("Item name :" + this.get_name());
        System.out.println("Item ID:" + this.get_id());
        System.out.println("Item count:" + this.get_count());
        System.out.println("Price:" + this.get_price() + "$");
        System.out.println("Expiry Date:" + get_expiry_date().toString());
        System.out.println("Volume :"+volume);

        System.out.println("-----------------------------------------------");
    }
}
