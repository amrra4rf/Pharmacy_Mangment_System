import java.util.Date;

import javax.lang.model.type.NullType;
import javax.naming.NameNotFoundException;

public class Doctor extends Person implements Capabilities
{
    private static int count_of_doctors=0;
    private String id;
    private String password;//both the password and id will be used in the login process
    private double salary;
    Doctor(String name ,int age ,double salary,String password)
    {
        super(name ,age);//pass the name and age to the person class to intialize them
        id=(++count_of_doctors)+"D";// make the doctor id as his number + 'D' letter
        this.password=password;
        this.salary=salary;
    }




    void display_self()
    {
        System.out.println("Name: Dr/"+this.name);
        System.out.println("Id:"+this.id);
        System.out.println("Age:"+this.age);
        System.out.println("Salary:"+this.salary+"$");
        System.out.println("-----------------------------------------------");
    }



    public void find_person_by_name(String n )// this function display all of the persons with the given intials 
    {
        for(int i=0;i<(p.person.length);i++)  //p.person.length returns the number of persons assigned in the pharmacy
        {
            if (p.person[i].name.substring(0,n.length())==n) 
            {
                p.person[i].display_self();
            }
        }
    }

    public void add_item(String n ,int count,Date expiry)
    {
        if(Pharmacy.item_count_in_pharmacy<Pharmacy.length*10)  //checks if there is a place for items in the pharmacy 
            p.items[Pharmacy.item_count_in_pharmacy++]=new Item(n, count, expiry);

    }

    //Overwrite method in case u know the item type tablet or liquid
    public void add_item(String n ,int count,Date expiry,char type)
    {
        if(Pharmacy.item_count_in_pharmacy<Pharmacy.length*10)
        {
                //if item is liquid or tablet
                if(type=='l'||type=='L')
                    p.items[Pharmacy.item_count_in_pharmacy++]=new Liquid (n, count, expiry);//polymorphism applied :)

            else if (type=='t'||type=='T')
                    p.items[Pharmacy.item_count_in_pharmacy++]=new Tablet (n, count, expiry);//polymorphism applied :)
        }
    }


    public void Display_Persons()
    {
        for (int i=0;i<Pharmacy.persons_count_in_pharamcy;i++)
        {
            p.person[i].display_self();
        }
    }

    //remove a certain amount of the item by giving the item name 
    public void remove_item_by_name(String name,int count_to_be_removed)
    {
        for(int i=0;i<Pharmacy.item_count_in_pharmacy;i++)
        {
            if(p.items[i].name==name)
            {
                //Exception if (count_to_be_removed >count) will be added
                p.items[i].count-=count_to_be_removed;//removed an amount of the item from the Pharmacy
                break;
            }
        }
    }


    //remove a certain amount of the item by giving the item id
    public void remove_item_by_id(String id,int count_to_be_removed)
    {
        for(int i=0;i<Pharmacy.item_count_in_pharmacy;i++)
        {
            if(p.items[i].id==id)
            {
                //Exception if (count_to_be_removed >count) will be added
                p.items[i].count-=count_to_be_removed;//removed an amount of the item from the Pharmacy
                break;
            }
        }
    }


    public Item find_item_by_name (String name) throws NameNotFoundException
    {
        //this is a ref of type item that will refer to the wanted item and will be returned 
        Item temp=null;
        for (int i=0;i<Pharmacy.item_count_in_pharmacy;i++)
        {
            if (p.items[i].name ==name )
            {
                temp=p.items[i];
                return temp;
            }
            
        }
        
            //if no item with this name found
            throw new NameNotFoundException("\""+name+"\"" +"is not found");
        
    }
    public Item find_item_by_id  (String id) 
    {
        Item temp=null;
        for (int i=0;i<Pharmacy.item_count_in_pharmacy;i++)
        {
            if (p.items[i].id ==id )
            {
                temp=p.items[i];
                return temp;
            }
            
        }
        //This throws a custom exception called IdNotFoundException which will be added later
        return temp;
    }

    //Method to add a new amount to an existing item by item name 
    public void increase_amount_of_item_by_name(String name, int amount_to_be_added)throws NameNotFoundException
    {
        for (int i=0;i<Pharmacy.item_count_in_pharmacy;i++)
        {
            if(p.items[i].name==name)
            {
                p.items[i].count+=amount_to_be_added;
                break;
            }
        }
        throw new NameNotFoundException("No Item With This Name Was Found");


    }


    //Method to add a new amount to an existing item by item id 
    public void increase_amount_of_item_by_id(String id ,int amount_to_be_added)
    {
        for (int i=0;i<Pharmacy.item_count_in_pharmacy;i++)
        {
            if(p.items[i].id==id)
            {
                p.items[i].count+=amount_to_be_added;
                break;
            }
            //custom made exception of IdNotFound will be added here
        }

    }





   
}
