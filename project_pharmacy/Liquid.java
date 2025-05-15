package project_pharmacy;

import java.time.LocalDate;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    
        ab.appendText("------------------------------------------------------\n");
        ab.appendText("Item name :" + this.get_name()+"\n");
        ab.appendText("Item ID:" + this.get_id()+"\n");
        ab.appendText("Item count:" + this.get_count()+"\n");
        ab.appendText("Price:" + this.get_price() + "$\n");
        ab.appendText("Expiry Date:" + get_expiry_date().toString()+"\n");
        ab.appendText("Item Volume:" + volume+"\n");
        ab.appendText("------------------------------------------------------");
        
        
        
    }
}
