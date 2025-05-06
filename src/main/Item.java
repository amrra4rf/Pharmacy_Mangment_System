package main;
import java.time.LocalDate;

public class Item
{
    String name ;
    String id;
    int count;
    LocalDate expiry;
    static int items_count=0;
    double price;
    Item (String name ,int count ,LocalDate expiry,double price)
    {
        this.expiry=expiry;
        this.name=name;
        this.count=count ;
        id=(++items_count)+" I";
        this.price=price;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return (name.equals(item.name)); 
    }

    
    public void Displayinfo()
    {
        System.out.println("-----------------------------------------------");

        System.out.println("Item name :"+this.name);
        System.out.println("Item ID"+this.id);
        System.out.println("Item count:"+this.count);
        System.out.println("Price:"+this.price+"$");
        System.out.println("Expiry Date:"+expiry.toString());

        System.out.println("-----------------------------------------------");
    }
    
}
