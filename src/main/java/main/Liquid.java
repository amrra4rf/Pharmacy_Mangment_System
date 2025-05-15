package main;

import java.time.LocalDate;


public class Liquid extends Item {
private double volume;

    Liquid(String name, int count, LocalDate expiry, double volume, double price) {
        super(name, count, expiry, price);
        this.volume = volume;
    }
public Double get_volume(){return volume;}


    @Override
    public void Displayinfo()
    {
    
        Item.get_text_area_ab().appendText("------------------------------------------------------\n");
        Item.get_text_area_ab().appendText("Item name :" + this.get_name()+"\n");
        Item.get_text_area_ab().appendText("Item ID:" + this.get_id()+"\n");
        Item.get_text_area_ab().appendText("Item count:" + this.get_count()+"\n");
        Item.get_text_area_ab().appendText("Price:" + this.get_price() + "$\n");
        Item.get_text_area_ab().appendText("Expiry Date:" + get_expiry_date().toString()+"\n");
        Item.get_text_area_ab().appendText("Item Volume:" + volume+"\n");
        Item.get_text_area_ab().appendText("------------------------------------------------------");
        
        
        
    }
}
