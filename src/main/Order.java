package main;

import java.time.LocalDate;

public class Order 
{
  Item o;
  int amount_ordered;
  boolean order_shipped;
  LocalDate order_date ;
  String  order_number ;

  Order(Item it,int amount_ordered,LocalDate orderLocalDate)
  {
    this.o=it;
    this.amount_ordered=amount_ordered;
    this.order_date=orderLocalDate;
    this.order_number=order_date.toString()+"-"+Integer.toString((int)(Math.random()*10000));
  }
  public void display_order_info()
  {
    
    System.out.println("Item Name :"+o.name+"   Item Id:"+o.id);
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
