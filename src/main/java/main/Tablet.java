package main;
import java.time.LocalDate;


public class Tablet extends Item {
   private  int number_of_capsules;

    Tablet(String name, int count, LocalDate expiry, int number_of_capsules, double price) {
        super(name, count, expiry, price);
        this.number_of_capsules = number_of_capsules;
    }

    //start of getters
        public int get_number_capsules()
        {
            return number_of_capsules;
        }
    //end of getters


    @Override
    public void Displayinfo()
    {
      
        Item.get_text_area_ab(). appendText("------------------------------------------------------\n");
        Item.get_text_area_ab().appendText("Item name :" + this.get_name()+"\n");
        Item.get_text_area_ab().appendText("Item ID:" + this.get_id()+"\n");
        Item.get_text_area_ab().appendText("Item count:" + this.get_count()+"\n");
        Item.get_text_area_ab().appendText("Price:" + this.get_price() + "$\n");
        Item.get_text_area_ab().appendText("Expiry Date:" + get_expiry_date().toString()+"\n");
        Item.get_text_area_ab().appendText("Item number of capsules:" + number_of_capsules+"\n");
        Item.get_text_area_ab().appendText("------------------------------------------------------");
        
        
    }




}
