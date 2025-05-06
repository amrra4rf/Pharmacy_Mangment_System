package main;
import java.util.Scanner;


public class Customer extends Person
{
    Double Balance;
    char gender;
    boolean have_Prescription;


    Customer(String name ,int age,char gender,boolean have_Prescription,double Balance,String password)
    {
            super(name, age,password);
            this.gender=gender;
            this.have_Prescription=have_Prescription;
            this.Balance=Balance;
    }

    @Override
    void display_self()
    {
        System.out.println("Name :"+name);
        System.out.println("Age :"+age);
       if(gender=='m'||gender=='M')System.out.println("Gender : Male");
       else if (gender=='f'||gender=='F') System.out.println("Gender: Female");
       else throw new IllegalArgumentException("Must be Male or Female");
       System.out.println("Balance  :"+Balance+"$");
       System.out.println("----------------------------------");
    }

    public void make_order(String name,int amount_needed )throws IllegalArgumentException
    {
        Scanner scan =new Scanner(System.in);
        for(int index=0;index<Pharmacy.item_count_in_pharmacy;index++)
        {
            if (p.items[index].name.equals(name))//item found 
            {
                if(p.items[index].count>=amount_needed)
                {
                    if(p.items[index].price*amount_needed>Balance)
                    {
                        System.out.println("Insfuccient Funds to Complete Process");
                    }
                    else 
                    {
                    p.place_order(index,amount_needed);
                    System.out.println("Order Placed Sucessfully");
                    }
                }
                else 
                {
                    System.out.println("Insuffcient Amount Of This Item, There are only "+p.items[index].count+
                    " Of It Left, So Please Ask for Diffrent Amount If 0 you will exit");
                    int amount =scan.nextInt();
                    scan.close();
                    if(amount>0)
                    {
                    make_order(name, amount);
                    }
                    else if (amount==0) 
                    {
                        return;
                    }
                    else 
                    {
                        throw new IllegalArgumentException();
                    }
                }
                return;
            }
        }
        scan.close();
         
    }


    public void main_menu()
    {
        Scanner s =new Scanner(System.in);
        System.out.println("Hello Mr/"+this.name+"  please choose a number from below");
        System.out.println("1)Display Self Data ");
        System.out.println("2) Make An Order ");
        
        int Decsion=s.nextInt();
        if(Decsion==1)this.display_self();
        else if(Decsion==2)
        {
            System.out.println("Please enter the name of the order and the amount needed");
            String temp_name =s.nextLine();
            int temp_amount_needed=s.nextInt();
            this.make_order(temp_name, temp_amount_needed);
        }
        s.close();
    }
    
    

}
