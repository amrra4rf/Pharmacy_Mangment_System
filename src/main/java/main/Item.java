package main;

import java.time.LocalDate;

public class Item implements Comparable<Item> {
    private String name;
    private String id;
    private int count;
    private LocalDate expiry;
    private static int items_count = 0;
    private double price;

    Item(String name, int count, LocalDate expiry, double price) {
        this.expiry = expiry;
        this.name = name;
        this.count = count;
        id = (++items_count) + "I";
        this.price = price;

    }

    //start of getters
        public String get_name()
        {
            return name;
        }

        public String get_id()
        {
            return id;
        }

        public int get_count()
        {
            return count;
        }

        public LocalDate get_expiry_date()
        {
            return expiry;
        }
        
        public double get_price()
        {
            return price;
        }
    //end of getters 

        //start of setters
          
            public void set_subtract_count(int temp_count)
            {
                count-=temp_count;
            }
            public void set_add_count(int temp_count)
            {
                count+=temp_count;
            }
            public void set_id(String id)
            {
                this.id=id;
            }
        //end of setters



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        return (name.equals(item.name));
    }

    @Override
    public int compareTo(Item it) {
        return Double.compare(this.price, it.price);
    }

    public void Displayinfo() {
        System.out.println("-----------------------------------------------");

        System.out.println("Item name :" + this.name);
        System.out.println("Item ID:" + this.id);
        System.out.println("Item count:" + this.count);
        System.out.println("Price:" + this.price + "$");
        System.out.println("Expiry Date:" + expiry.toString());

        System.out.println("-----------------------------------------------");
    }

}
