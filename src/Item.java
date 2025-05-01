import java.util.Date;

public class Item
{
    String name ;
    String id;
    int count;
    Date expiry;
    boolean avilable;
    static int items_count=0;
    Item (String name ,int count ,Date expiry)
    {
        this.expiry=expiry;
        this.name=name;
        this.count=count ;
        if(count>0)avilable=true;
        id=(++items_count)+" I";

    }
    
}
