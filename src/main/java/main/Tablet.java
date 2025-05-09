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
        System.out.println("-----------------------------------------------");

        System.out.println("Item name :" + this.get_name());
        System.out.println("Item ID:" + this.get_id());
        System.out.println("Item count:" + this.get_count());
        System.out.println("Price:" + this.get_price() + "$");
        System.out.println("Expiry Date:" + get_expiry_date().toString());
        System.out.println("Volume :"+number_of_capsules);

        System.out.println("-----------------------------------------------");
    }




}
