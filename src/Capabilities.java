package projectpharmacy;
public interface Capabilities
{
    void add_item(Item i);
    void remove_item(Item i);
    void remove_item_by_id(String id);
    void sell_item(Item i);
    void sell_item_by_id(String id);
    void find_item_by_name (String name);
    void find_item_by_id  (String id) ;
}
