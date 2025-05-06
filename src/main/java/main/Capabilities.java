package main;

import java.time.LocalDate;
import javax.naming.NameNotFoundException;

public interface Capabilities
{
    public void add_item(String name ,int count,LocalDate expiry,double price);//done
    public void add_item(String name ,int count,LocalDate expiry,double price ,char type);//done + this method add an item with the type being known (Liquid or Tablet)
    public void remove_item(Item removed_item,int count_to_be_removed);
    public void remove_item_by_name(String name,int count_to_be_removed)throws NameNotFoundException;//done
    public void remove_item_by_id(String id,int count_to_be_removed);//done+This throws a custom exception called IdNotFoundException which will be added later
    public void increase_amount_of_item(Item increased_item,int amount_to_be_added);
    public void increase_amount_of_item_by_name(String name, int amount_to_be_added)throws NameNotFoundException;//done
    public void increase_amount_of_item_by_id(String id ,int amount_to_be_added);//done
    public void ship_item();//done
    public Item find_item_by_name (String name) ;//done
    public Item find_item_by_id  (String id) ;   //done
}
