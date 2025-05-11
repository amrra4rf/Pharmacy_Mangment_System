package main;

import java.time.LocalDate;
import java.util.Random;

public class Order 
{
  private String order_owner;
  private Item o;
  private int amount_ordered;
  private boolean order_shipped;
  private LocalDate order_date ;
  private String  order_number ;

  Order(String owner,Item it,int amount_ordered,LocalDate orderLocalDate)
  {
    this.order_owner=owner;
    this.o=it;
    this.amount_ordered=amount_ordered;
    this.order_date=orderLocalDate;
    this.order_number=order_date.toString()+"-"+Integer.toString((int)(Math.random()*10000));
    Random r =new Random();
    this.order_number=String.valueOf(Math.abs((r.nextInt(100000)+r.nextInt()*10)*r.nextInt()*10));//generates a completly random postive order number
    
  }
  //start of getters

  public Item get_item()
  {
    return o;
  }
  public int get_amount_ordered()
  {
    return amount_ordered;
  }
  public boolean get_order_shipped()
  {
    return order_shipped;
  }
  public LocalDate get_order_date()
  {
    return order_date;
  }
  public String get_order_number()
  {
    return order_number;
  }
  public String get_order_owner()
  {
    return order_owner;
  }

  //end of getters
  public void display_order_info()
  {
    System.out.println("Order Owner:"+get_order_owner());
    System.out.println("Item Name :"+o.get_name());
    System.out.println( "Item Id:"+o.get_id());
    System.out.println("Order Number "+order_number);
    System.out.println("Amount ordered"+amount_ordered);
    System.out.println("Order Date "+order_date);
    if(order_shipped) System.out.println("Order Status:Shipped ");
    else System.out.println("Order Status:Not Shipped Yet ");
    System.out.println("-------------------------------------");
  }


  public void ship_order()
  {
    order_shipped=true;
  }
  
}
