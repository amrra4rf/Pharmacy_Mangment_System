import java.util.Date;

import javax.naming.NameNotFoundException;

public interface Capabilities
{
    public void add_item(String name ,int count,Date expiry);//done
    public void add_item(String name ,int count,Date expiry,char type);//done + this method add an item with the type being known (Liquid or Tablet)
    public void remove_item_by_name(String name,int count_to_be_removed)throws NameNotFoundException;//done
    public void remove_item_by_id(String id,int count_to_be_removed);//done+This throws a custom exception called IdNotFoundException which will be added later
    public void increase_amount_of_item_by_name(String name, int amount_to_be_added)throws NameNotFoundException;//done
    public void increase_amount_of_item_by_id(String id ,int amount_to_be_added);//done
    public void sell_item(Item i);
    public void sell_item_by_id(String id);
    public Item find_item_by_name (String name)throws NameNotFoundException;//done
    public Item find_item_by_id  (String id) ;//done
}
